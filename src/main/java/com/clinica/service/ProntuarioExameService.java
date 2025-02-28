package com.clinica.service;

import com.clinica.dto.ProntuarioExameDTO;
import com.clinica.model.ProntuarioExame;
import com.clinica.repository.ProntuarioExameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProntuarioExameService {

    @Autowired
    private ProntuarioExameRepository repository;

    public void adicionarProntuario(ProntuarioExameDTO prontuarioExameDTO) {
        ProntuarioExame prontuarioExame = new ProntuarioExame();
        prontuarioExame.setCpfPaciente(prontuarioExameDTO.getCpfPaciente());
        prontuarioExame.setTipoExame(prontuarioExameDTO.getTipoExame());
        prontuarioExame.setDataExame(prontuarioExameDTO.getDataExame());
        prontuarioExame.setResultado(prontuarioExameDTO.getResultado());
        repository.save(prontuarioExame);
    }

    // Buscar todos os prontuários
    public List<ProntuarioExame> buscarTodos() {
        return repository.findAll();
    }

    // Buscar prontuário por ID
    public ProntuarioExame buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prontuário não encontrado com o ID: " + id));
    }

    // Buscar prontuários por CPF do paciente
    public List<ProntuarioExame> buscarPorCpf(String cpf) {
        return repository.findByCpfPaciente(cpf);
    }

    // Atualizar prontuário
    public ProntuarioExame atualizarProntuario(Long id, ProntuarioExameDTO prontuarioExameDTO) {
        ProntuarioExame prontuarioExame = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prontuário não encontrado com o ID: " + id));

        prontuarioExame.setCpfPaciente(prontuarioExameDTO.getCpfPaciente());
        prontuarioExame.setTipoExame(prontuarioExameDTO.getTipoExame());
        prontuarioExame.setDataExame(prontuarioExameDTO.getDataExame());
        prontuarioExame.setResultado(prontuarioExameDTO.getResultado());

        return repository.save(prontuarioExame);
    }

    // Deletar prontuário
    public void deletarProntuario(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Prontuário não encontrado com o ID: " + id);
        }
        repository.deleteById(id);
    }
}
