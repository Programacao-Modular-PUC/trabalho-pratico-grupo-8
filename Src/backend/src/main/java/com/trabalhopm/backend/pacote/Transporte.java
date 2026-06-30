package com.trabalhopm.backend.pacote;

public class Transporte extends ServicoAdicional {

    public Transporte(Servico servico) {
        super(servico);
    }

    public String getDescricao() {
        return servico.getDescricao() + ", Transporte";
    }

    public double getPreco() {
        return servico.getPreco() + 80;
    }
}
