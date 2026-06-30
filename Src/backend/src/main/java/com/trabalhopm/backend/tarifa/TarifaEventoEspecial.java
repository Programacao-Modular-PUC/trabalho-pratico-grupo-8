package com.trabalhopm.backend.tarifa;

public class TarifaEventoEspecial implements Tarifa {

    public String getNome() {
        return "EVENTO_ESPECIAL";
    }

    public double aplicar(double valor) {
        return valor * 1.4;
    }
}
