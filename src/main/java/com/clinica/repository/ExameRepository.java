package com.clinica.repository;

import com.clinica.model.Exame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExameRepository extends JpaRepository<Exame, Long> {
    Exame findByTipoExame(String tipoExame);
}
