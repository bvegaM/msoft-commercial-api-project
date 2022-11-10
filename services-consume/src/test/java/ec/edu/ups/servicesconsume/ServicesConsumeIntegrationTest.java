package ec.edu.ups.servicesconsume;

import ec.edu.ups.servicesconsume.entity.dto.ServicePartnerDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ServicesConsumeIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String getBaseURI(){
        return "http://localhost:"+port+"/servicePartners/v1/";
    }

    @Test
    public void getAllPartnerServices(){
        ResponseEntity<List> response =
                restTemplate.getForEntity(getBaseURI(), List.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    public void getPartnerServiceById(){
        ResponseEntity<ServicePartnerDTO> response =
                restTemplate.getForEntity(getBaseURI()+"1", ServicePartnerDTO.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }
}
