package com.clinica.repository;

import com.clinica.model.ProfissionalExame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfissionalExameRepository extends JpaRepository<ProfissionalExame, Long> {

    ProfissionalExame findByMatricula(String matriculaProfissional);
}
