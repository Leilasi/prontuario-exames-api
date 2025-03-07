package com.clinica.utils.mapper;

import com.clinica.dto.response.ProntuarioExameResponseDTO;
import com.clinica.model.ProntuarioExame;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProntuarioExameMapper {

    public ProntuarioExameResponseDTO toResponseDTO(ProntuarioExame prontuarioExame) {
        ProntuarioExameResponseDTO prontuarioExameDTO = new ProntuarioExameResponseDTO();
        prontuarioExameDTO.setId(prontuarioExame.getId());
        prontuarioExameDTO.setTipoExame(prontuarioExame.getExame().gettipoExame());
        prontuarioExameDTO.setResultado(prontuarioExame.getResultado());
        prontuarioExameDTO.setDataExame(prontuarioExame.getDataExame());
        prontuarioExameDTO.setProfissionalExame(prontuarioExame.getProfissionalExame().getNome());
        prontuarioExameDTO.setDataExame(prontuarioExame.getDataExame());
        prontuarioExameDTO.setSexo(prontuarioExame.getPaciente().getGenero());
        prontuarioExameDTO.setNomePaciente(prontuarioExame.getPaciente().getNome());
        prontuarioExameDTO.setCpfPaciente(prontuarioExame.getPaciente().getCPF());
        prontuarioExameDTO.setDataNascimento(prontuarioExame.getPaciente().getDataNascimento());
        prontuarioExameDTO.setCarteirinhaSus(prontuarioExame.getPaciente().getNumeroCartaoSus());
        prontuarioExameDTO.setResponsavelPaciente(prontuarioExame.getPaciente().getResponsavel());

        return prontuarioExameDTO;
    }

    public List<ProntuarioExameResponseDTO> toResponseDTOList(List<ProntuarioExame> prontuarioExame) {
        List<ProntuarioExameResponseDTO> responseDTOList = new ArrayList<>();

        for (ProntuarioExame prontuarios : prontuarioExame){
            ProntuarioExameResponseDTO prontuarioExameDTO = new ProntuarioExameResponseDTO();
            prontuarioExameDTO.setId(prontuarios.getId());
            prontuarioExameDTO.setDataExame(prontuarios.getDataExame());
            prontuarioExameDTO.setResultado(prontuarios.getResultado());
            prontuarioExameDTO.setTipoExame(prontuarios.getExame().gettipoExame());
            prontuarioExameDTO.setNomePaciente(prontuarios.getPaciente().getNome());
            prontuarioExameDTO.setCpfPaciente(prontuarios.getPaciente().getCPF());
            prontuarioExameDTO.setCarteirinhaSus(prontuarios.getPaciente().getNumeroCartaoSus());
            prontuarioExameDTO.setProfissionalExame(prontuarios.getProfissionalExame().getNome());
            prontuarioExameDTO.setDataNascimento(prontuarios.getProfissionalExame().getDataNascimento());
            prontuarioExameDTO.setResponsavelPaciente(prontuarios.getPaciente().getResponsavel());
            prontuarioExameDTO.setSexo(prontuarios.getPaciente().getGenero());

            responseDTOList.add(prontuarioExameDTO);
        }

        return responseDTOList;
    }


}
