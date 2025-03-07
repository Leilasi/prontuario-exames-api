package com.clinica.service.impl;

import com.clinica.config.ExameConsumer;
import com.clinica.dto.request.FilaTriagemRequestDTO;
import com.clinica.dto.request.ProntuarioExameRequestDTO;
import com.clinica.dto.response.ProntuarioExameResponseDTO;
import com.clinica.model.Exame;
import com.clinica.model.Paciente;
import com.clinica.model.ProfissionalExame;
import com.clinica.model.ProntuarioExame;
import com.clinica.repository.ExameRepository;
import com.clinica.repository.PacienteRepository;
import com.clinica.repository.ProfissionalExameRepository;
import com.clinica.repository.ProntuarioExameRepository;
import com.clinica.service.ProntuarioExameService;
import com.clinica.utils.exception.EntidadeNaoEncontradaException;
import com.clinica.utils.exception.FilaVaziaException;
import com.clinica.utils.exception.NoContentException;
import com.clinica.utils.mapper.ProntuarioExameMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProntuarioExameServiceImpl  implements ProntuarioExameService {

    @Autowired
    private ProfissionalExameRepository profissionalExameRepository;

    @Autowired
    private ExameConsumer exameConsumer;

    @Autowired
    private ProntuarioExameRepository repository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private ExameRepository exameRepository;

    @Autowired
    private ProntuarioExameMapper mapper;


    @Override
    public ProntuarioExameResponseDTO adicionarProntuario(ProntuarioExameRequestDTO prontuarioExameDTO){
        ProntuarioExame prontuarioExame = new ProntuarioExame();
        Paciente pacienteExistente = verificarPaciente(prontuarioExameDTO.getCpfPaciente());
        Exame exameExistente = verificarTipoDeExameExistente(prontuarioExameDTO);
        ProfissionalExame profissionalExame = verificarProfissional(prontuarioExameDTO.getMatricula());

        if (pacienteExistente == null || exameExistente == null){
            throw new EntidadeNaoEncontradaException("Paciente ou tipo de exame não encontrado");
        }

        prontuarioExame.setPaciente(pacienteExistente);
        prontuarioExame.setExame(exameExistente);
        prontuarioExame.setDataExame(prontuarioExameDTO.getDataExame());
        prontuarioExame.setResultado(prontuarioExameDTO.getResultado());
        prontuarioExame.setProfissionalExame(profissionalExame);
        repository.save(prontuarioExame);

        return mapper.toResponseDTO(prontuarioExame);
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
    public List<ProntuarioExameResponseDTO> buscarPorCpf(String cpf) {
        ProntuarioExame prontuarioExame = new ProntuarioExame();
        Paciente paciente = verificarPaciente(cpf);

        List<ProntuarioExame> prontuarioExames = repository.findByPaciente(paciente);

        if(prontuarioExames.isEmpty()){
            throw new NoContentException("Nenhum prontuário encontrado para o paciente com CPF: " + cpf);
        }

        return  mapper.toResponseDTOList(prontuarioExames);
    }

    @Override
    public FilaTriagemRequestDTO buscarProximoFila(String matriculaProfissional) throws FilaVaziaException, EntidadeNaoEncontradaException {
        ProfissionalExame profissional = profissionalExameRepository.findByMatricula(matriculaProfissional);
        if (profissional == null) {
            throw new EntidadeNaoEncontradaException("Não existe profissional de exame registrado com a matricula informada");
        }
        exameConsumer.PROFISSIONAL_ALVO = profissional.getNome();
        FilaTriagemRequestDTO filaTriagemDTO = exameConsumer.consumirFila();
        if (filaTriagemDTO == null) {
            throw new FilaVaziaException("Não há paciente aguardando na fila de espera");
        }
        return filaTriagemDTO;
    }

    private Paciente verificarPaciente(String cpf){
        Paciente paciente =  pacienteRepository.findByCPF(cpf);

        if (paciente == null) {
            throw new EntidadeNaoEncontradaException("Paciente não encontrado com CPF: " + cpf);
        }

        return paciente;
    }

    private Exame verificarTipoDeExameExistente(ProntuarioExameRequestDTO prontuarioExameDTO){
        Exame exame = exameRepository.findByTipoExame(prontuarioExameDTO.getTipoExame());

        if (exame == null) {
            throw new EntidadeNaoEncontradaException("Tipo de exame não encontrado: " + prontuarioExameDTO.getTipoExame());
        }
        return exameRepository.findByTipoExame(prontuarioExameDTO.getTipoExame());
    }

    private ProfissionalExame verificarProfissional(String matricula) {
        ProfissionalExame profissional = profissionalExameRepository.findByMatricula(matricula);

        if (profissional == null) {
            throw new EntidadeNaoEncontradaException("Profissional de exame não encontrado com a matricula: " + matricula);
        }
        return profissional;
    }
}
