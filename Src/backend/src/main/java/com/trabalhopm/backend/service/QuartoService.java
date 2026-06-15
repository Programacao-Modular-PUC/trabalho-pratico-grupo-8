package com.trabalhopm.backend.service;

import com.trabalhopm.backend.entity.Quarto;
import com.trabalhopm.backend.repository.QuartoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuartoService {

    private final QuartoRepository quartoRepository;

    public QuartoService(QuartoRepository quartoRepository){
        this.quartoRepository = quartoRepository;
    }

    public List<Quarto> listar(String tipo) {
        if (tipo == null || tipo.isBlank()) {
            return quartoRepository.findAll();
        }
        return quartoRepository.findAll().stream().filter(quarto -> quarto.getTipo().equalsIgnoreCase(tipo)).toList();
    }
}
