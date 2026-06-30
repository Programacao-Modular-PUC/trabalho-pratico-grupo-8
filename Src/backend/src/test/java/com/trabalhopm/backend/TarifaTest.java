package com.trabalhopm.backend;

import com.trabalhopm.backend.tarifa.GerenciadorTarifas;
import com.trabalhopm.backend.tarifa.TarifaAltaTemporada;
import com.trabalhopm.backend.tarifa.TarifaBaixaTemporada;
import com.trabalhopm.backend.tarifa.TarifaEventoEspecial;
import com.trabalhopm.backend.tarifa.TarifaFeriado;
import com.trabalhopm.backend.tarifa.TarifaNormal;
import com.trabalhopm.backend.tarifa.TarifaPromocional;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class TarifaTest {

    @Test
    void tarifaNormalMantemValor() {
        assertEquals(100.0, new TarifaNormal().aplicar(100), 0.01);
    }

    @Test
    void tarifaAltaTemporadaAumenta() {
        assertEquals(150.0, new TarifaAltaTemporada().aplicar(100), 0.01);
    }

    @Test
    void tarifaBaixaTemporadaReduz() {
        assertEquals(80.0, new TarifaBaixaTemporada().aplicar(100), 0.01);
    }

    @Test
    void tarifaPromocionalDaDesconto() {
        assertEquals(90.0, new TarifaPromocional().aplicar(100), 0.01);
    }

    @Test
    void tarifaFeriadoAumenta() {
        assertEquals(130.0, new TarifaFeriado().aplicar(100), 0.01);
    }

    @Test
    void tarifaEventoEspecialAumenta() {
        assertEquals(140.0, new TarifaEventoEspecial().aplicar(100), 0.01);
    }

    @Test
    void gerenciadorEhSingleton() {
        GerenciadorTarifas primeira = GerenciadorTarifas.getInstance();
        GerenciadorTarifas segunda = GerenciadorTarifas.getInstance();
        assertSame(primeira, segunda);
    }

    @Test
    void gerenciadorTrocaTarifaAtiva() {
        GerenciadorTarifas gerenciador = GerenciadorTarifas.getInstance();
        gerenciador.definirTarifaAtiva("ALTA_TEMPORADA");
        assertEquals("ALTA_TEMPORADA", gerenciador.getTarifaAtiva().getNome());
        assertEquals(150.0, gerenciador.getTarifaAtiva().aplicar(100), 0.01);
        gerenciador.definirTarifaAtiva("NORMAL");
        assertEquals("NORMAL", gerenciador.getTarifaAtiva().getNome());
    }
}
