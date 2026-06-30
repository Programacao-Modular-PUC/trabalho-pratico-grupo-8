package com.trabalhopm.backend.tarifa;

public class TarifaBaixaTemporada implements Tarifa {

    public String getNome() {
        return "BAIXA_TEMPORADA";
    }

    public double aplicar(double valor) {
        return valor * 0.8;
    }
}
