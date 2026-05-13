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
}