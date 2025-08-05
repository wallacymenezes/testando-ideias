package com.wallacy.testandoideias.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {

    @Autowired
    private RestTemplate restTemplate;

    public void sendPaymentNotification(String paymentData) {
        String destinationUrl = "https://outra-plataforma.com/webhooks/payment";

        try {
            // Cria um objeto para representar o corpo da requisição
            // Map<String, Object> requestBody = new HashMap<>();
            // requestBody.put("data", paymentData);

            // Envia a requisição POST
            restTemplate.postForObject(destinationUrl, paymentData, String.class);
            System.out.println("Webhook de notificação enviado com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao enviar webhook de notificação: " + e.getMessage());
        }
    }

    // Você precisará de um Bean para o RestTemplate
    // Pode ser em uma classe de configuração
    /*
    @Configuration
    public class AppConfig {
        @Bean
        public RestTemplate restTemplate() {
            return new RestTemplate();
        }
    }
    */
}