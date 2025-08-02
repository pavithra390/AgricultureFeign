package com.example.agriculturefeign;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springdoc.core.models.GroupedOpenApi;
import io.swagger.v3.oas.models.info.Info;
@Configuration
public class SwaggerConfig
{
    @Bean
    public GroupedOpenApi httpApi() {
        return GroupedOpenApi.builder()
                .group("http")
                .pathsToMatch("/consumer/**")
                .build();
    }
    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI().info(new Info().title("Spring Boot-API").version("1.0.0"));
    }

}
//http://localhost:1992/swagger-ui/index.html

