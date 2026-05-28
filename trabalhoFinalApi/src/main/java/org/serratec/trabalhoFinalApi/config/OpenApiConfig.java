package org.serratec.trabalhoFinalApi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    private String versao;

    public OpenApiConfig(@Value("${api.versao}") String versao) {
        this.versao = versao;
    }

    @Bean
    public OpenAPI config() {
        Server server = new Server();
        server.setUrl("http://localhost:8080/api/v1");
        server.setDescription("Api rodando localmente");

        Contact contact = new Contact();
        contact.setUrl("https://github.com/natasha-mendonca/Trabalho-Final-API.git");
        contact.setEmail("c.carvalho@docente.senai.br");
        contact.setName("Trabalho em grupo");

        Info info = new Info()
                .contact(contact)
                .description("Trabalho em grupo APIRest")
                .title("Api e-commerce de venda de produtos")
                .version(this.versao);

        return new OpenAPI().info(info).servers(List.of(server));
    }

}

