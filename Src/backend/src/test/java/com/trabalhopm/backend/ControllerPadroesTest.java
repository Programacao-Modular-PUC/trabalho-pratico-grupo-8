package com.trabalhopm.backend;

import com.trabalhopm.backend.controller.PacoteController;
import com.trabalhopm.backend.controller.TarifaController;
import com.trabalhopm.backend.dto.PacoteDTO;
import com.trabalhopm.backend.dto.TarifaDTO;
import com.trabalhopm.backend.pacote.PacoteService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ControllerPadroesTest {

    @Test
    void tarifaControllerListaETroca() {
        TarifaController controller = new TarifaController();

        TarifaDTO lista = controller.listar();
        assertTrue(lista.getDisponiveis().contains("ALTA_TEMPORADA"));

        TarifaDTO depois = controller.definir("ALTA_TEMPORADA");
        assertEquals("ALTA_TEMPORADA", depois.getAtiva());

        controller.definir("NORMAL");
    }

    @Test
    void pacoteControllerCalcula() {
        PacoteController controller = new PacoteController(new PacoteService());

        PacoteDTO dto = new PacoteDTO();
        dto.setValorBase(500.0);
        List<String> servicos = new ArrayList<>();
        servicos.add("CAFE");
        servicos.add("PASSEIO");
        dto.setServicos(servicos);

        PacoteDTO resposta = controller.calcular(dto);
        assertEquals(650.0, resposta.getPrecoTotal(), 0.01);
        assertEquals("Hospedagem, Cafe da manha, Passeio turistico", resposta.getDescricao());
    }
}
