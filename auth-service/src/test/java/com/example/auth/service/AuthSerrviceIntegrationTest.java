package com.example.auth.service;

import com.example.auth.service.dto.AuthUserDto;
import com.example.auth.service.dto.TokenDto;
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
public class AuthSerrviceIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String getBaseURI(){
        return "http://localhost:"+port+"/auth/";
    }

    @Test
    public void validateTokenWithBadRequest(){
        ResponseEntity<TokenDto> response =
                restTemplate.postForEntity(getBaseURI().concat("/validate"),"asdasdsadsadasd", TokenDto.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.BAD_REQUEST));
    }

    @Test
    public void authUserWithOkResponse(){
        AuthUserDto authUserDto = AuthUserDto.builder().username("admin").password("admin.123").build();
        ResponseEntity<TokenDto> response =
                restTemplate.postForEntity(getBaseURI().concat("/authenticate"),authUserDto, TokenDto.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }
}
