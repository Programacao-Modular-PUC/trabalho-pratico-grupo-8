package com.trabalhopm.backend.pacote;

public class Lavanderia extends ServicoAdicional {

    public Lavanderia(Servico servico) {
        super(servico);
    }

    public String getDescricao() {
        return servico.getDescricao() + ", Lavanderia";
    }

    public double getPreco() {
        return servico.getPreco() + 50;
    }
}
