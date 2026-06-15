package com.trabalhopm.backend;

import com.trabalhopm.backend.entity.QuartoDuplo;
import com.trabalhopm.backend.entity.QuartoIndividual;
import com.trabalhopm.backend.exception.RecursoNaoPermitidoException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RegraBercoTest {

    @Test
    void quartoIndividualNaoAceitaBerco() {
        QuartoIndividual quarto = new QuartoIndividual();
        quarto.setValorBase(100);
        quarto.setQtdCamasSolteiro(1);

        assertThrows(RecursoNaoPermitidoException.class, () -> quarto.calcularDiaria(1, true));
    }

    @Test
    void quartoDuploAceitaBercoCobraTaxa() {
        QuartoDuplo quarto = new QuartoDuplo();
        quarto.setValorBase(200);
        quarto.setQueenKing(false);
        quarto.setTaxaBerco(60);

        assertEquals(300.0, quarto.calcularDiaria(2, true), 0.01);
    }
}
