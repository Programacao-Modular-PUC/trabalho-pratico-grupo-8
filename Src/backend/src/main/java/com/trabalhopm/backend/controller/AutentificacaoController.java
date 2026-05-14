package com.trabalhopm.backend.controller;

import com.trabalhopm.backend.dto.LoginDTO;
import com.trabalhopm.backend.entity.Cliente;
import com.trabalhopm.backend.repository.ClienteRepository;
import com.trabalhopm.backend.service.AutentificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AutentificacaoController {
    @Autowired
    private AutentificacaoService autentificacaoService;
    private ClienteRepository clienteRepository;

    public Optional<Cliente> autenticar(LoginDTO dto){
        Optional<Cliente> usuario = clienteRepository.findByEmail(dto.getEmail());

        if(usuario.isEmpty()){
            return Optional.empty();
        }

        Cliente cliente = usuario.get();

        if(!cliente.getSenha().equals(dto.getSenha())){
            return Optional.of(cliente);
        }


        return Optional.of(cliente);
    }


}
