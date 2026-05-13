package com.trabalhopm.backend.dto;



public class QuartoDTO {

    private Double valorBase;
    private Boolean possuiAr;
    private Boolean possuiHidro;
    private Long residenciaId;

    public QuartoDTO() {
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