package com.trabalhopm.backend.pacote;

public class CafeDaManha extends ServicoAdicional {

    public CafeDaManha(Servico servico) {
        super(servico);
    }

    public String getDescricao() {
        return servico.getDescricao() + ", Cafe da manha";
    }

    public double getPreco() {
        return servico.getPreco() + 30;
    }
}
