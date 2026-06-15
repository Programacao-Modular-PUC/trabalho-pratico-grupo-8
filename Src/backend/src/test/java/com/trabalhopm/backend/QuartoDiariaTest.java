package com.trabalhopm.backend;

import com.trabalhopm.backend.entity.QuartoDuplo;
import com.trabalhopm.backend.entity.QuartoFamilia;
import com.trabalhopm.backend.entity.QuartoIndividual;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuartoDiariaTest {

    @Test
    void calcularDiariaQuartoIndividual() {
        QuartoIndividual quarto = new QuartoIndividual();
        quarto.setValorBase(100);
        quarto.setQtdCamasSolteiro(2);

        assertEquals(140.0, quarto.calcularDiaria(1, false), 0.01);
    }

    @Test
    void calcularDiariaQuartoDuplo() {
        QuartoDuplo quarto = new QuartoDuplo();
        quarto.setValorBase(200);
        quarto.setQueenKing(false);

        assertEquals(240.0, quarto.calcularDiaria(2, false), 0.01);
    }

    @Test
    void calcularDiariaQuartoDuploComExtras() {
        QuartoDuplo quarto = new QuartoDuplo();
        quarto.setValorBase(200);
        quarto.setQueenKing(true);
        quarto.setPossuiAR(true);
        quarto.setPossuiHidro(true);

        assertEquals(360.0, quarto.calcularDiaria(2, false), 0.01);
    }

    @Test
    void calcularDiariaQuartoFamilia() {
        QuartoFamilia quarto = new QuartoFamilia();
        quarto.setValorBase(300);
        quarto.setQtdCamasSolteiro(2);
        quarto.setQtdCamasCasal(2);

        assertEquals(372.0, quarto.calcularDiaria(3, false), 0.01);
    }

    @Test
    void calcularDiariaQuartoFamiliaComDesconto() {
        QuartoFamilia quarto = new QuartoFamilia();
        quarto.setValorBase(300);
        quarto.setQtdCamasSolteiro(2);
        quarto.setQtdCamasCasal(2);

        assertEquals(399.6, quarto.calcularDiaria(6, false), 0.01);
    }
}
