package com.trabalhopm.backend.entity;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class Quarto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double valorBase;
    private boolean possuiAR;
    private boolean possuiHidro;

    @ManyToOne
    private Residencia residencia;

    public abstract double calcularDiaria(int hospedes, boolean querBerco);

    protected double extrasComuns() {
        double extra = 0;
        if (possuiAR) extra += 30;
        if (possuiHidro) extra += 50;
        return extra;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValorBase() {
        return valorBase;
    }

    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }

    public boolean isPossuiAR() {
        return possuiAR;
    }

    public void setPossuiAR(boolean possuiAR) {
        this.possuiAR = possuiAR;
    }

    public boolean isPossuiHidro() {
        return possuiHidro;
    }

    public void setPossuiHidro(boolean possuiHidro) {
        this.possuiHidro = possuiHidro;
    }

    public Residencia getResidencia() {
        return residencia;
    }

    public void setResidencia(Residencia residencia) {
        this.residencia = residencia;
    }
}