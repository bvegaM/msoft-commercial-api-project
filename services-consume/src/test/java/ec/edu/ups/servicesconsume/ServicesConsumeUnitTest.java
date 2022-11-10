package ec.edu.ups.servicesconsume;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import ec.edu.ups.servicesconsume.entity.ServicePartner;
import ec.edu.ups.servicesconsume.entity.dto.ServicePartnerDTO;
import ec.edu.ups.servicesconsume.service.ServicePartnerService;
import ec.edu.ups.servicesconsume.web.ServicePartnerController;
import net.bytebuddy.asm.Advice;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.NestedServletException;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ServicePartnerController.class)
public class ServicesConsumeUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServicePartnerService partnerService;

    @MockBean
    private RestTemplate restTemplate;

    private static ObjectMapper mapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            .setSerializationInclusion(JsonInclude.Include.NON_NULL);

    @Test
    public void getServicePartnerShouldReturnEmpty() throws Exception{
        when(partnerService.findAll()).thenReturn(new ArrayList<>());

        mockMvc.perform(get("/servicePartners/v1/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]"));

        verify(partnerService, times(1)).findAll();
    }

    @Test
    public void getServicePartnerShouldReturnListOk() throws Exception{
        List<ServicePartner> list = List.of(new ServicePartner("1234","Servicio Prueba", "Active", LocalDate.now(),
                LocalDate.now(),"Some detail"));
        when(partnerService.findAll()).thenReturn(list);

        mockMvc.perform(get("/servicePartners/v1/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(mapper.writeValueAsString(list)));

        verify(partnerService, times(1)).findAll();
    }

    @Test
    public void getServicePartnerByCodeShouldReturnOk() throws Exception{

        String expectedCode = "1234";
        ServicePartner expectedValue = new ServicePartner(expectedCode,"Some service","Disabled",
                LocalDate.now(), LocalDate.now(), "Some detail...");
        when(partnerService.findByCode(expectedCode)).thenReturn(expectedValue);

        mockMvc.perform(get("/servicePartners/v1/code/%s".formatted(expectedCode)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(mapper.writeValueAsString(expectedValue.convertDTO())));

        verify(partnerService, times(1)).findByCode(expectedCode);
    }

    @Test
    public void getServicePartnerByCodeShouldReturnEmpty() throws Exception{
        String expectedCode = "1234";
        when(partnerService.findByCode(expectedCode)).thenThrow(NoSuchElementException.class);

        Assertions.assertThatThrownBy(()->mockMvc.perform(get("/servicePartners/v1/code/%s".formatted(expectedCode))))
                .hasCauseInstanceOf(NoSuchElementException.class);

        verify(partnerService, times(1)).findByCode(expectedCode);
    }
}
