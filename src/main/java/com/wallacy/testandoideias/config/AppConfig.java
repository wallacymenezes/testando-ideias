// Local do arquivo: src/main/java/com/wallacy/testandoideias/config/AppConfig.java
package com.wallacy.testandoideias.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Classe de configuração para registrar Beans gerais da aplicação.
 */
@Configuration
public class AppConfig {

    /**
     * Cria e configura um Bean do tipo RestTemplate.
     * Este Bean poderá ser injetado em outros componentes, como Services,
     * para realizar requisições HTTP para outras APIs.
     * @return uma instância de RestTemplate.
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}