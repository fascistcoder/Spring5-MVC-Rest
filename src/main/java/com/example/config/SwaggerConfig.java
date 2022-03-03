package com.example.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="pulkit.aggarwal@upgrad.com">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 03/03/22
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI metaData(){
        Contact contact = new Contact();
        contact.setName("Pulkit Aggarwal");
        contact.setEmail("gargpulkit234@gmail.com");
        contact.setUrl("https://github.com/fascistcoder");

        return new OpenAPI()
                .info(new Info().title("RestAPI Demo")
                        .description("Demo of restful web services with spring")
                        .version("v0.0.1")
                        .termsOfService("Terms of service")
                        .license(new License().name("Apache license").url("https://springshop.wiki.github.org/docs")));
    }
}
