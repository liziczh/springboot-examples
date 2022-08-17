package com.liziczh.springboot.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@EnableOpenApi
@Configuration
public class Swagger2Config {
    public static final String SWAGGER_SCAN_BASE_PACKAGE = "com.liziczh";

    @Bean
    public Docket docket(Environment env) {
        boolean enable = env.acceptsProfiles(Profiles.of("dev", "test"));
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(enable)
                .select()
                .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Archetype REST API")
                .description("Swagger API")
                .contact(new Contact("栗子", "https://github.com/liziczh", "liziczh@foxmail.com"))
                .version("1.0")
                .build();
    }
}
