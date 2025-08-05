package com.wallacy.testandoideias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebhookController {

    private static final String WEBHOOK_TOPIC = "facebook-webhooks";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/webhooks/facebook")
    public void receiveFacebookWebhook(@RequestBody String payload) {
        // Envia o corpo do webhook (payload) para o tópico do Kafka
        System.out.println("Webhook recebido, enviando para a fila Kafka...");
        kafkaTemplate.send(WEBHOOK_TOPIC, payload);
    }
}