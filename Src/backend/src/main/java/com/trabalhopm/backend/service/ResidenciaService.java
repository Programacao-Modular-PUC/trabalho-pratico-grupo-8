package com.trabalhopm.backend.service;

import com.trabalhopm.backend.dto.ResidenciaDTO;
import com.trabalhopm.backend.entity.Quarto;
import com.trabalhopm.backend.entity.Residencia;
import com.trabalhopm.backend.repository.ResidenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResidenciaService {

    @Autowired
    private ResidenciaRepository residenciaRepository;
    public Residencia salvar(ResidenciaDTO dto){
        Residencia residencia = new Residencia();
        residencia.setCep(dto.getCep());
        residencia.setBairro(dto.getBairro());

        return residenciaRepository.save(residencia);

    }
    public Residencia buscar(Long id){
        return residenciaRepository.findById(id).orElseThrow(() -> new RuntimeException("Residência não encontrada"));
    }

    public List<Residencia> listarTodas() {
        return residenciaRepository.findAll();
    }
}
