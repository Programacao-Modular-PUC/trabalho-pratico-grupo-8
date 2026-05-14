package com.trabalhopm.backend.controller;

import com.trabalhopm.backend.entity.Residencia;
import com.trabalhopm.backend.service.ResidenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/residencias")
public class ResidenciaController {
    @Autowired
    private ResidenciaService residenciaService;


}
