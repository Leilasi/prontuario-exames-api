package com.clinica.model;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity(name = "medico")
public class Medico extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "especialidade_codigo", referencedColumnName = "codigo")
    private Especialidade especialidade;
    private boolean especialista;  // Médicos com mais de 10 anos de experiência
    private int anosExperiencia;
    private LocalDate dataAdmissao;
    private LocalDate dataDemissao;
    private String CRM;
    private String conselho;
    private String ufConselho;
    private String titulacao;
    private String especialidadeConselho;
    private String ufEspecialidadeConselho;
    private int numeroConsultas;
    private int numeroConsultasMensais;
    private String emailProfissional;
    private boolean atendendo;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public boolean isEspecialista() {
        return especialista;
    }

    public void setEspecialista(boolean especialista) {
        this.especialista = especialista;
    }

    public int getAnosExperiencia() {
        return anosExperiencia;
    }

    public void setAnosExperiencia(int anosExperiencia) {
        this.anosExperiencia = anosExperiencia;
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

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public String getConselho() {
        return conselho;
    }

    public void setConselho(String conselho) {
        this.conselho = conselho;
    }

    public String getUfConselho() {
        return ufConselho;
    }

    public void setUfConselho(String ufConselho) {
        this.ufConselho = ufConselho;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public String getEspecialidadeConselho() {
        return especialidadeConselho;
    }

    public void setEspecialidadeConselho(String especialidadeConselho) {
        this.especialidadeConselho = especialidadeConselho;
    }

    public String getUfEspecialidadeConselho() {
        return ufEspecialidadeConselho;
    }

    public void setUfEspecialidadeConselho(String ufEspecialidadeConselho) {
        this.ufEspecialidadeConselho = ufEspecialidadeConselho;
    }

    public int getNumeroConsultas() {
        return numeroConsultas;
    }

    public void setNumeroConsultas(int numeroConsultas) {
        this.numeroConsultas = numeroConsultas;
    }

    public int getNumeroConsultasMensais() {
        return numeroConsultasMensais;
    }

    public void setNumeroConsultasMensais(int numeroConsultasMensais) {
        this.numeroConsultasMensais = numeroConsultasMensais;
    }

    public String getEmailProfissional() {
        return emailProfissional;
    }

    public void setEmailProfissional(String emailProfissional) {
        this.emailProfissional = emailProfissional;
    }

    public boolean isAtendendo() {
        return atendendo;
    }

    public void setAtendendo(boolean atendendo) {
        this.atendendo = atendendo;
    }
}
