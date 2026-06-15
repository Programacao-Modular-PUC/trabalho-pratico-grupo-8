package com.trabalhopm.backend.controller;

import com.trabalhopm.backend.dto.QuartoDTO;
import com.trabalhopm.backend.entity.Quarto;
import com.trabalhopm.backend.service.QuartoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quartos")
public class QuartoController {

    private final QuartoService quartoService;

    public QuartoController(QuartoService quartoService){
        this.quartoService = quartoService;
    }

    @GetMapping
    public List<Quarto> listar(@RequestParam(required = false) String tipo, @RequestParam(required = false) Long residenciaId){
        return quartoService.listar(tipo, residenciaId);
    }

    @GetMapping("/{id}")
    public Quarto buscar(@PathVariable Long id){
        return quartoService.buscar(id);
    }

    @PostMapping
    public Quarto criar(@RequestBody QuartoDTO dto){
        return quartoService.criar(dto);
    }
}
