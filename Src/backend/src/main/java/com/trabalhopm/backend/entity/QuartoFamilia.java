package com.trabalhopm.backend.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("FAMILIA")
public class QuartoFamilia extends Quarto {
    private int qtdCamasSolteiro;
    private int qtdCamasCasal;
    private int qtdAmbientes;

    @Override
    public double calcularDiaria(int hospedes, boolean querBerco) {
        validar(hospedes, querBerco);
        double valor = getValorBase() + (getValorBase() * 0.08 * hospedes);
        valor += extrasComuns();

        if (hospedes >= 6) valor *= 0.90;
        else if (hospedes >= 4) valor *= 0.95;

        return valor;
    }

    @Override
    public int getCapacidade() {
        return qtdCamasSolteiro + (qtdCamasCasal * 2);
    }

    @Override
    public String getTipo() {
        return "FAMILIA";
    }

    public int getQtdCamasSolteiro() {
        return qtdCamasSolteiro;
    }

    public void setQtdCamasSolteiro(int qtdCamasSolteiro) {
        this.qtdCamasSolteiro = qtdCamasSolteiro;
    }

    public int getQtdCamasCasal() {
        return qtdCamasCasal;
    }

    public void setQtdCamasCasal(int qtdCamasCasal) {
        this.qtdCamasCasal = qtdCamasCasal;
    }

    public int getQtdAmbientes() {
        return qtdAmbientes;
    }

    public void setQtdAmbientes(int qtdAmbientes) {
        this.qtdAmbientes = qtdAmbientes;
    }
}
