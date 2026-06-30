package com.trabalhopm.backend.pacote;

public class Traslado extends ServicoAdicional {

    public Traslado(Servico servico) {
        super(servico);
    }

    public String getDescricao() {
        return servico.getDescricao() + ", Traslado aeroporto";
    }

    public double getPreco() {
        return servico.getPreco() + 60;
    }
}
