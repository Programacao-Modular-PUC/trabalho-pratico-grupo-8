package com.trabalhopm.backend;

import com.trabalhopm.backend.entity.Aluguel;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DisponibilidadeTest {

    private Aluguel aluguelExistente() {
        Aluguel aluguel = new Aluguel();
        aluguel.setDataEntrada(LocalDateTime.of(2026, 4, 10, 14, 0));
        aluguel.setDataSaida(LocalDateTime.of(2026, 4, 15, 11, 0));
        return aluguel;
    }

    @Test
    void periodosQueSeSobrepoemConflitam() {
        Aluguel aluguel = aluguelExistente();

        assertTrue(aluguel.conflitaCom(LocalDateTime.of(2026, 4, 12, 14, 0), LocalDateTime.of(2026, 4, 18, 11, 0)));
    }

    @Test
    void periodoPosteriorNaoConflita() {
        Aluguel aluguel = aluguelExistente();

        assertFalse(aluguel.conflitaCom(LocalDateTime.of(2026, 4, 15, 14, 0), LocalDateTime.of(2026, 4, 18, 11, 0)));
    }

    @Test
    void periodoAnteriorNaoConflita() {
        Aluguel aluguel = aluguelExistente();

        assertFalse(aluguel.conflitaCom(LocalDateTime.of(2026, 4, 5, 14, 0), LocalDateTime.of(2026, 4, 10, 11, 0)));
    }
}
