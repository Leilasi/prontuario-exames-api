package com.clinica.dto;

import java.io.Serial;
import java.io.Serializable;

public class FilaTriagemDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String nomePaciente;
    private String cpfPaciente;
    private String carteirinhaSus;
    private String nomeProfissional;
    private String sintomas;
    private String pressaoArterial;
    private String temperaturaCorporal;
    private boolean prontoAtendimento;
    private String observacao;
    private String classificacaoRisco;
    private String tipoExame;
    private String matricula;

    public FilaTriagemDTO() {
    }

    public FilaTriagemDTO(String nomePaciente, String cpfPaciente, String carteirinhaSus, String nomeProfissional, String sintomas, String pressaoArterial, String temperaturaCorporal, boolean prontoAtendimento, String observacao, String classificacaoRisco, String tipoExame, String matricula) {
        this.nomePaciente = nomePaciente;
        this.cpfPaciente = cpfPaciente;
        this.carteirinhaSus = carteirinhaSus;
        this.nomeProfissional = nomeProfissional;
        this.sintomas = sintomas;
        this.pressaoArterial = pressaoArterial;
        this.temperaturaCorporal = temperaturaCorporal;
        this.prontoAtendimento = prontoAtendimento;
        this.observacao = observacao;
        this.classificacaoRisco = classificacaoRisco;
        this.tipoExame = tipoExame;
        this.matricula = matricula;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getCpfPaciente() {
        return cpfPaciente;
    }

    public void setCpfPaciente(String cpfPaciente) {
        this.cpfPaciente = cpfPaciente;
    }

    public String getCarteirinhaSus() {
        return carteirinhaSus;
    }

    public void setCarteirinhaSus(String carteirinhaSus) {
        this.carteirinhaSus = carteirinhaSus;
    }

    public String getNomeProfissional() {
        return nomeProfissional;
    }

    public void setNomeProfissional(String nomeProfissional) {
        this.nomeProfissional = nomeProfissional;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getPressaoArterial() {
        return pressaoArterial;
    }

    public void setPressaoArterial(String pressaoArterial) {
        this.pressaoArterial = pressaoArterial;
    }

    public String getTemperaturaCorporal() {
        return temperaturaCorporal;
    }

    public void setTemperaturaCorporal(String temperaturaCorporal) {
        this.temperaturaCorporal = temperaturaCorporal;
    }

    public boolean isProntoAtendimento() {
        return prontoAtendimento;
    }

    public void setProntoAtendimento(boolean prontoAtendimento) {
        this.prontoAtendimento = prontoAtendimento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getClassificacaoRisco() {
        return classificacaoRisco;
    }

    public void setClassificacaoRisco(String classificacaoRisco) {
        this.classificacaoRisco = classificacaoRisco;
    }

    public String getTipoExame() {
        return tipoExame;
    }

    public void setTipoExame(String tipoExame) {
        this.tipoExame = tipoExame;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "FilaTriagemDTO{" +
                "nomePaciente='" + nomePaciente + '\'' +
                ", cpfPaciente='" + cpfPaciente + '\'' +
                ", carteirinhaSus='" + carteirinhaSus + '\'' +
                ", nomeProfissional='" + nomeProfissional + '\'' +
                ", sintomas='" + sintomas + '\'' +
                ", pressaoArterial='" + pressaoArterial + '\'' +
                ", temperaturaCorporal='" + temperaturaCorporal + '\'' +
                ", prontoAtendimento=" + prontoAtendimento +
                ", observacao='" + observacao + '\'' +
                ", classificacaoRisco='" + classificacaoRisco + '\'' +
                ", tipoExame='" + tipoExame + '\'' +
                ", matricula='" + matricula + '\'' +
                '}';
    }
}
