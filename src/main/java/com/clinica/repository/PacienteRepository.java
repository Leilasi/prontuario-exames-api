package com.clinica.repository;

import com.clinica.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    Paciente findByCPF(String cpfPaciente);

    boolean existsByCPF(String cpf);
}
