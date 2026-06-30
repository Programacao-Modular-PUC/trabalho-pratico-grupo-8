package com.trabalhopm.backend.controller;

import com.trabalhopm.backend.dto.TarifaDTO;
import com.trabalhopm.backend.tarifa.GerenciadorTarifas;
import com.trabalhopm.backend.tarifa.Tarifa;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tarifas")
public class TarifaController {

    @GetMapping
    public TarifaDTO listar() {
        GerenciadorTarifas gerenciador = GerenciadorTarifas.getInstance();
        List<String> nomes = new ArrayList<>();
        for (Tarifa tarifa : gerenciador.getTarifas()) {
            nomes.add(tarifa.getNome());
        }
        TarifaDTO dto = new TarifaDTO();
        dto.setDisponiveis(nomes);
        dto.setAtiva(gerenciador.getTarifaAtiva().getNome());
        return dto;
    }

    @PutMapping("/ativa")
    public TarifaDTO definir(@RequestParam String nome) {
        GerenciadorTarifas gerenciador = GerenciadorTarifas.getInstance();
        gerenciador.definirTarifaAtiva(nome);
        return listar();
    }
}
