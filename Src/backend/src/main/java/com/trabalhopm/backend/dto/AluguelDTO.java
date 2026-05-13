package com.trabalhopm.backend.dto;

import java.time.LocalDateTime;

public class AluguelDTO {

    private Long residenciaId;
    private Long quartoId;
    private Long clienteId;

    private LocalDateTime dataEntrada;
    private LocalDateTime dataSaida;

    private Integer numeroHospedes;
    private Boolean clienteSolicitouBerco;

    public AluguelDTO() {
    }

    public Long getResidenciaId() {
        return residenciaId;
    }

    public void setResidenciaId(Long residenciaId) {
        this.residenciaId = residenciaId;
    }

    public Long getQuartoId() {
        return quartoId;
    }

    public void setQuartoId(Long quartoId) {
        this.quartoId = quartoId;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public LocalDateTime getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDateTime dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDateTime getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDateTime dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Integer getNumeroHospedes() {
        return numeroHospedes;
    }

    public void setNumeroHospedes(Integer numeroHospedes) {
        this.numeroHospedes = numeroHospedes;
    }

    public Boolean getClienteSolicitouBerco() {
        return clienteSolicitouBerco;
    }

    public void setClienteSolicitouBerco(Boolean clienteSolicitouBerco) {
        this.clienteSolicitouBerco = clienteSolicitouBerco;
    }
}