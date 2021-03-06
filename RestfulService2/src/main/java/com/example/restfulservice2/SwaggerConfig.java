package com.example.restfulservice2;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig{
    @Bean
    public InternalResourceViewResolver defaultViewResolver() {
        return new InternalResourceViewResolver();

    }

    public static final Contact DEFAULT_CONTACT = new Contact("Lavanya Tyagi", "hhtp://www.google.com", "lavanyatyagi23@gmail.com");
    public static final ApiInfo DEFAULT = new ApiInfo("API Documentation", "API Documentation", "1.0", "urn:tos", DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList());
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT);
    }
}
