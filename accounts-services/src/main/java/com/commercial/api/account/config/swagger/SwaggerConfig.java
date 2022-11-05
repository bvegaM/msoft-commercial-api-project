package com.commercial.api.account.config.swagger;

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
                .securitySchemes(Collections.singletonList(apiKey()))
                .apiInfo(subscriptionsApiInfo())
                .select().apis(RequestHandlerSelectors.basePackage("com.commercial.api.account.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiKey apiKey(){
        return new ApiKey("JWT", "Authorization", "header");
    }

    private ApiInfo subscriptionsApiInfo() {
        return new ApiInfoBuilder()
                .title("Account Services ")
                .license("MIT - License")
                .description("Backend Services Accounts")
                .version("1.0.0")
                .contact(new Contact("Bryam David Vega Moreno","https://github.com/bvegaM","vegabryam40@gmail.com"))
                .build();
    }
}
