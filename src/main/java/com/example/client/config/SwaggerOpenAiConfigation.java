package com.example.client.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerOpenAiConfigation {

    @Value("${clientapp.openapi.dev-url}")
    private String devUrl;

    @Value("${clientapp.openapi.prod-url}")
    private String prodUrl;

    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server URL in Development environment");

        Server prodServer = new Server();
        prodServer.setUrl(prodUrl);
        prodServer.setDescription("Server URL in Production environment");

        Contact contact = new Contact();
        contact.setEmail("support@clientapp.com");
        contact.setName("Client APP");
        contact.setUrl("https://www.clientapp.com");

        License mitLicense = new License().name("MIT License").url("https://google.com/");

        Info info = new Info()
                .title("client APP Online API")
                .version("1.0")
                .contact(contact)
                .description("This API exposes endpoints to manage client APP Online.").termsOfService("https://www.clientapp.com.br/terms")
                .license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
    }
}