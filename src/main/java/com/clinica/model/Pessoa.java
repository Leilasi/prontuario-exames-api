package com.clinica.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity(name = "pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O nome é obrigatório.")
    private String nome;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;
    private String celular;

    @Email(message = "Email inválido.")
    private String email;

    private LocalDate dataNascimento;
    private String genero;
    private String RG;

    @NotNull(message = "O Numero é obrigatório.")
    private String CPF;
    private boolean gestante;
    private LocalDate dataDeCadastro;
    private boolean profissionalUBS = false;

    public Pessoa() {
    }

    public Pessoa(Long id, String nome, Endereco endereco, String celular, String email, LocalDate dataNascimento, String genero, String RG, String CPF, boolean gestante, LocalDate dataDeCadastro, boolean profissionalUBS) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.celular = celular;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.RG = RG;
        this.CPF = CPF;
        this.gestante = gestante;
        this.dataDeCadastro = dataDeCadastro;
        this.profissionalUBS = profissionalUBS;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public boolean isGestante() {
        return gestante;
    }

    public void setGestante(boolean gestante) {
        this.gestante = gestante;
    }

    public LocalDate getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(LocalDate dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    public boolean isProfissionalUBS() {
        return profissionalUBS;
    }

    public void setProfissionalUBS(boolean profissionalUBS) {
        this.profissionalUBS = profissionalUBS;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", endereco=" + endereco +
                ", celular='" + celular + '\'' +
                ", email='" + email + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", Genero='" + genero + '\'' +
                ", RG='" + RG + '\'' +
                ", CPF='" + CPF + '\'' +
                ", gestante=" + gestante +
                ", dataDeCadastro=" + dataDeCadastro +
                ", profissionalUBS=" + profissionalUBS +
                '}';
    }
}
