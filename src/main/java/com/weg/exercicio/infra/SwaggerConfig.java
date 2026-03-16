package com.weg.exercicio.infra;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Atividade de Documentação de APIRest")
                        .version("1.0.0")
                        .description("Documentação da API de carros, e outros temas diversos")
                        .contact(new Contact()
                                .name("Lorhan Pierre")
                                .email("lorhan_p_melo@estudante.sesisenai.org.br")
                        )
                );
    }
}
