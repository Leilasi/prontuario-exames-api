package com.clinica.service;

import com.clinica.dto.FilaTriagemDTO;
import com.clinica.dto.ProntuarioExameDTO;
import com.clinica.model.ProntuarioExame;
import org.springframework.http.ResponseEntity;

import java.util.List;

 public interface ProntuarioExameService {

    void adicionarProntuario(ProntuarioExameDTO prontuarioExameDTO);
    List<ProntuarioExame> buscarTodos();  
    ProntuarioExame buscarPorId(Long id);
    List<ProntuarioExame> buscarPorCpf(String cpf);
    ProntuarioExame atualizarProntuario(Long id, ProntuarioExameDTO prontuarioExameDTO);
    void deletarProntuario(Long id);
    FilaTriagemDTO buscarProximoFila(String matriculaProfisional, Boolean abrirProximeTo);

}
