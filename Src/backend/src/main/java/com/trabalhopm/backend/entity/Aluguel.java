package com.trabalhopm.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class Aluguel {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne private Cliente cliente;
    @ManyToOne
    private Quarto quarto;

    private LocalDateTime dataEntrada;
    private LocalDateTime dataSaida;
    private int numeroDiarias;
    private int numeroHospedes;
    private boolean querBerco;
    private double valorFinal;

    public boolean conflitaCom(LocalDateTime entrada, LocalDateTime saida) {
        return entrada.isBefore(dataSaida) && saida.isAfter(dataEntrada);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public LocalDateTime getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDateTime dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public int getNumeroDiarias() {
        return numeroDiarias;
    }

    public void setNumeroDiarias(int numeroDiarias) {
        this.numeroDiarias = numeroDiarias;
    }

    public int getNumeroHospedes() {
        return numeroHospedes;
    }

    public void setNumeroHospedes(int numeroHospedes) {
        this.numeroHospedes = numeroHospedes;
    }

    public boolean isQuerBerco() {
        return querBerco;
    }

    public void setQuerBerco(boolean querBerco) {
        this.querBerco = querBerco;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public LocalDateTime getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDateTime dataSaida) {
        this.dataSaida = dataSaida;
    }
}