package com.clinica.service.impl;

import com.clinica.config.ExameConsumer;
import com.clinica.dto.FilaTriagemDTO;
import com.clinica.dto.ProntuarioExameDTO;
import com.clinica.model.ProfissionalExame;
import com.clinica.model.ProntuarioExame;
import com.clinica.repository.ProfissionalExameRepository;
import com.clinica.repository.ProntuarioExameRepository;
import com.clinica.service.ProntuarioExameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProntuarioExameServiceImpl  implements ProntuarioExameService {

    @Autowired
    private ProfissionalExameRepository profissionalExameRepository;

    @Autowired
    private ExameConsumer exameConsumer;

    @Autowired
    private ProntuarioExameRepository repository;

    @Override
    public void adicionarProntuario(ProntuarioExameDTO prontuarioExameDTO) {
        ProntuarioExame prontuarioExame = new ProntuarioExame();
        prontuarioExame.setCpfPaciente(prontuarioExameDTO.getCpfPaciente());
        prontuarioExame.setTipoExame(prontuarioExameDTO.getTipoExame());
        prontuarioExame.setDataExame(prontuarioExameDTO.getDataExame());
        prontuarioExame.setResultado(prontuarioExameDTO.getResultado());
        repository.save(prontuarioExame);
    }

    @Override
    public List<ProntuarioExame> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public ProntuarioExame buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prontuário não encontrado com o ID: " + id));
    }

    @Override
    public List<ProntuarioExame> buscarPorCpf(String cpf) {
        return repository.findByCpfPaciente(cpf);
    }

    @Override
    public ProntuarioExame atualizarProntuario(Long id, ProntuarioExameDTO prontuarioExameDTO) {
        ProntuarioExame prontuarioExame = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prontuário não encontrado com o ID: " + id));

        prontuarioExame.setCpfPaciente(prontuarioExameDTO.getCpfPaciente());
        prontuarioExame.setTipoExame(prontuarioExameDTO.getTipoExame());
        prontuarioExame.setDataExame(prontuarioExameDTO.getDataExame());
        prontuarioExame.setResultado(prontuarioExameDTO.getResultado());

        return repository.save(prontuarioExame);
    }

    @Override
    public void deletarProntuario(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Prontuário não encontrado com o ID: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public FilaTriagemDTO buscarProximoFila(String matriculaProfissional, Boolean abrirProximeTo) {
        ProfissionalExame profissional = profissionalExameRepository.findByMatricula(matriculaProfissional);
        exameConsumer.PROFISSIONAL_ALVO = profissional.getNome();
        FilaTriagemDTO filaTriagemDTO = exameConsumer.consumirFila();
        return filaTriagemDTO;
    }



}
