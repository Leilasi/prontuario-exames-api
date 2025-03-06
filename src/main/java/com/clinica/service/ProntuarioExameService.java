package com.clinica.service;

import com.clinica.dto.request.FilaTriagemRequestDTO;
import com.clinica.dto.request.ProntuarioExameRequestDTO;
import com.clinica.model.ProntuarioExame;
import com.clinica.utils.exception.EntidadeNaoEncontradaException;
import com.clinica.utils.exception.FilaVaziaException;

import java.util.List;

 public interface ProntuarioExameService {

    void adicionarProntuario(ProntuarioExameRequestDTO prontuarioExameDTO);
    List<ProntuarioExame> buscarTodos();  
    ProntuarioExame buscarPorId(Long id);
    List<ProntuarioExame> buscarPorCpf(String cpf);
    ProntuarioExame atualizarProntuario(Long id, ProntuarioExameRequestDTO prontuarioExameDTO);
    void deletarProntuario(Long id);
    FilaTriagemRequestDTO buscarProximoFila(String matriculaProfisional) throws FilaVaziaException, EntidadeNaoEncontradaException;

}
