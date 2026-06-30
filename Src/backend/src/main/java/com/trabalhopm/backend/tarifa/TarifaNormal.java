package com.trabalhopm.backend.tarifa;

public class TarifaNormal implements Tarifa {

    public String getNome() {
        return "NORMAL";
    }

    public double aplicar(double valor) {
        return valor;
    }
}
