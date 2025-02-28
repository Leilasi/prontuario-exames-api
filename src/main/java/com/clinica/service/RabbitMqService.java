package com.clinica.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void encaminhaMensagem(String fila, Object mensagem) {
        rabbitTemplate.convertAndSend(fila, mensagem);
    }
}
