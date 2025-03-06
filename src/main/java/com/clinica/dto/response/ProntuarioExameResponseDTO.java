package com.clinica.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ProntuarioExameResponseDTO {

    private String cpfPaciente;
    private String tipoExame;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dataExame;
    private String resultado;
    private String nomePaciente;
    private String carteirinhaSus;
    private String profissionalExame;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataNascimento;
    private String sexo;
    private String responsavelPaciente;

    public ProntuarioExameResponseDTO() {
    }

    public ProntuarioExameResponseDTO(String cpfPaciente, String tipoExame, LocalDateTime dataExame, String resultado, String nomePaciente, String carteirinhaSus, String profissionalExame, LocalDate dataNascimento, String sexo, String responsavelPaciente) {
        this.cpfPaciente = cpfPaciente;
        this.tipoExame = tipoExame;
        this.dataExame = dataExame;
        this.resultado = resultado;
        this.nomePaciente = nomePaciente;
        this.carteirinhaSus = carteirinhaSus;
        this.profissionalExame = profissionalExame;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.responsavelPaciente = responsavelPaciente;
    }

    public String getCpfPaciente() {
        return cpfPaciente;
    }

    public void setCpfPaciente(String cpfPaciente) {
        this.cpfPaciente = cpfPaciente;
    }

    public String getTipoExame() {
        return tipoExame;
    }

    public void setTipoExame(String tipoExame) {
        this.tipoExame = tipoExame;
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

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getCarteirinhaSus() {
        return carteirinhaSus;
    }

    public void setCarteirinhaSus(String carteirinhaSus) {
        this.carteirinhaSus = carteirinhaSus;
    }

    public String getProfissionalExame() {
        return profissionalExame;
    }

    public void setProfissionalExame(String profissionalExame) {
        this.profissionalExame = profissionalExame;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getResponsavelPaciente() {
        return responsavelPaciente;
    }

    public void setResponsavelPaciente(String responsavelPaciente) {
        this.responsavelPaciente = responsavelPaciente;
    }

    @Override
    public String toString() {
        return "ProntuarioExameResponseDTO{" +
                "cpfPaciente='" + cpfPaciente + '\'' +
                ", tipoExame='" + tipoExame + '\'' +
                ", dataExame=" + dataExame +
                ", resultado='" + resultado + '\'' +
                ", nomePaciente='" + nomePaciente + '\'' +
                ", carteirinhaSus='" + carteirinhaSus + '\'' +
                ", profissionalExame='" + profissionalExame + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", sexo='" + sexo + '\'' +
                ", responsavelPaciente='" + responsavelPaciente + '\'' +
                '}';
    }
}
