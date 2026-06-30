package com.trabalhopm.backend.tarifa;

public class TarifaAltaTemporada implements Tarifa {

    public String getNome() {
        return "ALTA_TEMPORADA";
    }

    public double aplicar(double valor) {
        return valor * 1.5;
    }
}
