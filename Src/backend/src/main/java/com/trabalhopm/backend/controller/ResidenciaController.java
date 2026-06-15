package com.trabalhopm.backend.controller;

import com.trabalhopm.backend.dto.ResidenciaDTO;
import com.trabalhopm.backend.entity.Residencia;
import com.trabalhopm.backend.service.ResidenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/residencias")
public class ResidenciaController {
    @Autowired
    private ResidenciaService residenciaService;

    @GetMapping
    public List<Residencia> listar(){
        return residenciaService.listarTodas();
    }

    @GetMapping("/{id}")
    public Residencia buscarResidencia(@PathVariable Long id){
        return residenciaService.buscar(id);
    }

    @PostMapping
    public Residencia salvar(@RequestBody ResidenciaDTO dto){
        return residenciaService.salvar(dto);
    }
}
