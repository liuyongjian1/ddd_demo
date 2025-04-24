package com.example.infrastructure.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springdoc.core.GroupedOpenApi;

@Configuration
public class SwaggerConfig {
   @Value("${knife4j.enable}")
   private boolean enable;

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("DDD Demo API")
                        .description("Domain Driven Design 示例项目 API 文档")
                        .version("v1.0.0")
                        .license(new License().name("Apache 2.0").url("https://github.com/liuyongjian1")))
                .externalDocs(new ExternalDocumentation()
                        .description("项目 Wiki 文档")
                        .url("https://github.com/liuyongjian1/ddd_demo"));
    }

    @Bean
    public GroupedOpenApi publicApi() {
        if (!enable) {
            return null;
        }
        return GroupedOpenApi.builder()
                .group("public")
                .pathsToMatch("/api/**")
                .build();
    }
   

} 