package com.trabalhopm.backend;

import com.trabalhopm.backend.entity.QuartoDuplo;
import com.trabalhopm.backend.entity.QuartoFamilia;
import com.trabalhopm.backend.entity.QuartoIndividual;
import com.trabalhopm.backend.exception.CapacidadeExcedidaException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LimiteHospedesTest {

    @Test
    void quartoIndividualExcedeCapacidade() {
        QuartoIndividual quarto = new QuartoIndividual();
        quarto.setValorBase(100);
        quarto.setQtdCamasSolteiro(1);

        assertThrows(CapacidadeExcedidaException.class, () -> quarto.calcularDiaria(2, false));
    }

    @Test
    void quartoDuploExcedeCapacidade() {
        QuartoDuplo quarto = new QuartoDuplo();
        quarto.setValorBase(200);
        quarto.setQueenKing(false);

        assertThrows(CapacidadeExcedidaException.class, () -> quarto.calcularDiaria(3, false));
    }

    @Test
    void quartoFamiliaExcedeCapacidade() {
        QuartoFamilia quarto = new QuartoFamilia();
        quarto.setValorBase(300);
        quarto.setQtdCamasSolteiro(2);
        quarto.setQtdCamasCasal(2);

        assertEquals(6, quarto.getCapacidade());
        assertThrows(CapacidadeExcedidaException.class, () -> quarto.calcularDiaria(7, false));
    }

    @Test
    void quartoFamiliaDentroDaCapacidade() {
        QuartoFamilia quarto = new QuartoFamilia();
        quarto.setValorBase(300);
        quarto.setQtdCamasSolteiro(2);
        quarto.setQtdCamasCasal(2);

        assertDoesNotThrow(() -> quarto.calcularDiaria(6, false));
    }
}
