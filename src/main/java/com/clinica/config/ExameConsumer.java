package com.clinica.config;

import com.clinica.dto.FilaTriagemDTO;
import com.clinica.exception.NoContentException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ExameConsumer {

    public String PROFISSIONAL_ALVO = "";

    @Value("${rabbitmq.queue.exames}")
    private String FILA_CONSULTAS;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public FilaTriagemDTO consumirFila() {
        List<FilaTriagemDTO> mensagens = new ArrayList<>();
        FilaTriagemDTO selecionado = consumirPrimeiraMensagemFila(mensagens);

        for (FilaTriagemDTO msg : mensagens) {
            rabbitTemplate.convertAndSend(FILA_CONSULTAS, msg);
        }

        if (selecionado == null) {
            throw new NoContentException("Nenhum paciente a espera para " + PROFISSIONAL_ALVO);
        }
        return selecionado;
    }

    public FilaTriagemDTO consumirPrimeiraMensagemFila(List<FilaTriagemDTO> mensagens) {
        FilaTriagemDTO selecionado = null;

        while (true) {
            Message message = rabbitTemplate.receive(FILA_CONSULTAS);
            if (message == null) break;

            try {
                FilaTriagemDTO mensagem = objectMapper.readValue(message.getBody(), FilaTriagemDTO.class);

                if (selecionado == null && PROFISSIONAL_ALVO.equals(mensagem.getNomeProfissional())) {
                    selecionado = mensagem;
                } else {
                    mensagens.add(mensagem);
                }
            } catch (Exception e) {
                throw new RuntimeException("Erro ao deserializar a mensagem da fila", e);
            }
        }
        return selecionado;
    }


}
