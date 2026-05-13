package com.trabalhopm.backend.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("INDIVIDUAL")
public class QuartoIndividual extends Quarto {
    private int qtdCamasSolteiro;

    @Override
    public double calcularDiaria(int hospedes, boolean querBerco) {
        // 1 cama de graça, demais 40 reais cada
        double adicionalCamas = (qtdCamasSolteiro - 1) * 40;
        return getValorBase() + adicionalCamas + extrasComuns();
    }
}