package com.clinica.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Random;

@Entity(name = "profissional_exame")
public class ProfissionalExame extends Pessoa{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "tipo", referencedColumnName = "codigo")
    private Exame tipoExame;
    private LocalDate dataAdmissao;
    private LocalDate dataDemissao;
    private boolean atendendo = false;
    private String matricula;

    public ProfissionalExame(Long id, String nome, Endereco endereco, String celular, String email, LocalDate dataNascimento, String genero, String RG, String CPF, boolean gestante, LocalDate dataDeCadastro, boolean profissionalUBS, Long id1, Exame tipoExame, LocalDate dataAdmissao, LocalDate dataDemissao, boolean atendendo, String matricula) {
        super(id, nome, endereco, celular, email, dataNascimento, genero, RG, CPF, gestante, dataDeCadastro, profissionalUBS);
        this.id = id1;
        this.tipoExame = tipoExame;
        this.dataAdmissao = dataAdmissao;
        this.dataDemissao = dataDemissao;
        this.atendendo = atendendo;
        this.matricula = matricula;
    }

    public ProfissionalExame() {
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Exame getTipoExame() {
        return tipoExame;
    }

    public void setTipoExame(Exame tipoExame) {
        this.tipoExame = tipoExame;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public LocalDate getDataDemissao() {
        return dataDemissao;
    }

    public void setDataDemissao(LocalDate dataDemissao) {
        this.dataDemissao = dataDemissao;
    }

    public boolean isAtendendo() {
        return atendendo;
    }

    public void setAtendendo(boolean atendendo) {
        this.atendendo = atendendo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "ProfissionalExame{" +
                "id=" + id +
                ", tipoExame=" + tipoExame +
                ", dataAdmissao=" + dataAdmissao +
                ", dataDemissao=" + dataDemissao +
                ", atendendo=" + atendendo +
                ", matricula='" + matricula + '\'' +
                '}';
    }
}
