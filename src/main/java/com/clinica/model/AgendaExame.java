package com.clinica.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "agenda_exame")
public class AgendaExame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "profissional_id")
    private ProfissionalExame profissional;

    @ManyToOne
    @JoinColumn(name = "tipoExame", nullable = true)
    private Exame tipoExame;

    private LocalDateTime dataHoraExame;

    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean livre = true;

    @ManyToOne(cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "paciente_id", referencedColumnName = "id")
    private Paciente paciente;

    public AgendaExame() {
    }

    public AgendaExame(Long id, ProfissionalExame profissional, Exame tipoExame, LocalDateTime dataHoraExame, Boolean livre, Paciente paciente) {
        this.id = id;
        this.profissional = profissional;
        this.tipoExame = tipoExame;
        this.dataHoraExame = dataHoraExame;
        this.livre = livre;
        this.paciente = paciente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProfissionalExame getProfissional() {
        return profissional;
    }

    public void setProfissional(ProfissionalExame profissional) {
        this.profissional = profissional;
    }

    public Exame getTipoExame() {
        return tipoExame;
    }

    public void setTipoExame(Exame tipoExame) {
        this.tipoExame = tipoExame;
    }

    public LocalDateTime getDataHoraExame() {
        return dataHoraExame;
    }

    public void setDataHoraExame(LocalDateTime dataHoraExame) {
        this.dataHoraExame = dataHoraExame;
    }

    public Boolean getLivre() {
        return livre;
    }

    public void setLivre(Boolean livre) {
        this.livre = livre;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
