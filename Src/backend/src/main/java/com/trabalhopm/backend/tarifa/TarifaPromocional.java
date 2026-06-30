package com.trabalhopm.backend.tarifa;

public class TarifaPromocional implements Tarifa {

    public String getNome() {
        return "PROMOCIONAL";
    }

    public double aplicar(double valor) {
        return valor * 0.9;
    }
}
