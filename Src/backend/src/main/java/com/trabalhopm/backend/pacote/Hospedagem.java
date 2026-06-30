package com.trabalhopm.backend.pacote;

public class Hospedagem implements Servico {

    private final double valor;

    public Hospedagem(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return "Hospedagem";
    }

    public double getPreco() {
        return valor;
    }
}
