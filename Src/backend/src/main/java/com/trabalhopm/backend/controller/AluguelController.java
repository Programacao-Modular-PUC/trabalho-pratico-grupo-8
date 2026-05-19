package com.trabalhopm.backend.controller;

import com.trabalhopm.backend.dto.AluguelDTO;
import com.trabalhopm.backend.entity.Aluguel;
import com.trabalhopm.backend.service.AluguelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alugueis")
public class AluguelController {

    private final AluguelService aluguelService;

    public AluguelController(AluguelService aluguelService){
        this.aluguelService = aluguelService;
    }
    @PostMapping("/cadastrar")
    public Aluguel salvarAluguel(@RequestBody AluguelDTO dto){
        return aluguelService.cadastrarAluguel(dto);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluguel> buscarAluguel(@PathVariable Long id){
        return ResponseEntity.ok(aluguelService.buscarAluguel(id));
    }





}
