package com.trabalhopm.backend.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("DUPLO")
public class QuartoDuplo extends Quarto {
    private boolean queenKing;
    private double taxaBerco;

    @Override
    public double calcularDiaria(int hospedes, boolean querBerco) {
        validar(hospedes, querBerco);
        double adicionalConforto = queenKing ? 80 : 40;
        double berco = querBerco ? taxaBerco : 0;
        return getValorBase() + adicionalConforto + berco + extrasComuns();
    }

    @Override
    public int getCapacidade() {
        return 2;
    }

    @Override
    public String getTipo() {
        return "DUPLO";
    }

    public boolean isQueenKing() {
        return queenKing;
    }

    public void setQueenKing(boolean queenKing) {
        this.queenKing = queenKing;
    }

    public double getTaxaBerco() {
        return taxaBerco;
    }

    public void setTaxaBerco(double taxaBerco) {
        this.taxaBerco = taxaBerco;
    }
}
