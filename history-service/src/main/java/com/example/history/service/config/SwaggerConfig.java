package com.example.history.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(subscriptionsApiInfo())
                .select().apis(RequestHandlerSelectors.basePackage("com.example.history.service.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo subscriptionsApiInfo() {
        return new ApiInfoBuilder()
                .title("History Services ")
                .license("MIT - License")
                .description("Backend Services History")
                .version("1.0.0")
                .contact(new Contact("Bryam David Vega Moreno","https://github.com/bvegaM","vegabryam40@gmail.com"))
                .build();
    }
}
