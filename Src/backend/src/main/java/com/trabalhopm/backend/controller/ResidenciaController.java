package com.trabalhopm.backend.controller;

import com.trabalhopm.backend.dto.ResidenciaDTO;
import com.trabalhopm.backend.entity.Residencia;
import com.trabalhopm.backend.service.ResidenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/residencias")
public class ResidenciaController {
    @Autowired
    private ResidenciaService residenciaService;

    @GetMapping("/{id}")
    public Residencia buscarResidencia(@PathVariable ResidenciaDTO dto){
        return residenciaService.buscar(dto.getId());

    }

}
