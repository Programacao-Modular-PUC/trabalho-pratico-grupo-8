package com.trabalhopm.backend.controller;

import com.trabalhopm.backend.dto.PacoteDTO;
import com.trabalhopm.backend.pacote.PacoteService;
import com.trabalhopm.backend.pacote.Servico;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pacotes")
public class PacoteController {

    private final PacoteService pacoteService;

    public PacoteController(PacoteService pacoteService) {
        this.pacoteService = pacoteService;
    }

    @GetMapping("/servicos")
    public List<String> servicos() {
        List<String> lista = new ArrayList<>();
        lista.add("CAFE");
        lista.add("PASSEIO");
        lista.add("TRANSPORTE");
        lista.add("LAVANDERIA");
        return lista;
    }

    @PostMapping("/calcular")
    public PacoteDTO calcular(@RequestBody PacoteDTO dto) {
        double valorBase = 0;
        if (dto.getValorBase() != null) {
            valorBase = dto.getValorBase();
        }
        Servico servico = pacoteService.montar(valorBase, dto.getServicos());
        dto.setDescricao(servico.getDescricao());
        dto.setPrecoTotal(servico.getPreco());
        return dto;
    }
}
