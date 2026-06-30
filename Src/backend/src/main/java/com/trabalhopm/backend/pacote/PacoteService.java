package com.trabalhopm.backend.pacote;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacoteService {

    public Servico montar(double valorBase, List<String> servicos) {
        Servico servico = new Hospedagem(valorBase);
        if (servicos != null) {
            for (String nome : servicos) {
                servico = adicionar(servico, nome);
            }
        }
        return servico;
    }

    private Servico adicionar(Servico servico, String nome) {
        if (nome.equalsIgnoreCase("CAFE")) {
            return new CafeDaManha(servico);
        }
        if (nome.equalsIgnoreCase("PASSEIO")) {
            return new PasseioTuristico(servico);
        }
        if (nome.equalsIgnoreCase("TRANSPORTE")) {
            return new Transporte(servico);
        }
        if (nome.equalsIgnoreCase("LAVANDERIA")) {
            return new Lavanderia(servico);
        }
        throw new IllegalArgumentException("Servico invalido: " + nome);
    }
}
