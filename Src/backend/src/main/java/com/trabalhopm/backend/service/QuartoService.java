package com.trabalhopm.backend.service;

import com.trabalhopm.backend.dto.QuartoDTO;
import com.trabalhopm.backend.entity.Quarto;
import com.trabalhopm.backend.entity.QuartoDuplo;
import com.trabalhopm.backend.entity.QuartoFamilia;
import com.trabalhopm.backend.entity.QuartoIndividual;
import com.trabalhopm.backend.repository.QuartoRepository;
import com.trabalhopm.backend.repository.ResidenciaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuartoService {

    private final QuartoRepository quartoRepository;
    private final ResidenciaRepository residenciaRepository;

    public QuartoService(QuartoRepository quartoRepository, ResidenciaRepository residenciaRepository){
        this.quartoRepository = quartoRepository;
        this.residenciaRepository = residenciaRepository;
    }

    public List<Quarto> listar(String tipo, Long residenciaId) {
        return quartoRepository.findAll().stream()
                .filter(quarto -> tipo == null || tipo.isBlank() || quarto.getTipo().equalsIgnoreCase(tipo)).filter(quarto -> residenciaId == null || (quarto.getResidencia() != null && residenciaId.equals(quarto.getResidencia().getId()))).toList();
    }

    public Quarto buscar(Long id) {
        return quartoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Quarto nao encontrado"));
    }

    public Quarto criar(QuartoDTO dto) {
        Quarto quarto = construir(dto);
        quarto.setValorBase(dto.getValorBase() == null ? 0 : dto.getValorBase());
        quarto.setPossuiAR(Boolean.TRUE.equals(dto.getPossuiAr()));
        quarto.setPossuiHidro(Boolean.TRUE.equals(dto.getPossuiHidro()));
        if (dto.getResidenciaId() != null) {
            quarto.setResidencia(residenciaRepository.findById(dto.getResidenciaId()).orElseThrow(() -> new EntityNotFoundException("Residencia nao encontrada")));
        }
        return quartoRepository.save(quarto);
    }

    private Quarto construir(QuartoDTO dto) {
        if (dto.getTipo() == null) {
            throw new IllegalArgumentException("Tipo de quarto obrigatorio");
        }
        switch (dto.getTipo().toUpperCase()) {
            case "INDIVIDUAL" -> {
                QuartoIndividual quarto = new QuartoIndividual();
                quarto.setQtdCamasSolteiro(valor(dto.getQtdCamasSolteiro()));
                return quarto;
            }
            case "DUPLO" -> {
                QuartoDuplo quarto = new QuartoDuplo();
                quarto.setQueenKing(Boolean.TRUE.equals(dto.getQueenKing()));
                quarto.setTaxaBerco(dto.getTaxaBerco() == null ? 0 : dto.getTaxaBerco());
                return quarto;
            }
            case "FAMILIA" -> {
                QuartoFamilia quarto = new QuartoFamilia();
                quarto.setQtdCamasSolteiro(valor(dto.getQtdCamasSolteiro()));
                quarto.setQtdCamasCasal(valor(dto.getQtdCamasCasal()));
                quarto.setQtdAmbientes(valor(dto.getQtdAmbientes()));
                return quarto;
            }
            default -> throw new IllegalArgumentException("Tipo de quarto invalido: " + dto.getTipo());
        }
    }

    private int valor(Integer valor) {
        return valor == null ? 0 : valor;
    }
}
