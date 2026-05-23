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

        Server serverPrd = new Server();
        serverPrd.setUrl("https://api.serratec.org/");
        serverPrd.setDescription("Api rodando no ambiente produtivo");

        Contact contact = new Contact();
        contact.setUrl("linkedin");
        contact.setEmail("usuario@gmail.com");
        contact.setName("Trabalho em grupo");

        Info info = new Info()
                .contact(contact)
                .description("Api e-commerce de venda de produtos")
                .title("Trabalho em grupo APIRest")
                .version(this.versao);

        return new OpenAPI().info(info).servers(List.of(server,serverPrd));
    }

}

