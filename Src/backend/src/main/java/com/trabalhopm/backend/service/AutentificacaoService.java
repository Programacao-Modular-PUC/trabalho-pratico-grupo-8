package com.trabalhopm.backend.service;

import com.trabalhopm.backend.dto.LoginDTO;
import com.trabalhopm.backend.entity.Cliente;
import com.trabalhopm.backend.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutentificacaoService {
    @Autowired
    private ClienteRepository clienteRepository;

    public AutentificacaoService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public Cliente buscarCliente(String email, String senha){
        Optional<Cliente> clienteOptional = clienteRepository.findByEmail(email);
        if (clienteOptional.isEmpty()){
            throw new RuntimeException("email inexistente");
        }
        Cliente cliente = clienteOptional.get();

        if(!cliente.getSenha().equals(senha)){
            throw new RuntimeException("Senha errada");
        }

        return cliente;

    }

    public Cliente autenticar(LoginDTO dto){

        Optional<Cliente> usuario = clienteRepository.findByEmail(dto.getEmail());

        if(usuario.isEmpty()){
            throw new RuntimeException("Autentificacao falhou");
        }

        Cliente cliente = usuario.get();

        if(!cliente.getSenha().equals(dto.getSenha())){
            throw new RuntimeException("Autentificacao falhou");
        }

        return cliente;
    }
}
