package com.trabalhopm.backend.service;

import com.trabalhopm.backend.dto.LoginDTO;
import com.trabalhopm.backend.entity.Cliente;
import com.trabalhopm.backend.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutentificacaoService {

    private final ClienteRepository clienteRepository;

    public AutentificacaoService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public Cliente buscarCliente(String email, String senha){
        Cliente cliente = clienteRepository.findByEmail(email).orElseThrow(() -> new EntityNotFoundException("Cliente nao encontrado"));

        if(!cliente.getSenha().equals(senha)){
            throw new IllegalArgumentException("Senha incorreta");
        }

        return cliente;
    }

    public Cliente autenticar(LoginDTO dto){
        Cliente cliente = clienteRepository.findByEmail(dto.getEmail()).orElseThrow(() -> new EntityNotFoundException("Cliente nao encontrado"));

        if(!cliente.getSenha().equals(dto.getSenha())){
            throw new IllegalArgumentException("Senha incorreta");
        }

        return cliente;
    }
}
