package com.example.currencyConverterApi.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class SwaggerConfig {
    /**
     * SWAGGER URL: http://localhost:8080/swagger-ui/index.html
     *
     */
    @Bean
    public GroupedOpenApi api() {
        return GroupedOpenApi.builder()
                .pathsToMatch("/api/**")
                .group("CurrencyConverter")
                .build();
    }
}