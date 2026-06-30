package com.trabalhopm.backend.pacote;

public class PasseioTuristico extends ServicoAdicional {

    public PasseioTuristico(Servico servico) {
        super(servico);
    }

    public String getDescricao() {
        return servico.getDescricao() + ", Passeio turistico";
    }

    public double getPreco() {
        return servico.getPreco() + 120;
    }
}
