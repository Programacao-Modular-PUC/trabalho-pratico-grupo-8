package com.trabalhopm.backend.tarifa;

public class TarifaFeriado implements Tarifa {

    public String getNome() {
        return "FERIADO";
    }

    public double aplicar(double valor) {
        return valor * 1.3;
    }
}
