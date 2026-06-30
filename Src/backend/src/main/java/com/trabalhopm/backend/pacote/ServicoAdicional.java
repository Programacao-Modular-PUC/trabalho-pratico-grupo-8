package com.trabalhopm.backend.pacote;

public abstract class ServicoAdicional implements Servico {

    protected final Servico servico;

    public ServicoAdicional(Servico servico) {
        this.servico = servico;
    }
}
