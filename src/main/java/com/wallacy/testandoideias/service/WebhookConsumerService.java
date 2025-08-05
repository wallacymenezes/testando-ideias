package com.wallacy.testandoideias.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class WebhookConsumerService {

    @KafkaListener(topics = "facebook-webhooks", groupId = "webhook-group")
    public void processWebhook(String payload) {
        // Lógica para processar o webhook
        System.out.println("Processando webhook da fila: " + payload);
        // Ex: Deserializar o JSON, chamar a API do bot, salvar no banco, etc.
    }
}