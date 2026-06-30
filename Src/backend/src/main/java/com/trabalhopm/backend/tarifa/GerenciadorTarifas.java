package com.trabalhopm.backend.tarifa;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorTarifas {

    private static GerenciadorTarifas instancia;

    private final List<Tarifa> tarifas;
    private Tarifa tarifaAtiva;

    private GerenciadorTarifas() {
        tarifas = new ArrayList<>();
        tarifas.add(new TarifaNormal());
        tarifas.add(new TarifaAltaTemporada());
        tarifas.add(new TarifaBaixaTemporada());
        tarifas.add(new TarifaFeriado());
        tarifas.add(new TarifaEventoEspecial());
        tarifas.add(new TarifaPromocional());
        tarifaAtiva = tarifas.get(0);
    }

    public static GerenciadorTarifas getInstance() {
        if (instancia == null) {
            instancia = new GerenciadorTarifas();
        }
        return instancia;
    }

    public Tarifa getTarifaAtiva() {
        return tarifaAtiva;
    }

    public List<Tarifa> getTarifas() {
        return tarifas;
    }

    public void definirTarifaAtiva(String nome) {
        for (Tarifa tarifa : tarifas) {
            if (tarifa.getNome().equalsIgnoreCase(nome)) {
                tarifaAtiva = tarifa;
                return;
            }
        }
        throw new IllegalArgumentException("Tarifa invalida: " + nome);
    }
}
