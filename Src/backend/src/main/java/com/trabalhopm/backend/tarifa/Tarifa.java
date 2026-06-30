package com.trabalhopm.backend.tarifa;

public interface Tarifa {
    String getNome();
    double aplicar(double valor);
}
