package com.trabalhopm.backend.dto;



public class QuartoDTO {

    private String tipo;
    private Double valorBase;
    private Boolean possuiAr;
    private Boolean possuiHidro;
    private Long residenciaId;
    private Integer qtdCamasSolteiro;
    private Integer qtdCamasCasal;
    private Integer qtdAmbientes;
    private Boolean queenKing;
    private Double taxaBerco;

    public QuartoDTO() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getQtdCamasSolteiro() {
        return qtdCamasSolteiro;
    }

    public void setQtdCamasSolteiro(Integer qtdCamasSolteiro) {
        this.qtdCamasSolteiro = qtdCamasSolteiro;
    }

    public Integer getQtdCamasCasal() {
        return qtdCamasCasal;
    }

    public void setQtdCamasCasal(Integer qtdCamasCasal) {
        this.qtdCamasCasal = qtdCamasCasal;
    }

    public Integer getQtdAmbientes() {
        return qtdAmbientes;
    }

    public void setQtdAmbientes(Integer qtdAmbientes) {
        this.qtdAmbientes = qtdAmbientes;
    }

    public Boolean getQueenKing() {
        return queenKing;
    }

    public void setQueenKing(Boolean queenKing) {
        this.queenKing = queenKing;
    }

    public Double getTaxaBerco() {
        return taxaBerco;
    }

    public void setTaxaBerco(Double taxaBerco) {
        this.taxaBerco = taxaBerco;
    }

    public Double getValorBase() {
        return valorBase;
    }

    public void setValorBase(Double valorBase) {
        this.valorBase = valorBase;
    }

    public Boolean getPossuiAr() {
        return possuiAr;
    }

    public void setPossuiAr(Boolean possuiAr) {
        this.possuiAr = possuiAr;
    }

    public Boolean getPossuiHidro() {
        return possuiHidro;
    }

    public void setPossuiHidro(Boolean possuiHidro) {
        this.possuiHidro = possuiHidro;
    }

    public Long getResidenciaId() {
        return residenciaId;
    }

    public void setResidenciaId(Long residenciaId) {
        this.residenciaId = residenciaId;
    }
}