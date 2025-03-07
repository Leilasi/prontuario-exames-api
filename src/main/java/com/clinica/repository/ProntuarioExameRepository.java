package com.clinica.repository;

import com.clinica.model.Paciente;
import com.clinica.model.ProntuarioExame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProntuarioExameRepository extends JpaRepository<ProntuarioExame, Long> {
    List<ProntuarioExame> findByPaciente(Paciente paciente);
}
