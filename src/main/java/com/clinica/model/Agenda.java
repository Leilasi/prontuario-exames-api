package com.clinica.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "agenda")
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "medico_id", nullable = false)
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "especialidade_codigo", nullable = true)
    private Especialidade especialidade;

    private LocalDateTime dataHoraConsulta;

    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean livre = true;

    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean retorno = false;

    @ManyToOne(cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "paciente_id", referencedColumnName = "id")
    private Paciente paciente;

    public Agenda() {
    }

    public Agenda(Medico medico, Especialidade especialidade, LocalDateTime dataHoraConsulta) {
        this.medico = medico;
        this.especialidade = especialidade;
        this.dataHoraConsulta = dataHoraConsulta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public LocalDateTime getDataHoraConsulta() {
        return dataHoraConsulta;
    }

    public void setDataHoraConsulta(LocalDateTime dataHoraConsulta) {
        this.dataHoraConsulta = dataHoraConsulta;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public boolean isLivre() {
        return livre;
    }

    public void setLivre(boolean livre) {
        this.livre = livre;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public boolean isRetorno() {
        return retorno;
    }

    public void setRetorno(boolean retorno) {
        this.retorno = retorno;
    }

    @Override
    public String toString() {
        return "Agenda{" +
                "Dr=" + medico.getNome() +
                ", Especialidade=" + especialidade.getEspecialidade() +
                ", dataHoraConsulta=" + dataHoraConsulta +
                ", livre=" + livre +
                ", paciente=" + paciente.getNome() +
                '}';
    }
}
