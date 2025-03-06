package com.clinica.utils.mapper;

import com.clinica.dto.response.ProntuarioExameResponseDTO;
import com.clinica.model.ProntuarioExame;
import org.springframework.stereotype.Component;

@Component
public class ProntuarioExameMapper {

    public ProntuarioExameResponseDTO toResponseDTO(ProntuarioExame prontuarioExame) {
        ProntuarioExameResponseDTO prontuarioExameDTO = new ProntuarioExameResponseDTO();
        prontuarioExameDTO.setDataExame(prontuarioExame.getDataExame());
        prontuarioExameDTO.setNomePaciente(prontuarioExame.getPaciente().getNome());
        prontuarioExameDTO.setCpfPaciente(prontuarioExame.getPaciente().getCPF());
        prontuarioExameDTO.setCarteirinhaSus(prontuarioExame.getPaciente().getNumeroCartaoSus());
    }
}
