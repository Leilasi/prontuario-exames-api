package com.clinica.service;

import com.clinica.dto.ProntuarioExameMensagem;
import com.clinica.model.ProntuarioExame;
import com.clinica.repository.ProntuarioExameRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProntuarioExameConsumer {

    @Autowired
    private ProntuarioExameRepository repository;

    @Autowired
    private ObjectMapper objectMapper; // Jackson para desserializar JSON

    @RabbitListener(queues = "prontuario-exame-queue")
    public void receberMensagem(String mensagem) {
        try {
            // 1. Desserializar o JSON para um objeto ProntuarioExameMensagem
            ProntuarioExameMensagem prontuarioExameMensagem = objectMapper.readValue(mensagem, ProntuarioExameMensagem.class);

            // 2. Processar os dados (ex: salvar no banco de dados)
            ProntuarioExame prontuarioExame = new ProntuarioExame();
            prontuarioExame.setCpfPaciente(prontuarioExameMensagem.getCpfPaciente());
            prontuarioExame.setTipoExame(prontuarioExameMensagem.getTipoExame());
            prontuarioExame.setDataExame(prontuarioExameMensagem.getDataExame());
            prontuarioExame.setResultado(prontuarioExameMensagem.getResultado());

            repository.save(prontuarioExame);

            System.out.println("Prontuário de exame salvo com sucesso: " + prontuarioExameMensagem);
        } catch (Exception e) {
            System.err.println("Erro ao processar mensagem: " + e.getMessage());
        }
    }
}
