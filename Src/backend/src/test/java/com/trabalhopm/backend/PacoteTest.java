package com.trabalhopm.backend;

import com.trabalhopm.backend.pacote.CafeDaManha;
import com.trabalhopm.backend.pacote.Hospedagem;
import com.trabalhopm.backend.pacote.PacoteService;
import com.trabalhopm.backend.pacote.PasseioTuristico;
import com.trabalhopm.backend.pacote.Servico;
import com.trabalhopm.backend.pacote.Transporte;
import com.trabalhopm.backend.pacote.Traslado;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PacoteTest {

    @Test
    void hospedagemSozinha() {
        Servico servico = new Hospedagem(500);
        assertEquals(500.0, servico.getPreco(), 0.01);
        assertEquals("Hospedagem", servico.getDescricao());
    }

    @Test
    void adicionaCafeDaManha() {
        Servico servico = new CafeDaManha(new Hospedagem(500));
        assertEquals(530.0, servico.getPreco(), 0.01);
        assertEquals("Hospedagem, Cafe da manha", servico.getDescricao());
    }

    @Test
    void empilhaVariosServicos() {
        Servico servico = new Hospedagem(500);
        servico = new CafeDaManha(servico);
        servico = new PasseioTuristico(servico);
        servico = new Transporte(servico);
        assertEquals(730.0, servico.getPreco(), 0.01);
        assertEquals("Hospedagem, Cafe da manha, Passeio turistico, Transporte", servico.getDescricao());
    }

    @Test
    void adicionaTraslado() {
        Servico servico = new Traslado(new Hospedagem(500));
        assertEquals(560.0, servico.getPreco(), 0.01);
        assertEquals("Hospedagem, Traslado aeroporto", servico.getDescricao());
    }

    @Test
    void pacoteServiceMonta() {
        PacoteService service = new PacoteService();
        List<String> servicos = new ArrayList<>();
        servicos.add("CAFE");
        servicos.add("LAVANDERIA");
        Servico servico = service.montar(500, servicos);
        assertEquals(580.0, servico.getPreco(), 0.01);
        assertEquals("Hospedagem, Cafe da manha, Lavanderia", servico.getDescricao());
    }
}
