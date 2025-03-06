package com.clinica.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "prontuario_exame")
public class ProntuarioExame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = true)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "exame_id", nullable = true)
    private Exame exame;

    @ManyToOne
    @JoinColumn(name = "profissioanl_exame_id", nullable = true)
    private ProfissionalExame profissionalExame;

    @Column(name = "data_exame", nullable = false)
    private LocalDateTime dataExame;

    @Column(name = "resultado", nullable = false)
    private String resultado;

    public ProntuarioExame() {
    }

    public ProntuarioExame(Long id, Paciente paciente, Exame exame, ProfissionalExame profissionalExame, LocalDateTime dataExame, String resultado) {
        this.id = id;
        this.paciente = paciente;
        this.exame = exame;
        this.profissionalExame = profissionalExame;
        this.dataExame = dataExame;
        this.resultado = resultado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Exame getExame() {
        return exame;
    }

    public void setExame(Exame exame) {
        this.exame = exame;
    }

    public ProfissionalExame getProfissionalExame() {
        return profissionalExame;
    }

    public void setProfissionalExame(ProfissionalExame profissionalExame) {
        this.profissionalExame = profissionalExame;
    }

    public LocalDateTime getDataExame() {
        return dataExame;
    }

    public void setDataExame(LocalDateTime dataExame) {
        this.dataExame = dataExame;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProntuarioExame that = (ProntuarioExame) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "ProntuarioExame{" +
                "id=" + id +
                ", paciente=" + paciente +
                ", exame=" + exame +
                ", profissionalExame=" + profissionalExame +
                ", dataExame=" + dataExame +
                ", resultado='" + resultado + '\'' +
                '}';
    }
}
