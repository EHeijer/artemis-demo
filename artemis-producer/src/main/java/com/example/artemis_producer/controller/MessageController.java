package com.example.artemis_producer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.transaction.annotation.Transactional;

@RestController
public class MessageController {


    private final JmsTemplate jmsTemplate;

    public MessageController(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @GetMapping("/send")
    @Transactional
    public String sendMessage(@RequestParam String message) {
        jmsTemplate.convertAndSend("test-queue", message);
        return "Message sent!";
    }
}
