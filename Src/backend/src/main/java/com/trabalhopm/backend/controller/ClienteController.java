package com.trabalhopm.backend.controller;

import com.trabalhopm.backend.dto.ClienteDTO;
import com.trabalhopm.backend.entity.Cliente;
import com.trabalhopm.backend.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public Cliente Salvar(@RequestBody ClienteDTO dto){
        return clienteService.cadastrarCliente(dto);

    }
    @GetMapping("/{id}")
    public Cliente buscarCliente(@PathVariable Long id){
        return clienteService.buscarPorID(id);

    }
}
