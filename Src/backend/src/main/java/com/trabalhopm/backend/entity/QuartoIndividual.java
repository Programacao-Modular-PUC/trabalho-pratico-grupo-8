package com.trabalhopm.backend.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("INDIVIDUAL")
public class QuartoIndividual extends Quarto {
    private int qtdCamasSolteiro;

    @Override
    public double calcularDiaria(int hospedes, boolean querBerco) {
        validar(hospedes, querBerco);
        double adicionalCamas = (qtdCamasSolteiro - 1) * 40;
        return getValorBase() + adicionalCamas + extrasComuns();
    }

    @Override
    public int getCapacidade() {
        return qtdCamasSolteiro;
    }

    @Override
    public String getTipo() {
        return "INDIVIDUAL";
    }

    @Override
    public boolean aceitaBerco() {
        return false;
    }

    public int getQtdCamasSolteiro() {
        return qtdCamasSolteiro;
    }

    public void setQtdCamasSolteiro(int qtdCamasSolteiro) {
        this.qtdCamasSolteiro = qtdCamasSolteiro;
    }
}
