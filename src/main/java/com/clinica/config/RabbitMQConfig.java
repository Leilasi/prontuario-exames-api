package com.clinica.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.amqp.core.Queue;


@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue prontuarioExameQueue() {
        return new Queue("prontuario-exame-queue", true);
    }
}
