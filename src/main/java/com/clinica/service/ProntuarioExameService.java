package com.clinica.service;

import com.clinica.dto.request.FilaTriagemRequestDTO;
import com.clinica.dto.request.ProntuarioExameRequestDTO;
import com.clinica.dto.response.ProntuarioExameResponseDTO;
import com.clinica.model.ProntuarioExame;
import com.clinica.utils.exception.EntidadeNaoEncontradaException;
import com.clinica.utils.exception.FilaVaziaException;

import java.util.List;

 public interface ProntuarioExameService {

    ProntuarioExameResponseDTO adicionarProntuario(ProntuarioExameRequestDTO prontuarioExameDTO) throws EntidadeNaoEncontradaException;
    List<ProntuarioExame> buscarTodos();  
    ProntuarioExame buscarPorId(Long id);
    List<ProntuarioExameResponseDTO> buscarPorCpf(String cpf);
    FilaTriagemRequestDTO buscarProximoFila(String matriculaProfisional) throws FilaVaziaException, EntidadeNaoEncontradaException;

}
