package com.clinica.model;

import jakarta.persistence.*;

@Entity(name = "prontuarioMedico")
public class ProntuarioMedico {

    @Id
    private Long codigo;

    @ManyToOne(cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @ManyToOne(cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "especialidade_codigo", nullable = false)
    private Especialidade especialidade;

    @ManyToOne(cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "medico_id", nullable = false)
    private Medico medico;
    private String relatorioId;

    public ProntuarioMedico() {
    }

    public ProntuarioMedico(Long codigo,
                            Paciente paciente,
                            Especialidade especialidade,
                            Medico medico,
                            String relatorioId) {
        this.codigo = codigo;
        this.paciente = paciente;
        this.especialidade = especialidade;
        this.medico = medico;
        this.relatorioId = relatorioId;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public String getRelatorioId() {
        return relatorioId;
    }

    public void setRelatorioId(String relatorioId) {
        this.relatorioId = relatorioId;
    }

    @Override
    public String toString() {
        return "ProntuarioMedico{" +
                "codigo=" + codigo +
                ", paciente=" + paciente +
                ", especialidade=" + especialidade +
                ", medico=" + medico +
                ", relatorioId='" + relatorioId + '\'' +
                '}';
    }
}
