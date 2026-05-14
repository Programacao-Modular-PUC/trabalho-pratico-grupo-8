package com.trabalhopm.backend.controller;

import com.trabalhopm.backend.dto.LoginDTO;
import com.trabalhopm.backend.entity.Cliente;
import com.trabalhopm.backend.repository.ClienteRepository;
import com.trabalhopm.backend.service.AutentificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AutentificacaoController {

    @Autowired
    private AutentificacaoService autenticacaoService;

    @PostMapping("/login")
    public Cliente login(@RequestBody LoginDTO dto){
        return autenticacaoService.autenticar(dto);
    }
}
