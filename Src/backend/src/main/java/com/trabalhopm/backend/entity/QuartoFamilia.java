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
        // 8% a mais por hóspede
        double valor = getValorBase() + (getValorBase() * 0.08 * hospedes);
        valor += extrasComuns();

        // desconto progressivo
        if (hospedes >= 6) valor *= 0.90;       // 10% off
        else if (hospedes >= 4) valor *= 0.95;  // 5% off

        return valor;
    }
}