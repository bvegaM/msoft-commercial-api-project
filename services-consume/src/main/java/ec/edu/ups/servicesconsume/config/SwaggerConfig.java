package ec.edu.ups.servicesconsume.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(subscriptionsApiInfo())
                .select().apis(RequestHandlerSelectors.basePackage("ec.edu.ups.servicesconsume.web"))
                .paths(PathSelectors.any())
                .build()
                .produces(Set.of("application/json"));
    }

    private ApiInfo subscriptionsApiInfo() {
        return new ApiInfoBuilder()
                .title("Consuming Services ")
                .license("MIT - License")
                .description("Aggregator Service")
                .version("1.0.0")
                .contact(new Contact("All team","https://api.commercial.com","support@commercial.com"))
                .build();
    }
}
