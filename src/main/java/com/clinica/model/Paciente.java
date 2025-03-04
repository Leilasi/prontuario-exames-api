package com.clinica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "paciente")

public class Paciente extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataUltimaConsulta;
    private String observacoes;
    private boolean TEA = false; // TEA = TRANSTORNO AUTISTA
    private LocalDate dataPrimeiraConsulta;
    private LocalDate dataProximaConsulta;
    private String nomeMae;
    private String nomePai;
    private String numeroCartaoSus;
    private String responsavel;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataUltimaConsulta() {
        return dataUltimaConsulta;
    }

    public void setDataUltimaConsulta(LocalDate dataUltimaConsulta) {
        this.dataUltimaConsulta = dataUltimaConsulta;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public boolean isTEA() {
        return TEA;
    }

    public void setTEA(boolean TEA) {
        this.TEA = TEA;
    }

    public LocalDate getDataPrimeiraConsulta() {
        return dataPrimeiraConsulta;
    }

    public void setDataPrimeiraConsulta(LocalDate dataPrimeiraConsulta) {
        this.dataPrimeiraConsulta = dataPrimeiraConsulta;
    }

    public LocalDate getDataProximaConsulta() {
        return dataProximaConsulta;
    }

    public void setDataProximaConsulta(LocalDate dataProximaConsulta) {
        this.dataProximaConsulta = dataProximaConsulta;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getNumeroCartaoSus() {
        return numeroCartaoSus;
    }

    public void setNumeroCartaoSus(String numeroCartaoSus) {
        this.numeroCartaoSus = numeroCartaoSus;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", dataUltimaConsulta=" + dataUltimaConsulta +
                ", observacoes='" + observacoes + '\'' +
                ", TEA=" + TEA +
                ", dataPrimeiraConsulta=" + dataPrimeiraConsulta +
                ", dataProximaConsulta=" + dataProximaConsulta +
                ", nomeMae='" + nomeMae + '\'' +
                ", nomePai='" + nomePai + '\'' +
                ", numeroCartaoSus='" + numeroCartaoSus + '\'' +
                ", responsavel='" + responsavel + '\'' +
                '}';
    }
}
