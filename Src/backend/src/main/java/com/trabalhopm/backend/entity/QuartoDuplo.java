package com.trabalhopm.backend.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("DUPLO")
public class QuartoDuplo extends Quarto {
    private boolean queenKing;  // true=queen/king, false=casal comum
    private double taxaBerco;

    @Override
    public double calcularDiaria(int hospedes, boolean querBerco) {
        double adicionalConforto = queenKing ? 80 : 40;
        double berco = querBerco ? taxaBerco : 0;
        return getValorBase() + adicionalConforto + berco + extrasComuns();
    }
}