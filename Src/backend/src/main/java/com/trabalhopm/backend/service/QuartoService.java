package com.trabalhopm.backend.service;

import com.trabalhopm.backend.dto.QuartoDTO;
import com.trabalhopm.backend.entity.Quarto;
import com.trabalhopm.backend.entity.QuartoDuplo;
import com.trabalhopm.backend.entity.QuartoFamilia;
import com.trabalhopm.backend.entity.QuartoIndividual;
import com.trabalhopm.backend.entity.Residencia;
import com.trabalhopm.backend.repository.QuartoRepository;
import com.trabalhopm.backend.repository.ResidenciaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<Quarto> resultado = new ArrayList<>();
        for (Quarto quarto : quartoRepository.findAll()) {
            boolean tipoConfere = tipo == null || tipo.isBlank() || quarto.getTipo().equalsIgnoreCase(tipo);
            boolean residenciaConfere = residenciaId == null || (quarto.getResidencia() != null && residenciaId.equals(quarto.getResidencia().getId()));
            if (tipoConfere && residenciaConfere) {
                resultado.add(quarto);
            }
        }
        return resultado;
    }

    public Quarto buscar(Long id) {
        Quarto quarto = quartoRepository.findById(id).orElse(null);
        if (quarto == null) {
            throw new EntityNotFoundException("Quarto nao encontrado");
        }
        return quarto;
    }

    public Quarto criar(QuartoDTO dto) {
        Quarto quarto = construir(dto);

        double valorBase = 0;
        if (dto.getValorBase() != null) {
            valorBase = dto.getValorBase();
        }
        quarto.setValorBase(valorBase);
        quarto.setPossuiAR(dto.getPossuiAr() != null && dto.getPossuiAr());
        quarto.setPossuiHidro(dto.getPossuiHidro() != null && dto.getPossuiHidro());

        if (dto.getResidenciaId() != null) {
            Residencia residencia = residenciaRepository.findById(dto.getResidenciaId()).orElse(null);
            if (residencia == null) {
                throw new EntityNotFoundException("Residencia nao encontrada");
            }
            quarto.setResidencia(residencia);
        }

        return quartoRepository.save(quarto);
    }

    private Quarto construir(QuartoDTO dto) {
        if (dto.getTipo() == null) {
            throw new IllegalArgumentException("Tipo de quarto obrigatorio");
        }

        String tipo = dto.getTipo().toUpperCase();

        if (tipo.equals("INDIVIDUAL")) {
            QuartoIndividual quarto = new QuartoIndividual();
            quarto.setQtdCamasSolteiro(valor(dto.getQtdCamasSolteiro()));
            return quarto;
        }

        if (tipo.equals("DUPLO")) {
            QuartoDuplo quarto = new QuartoDuplo();
            quarto.setQueenKing(dto.getQueenKing() != null && dto.getQueenKing());
            double taxa = 0;
            if (dto.getTaxaBerco() != null) {
                taxa = dto.getTaxaBerco();
            }
            quarto.setTaxaBerco(taxa);
            return quarto;
        }

        if (tipo.equals("FAMILIA")) {
            QuartoFamilia quarto = new QuartoFamilia();
            quarto.setQtdCamasSolteiro(valor(dto.getQtdCamasSolteiro()));
            quarto.setQtdCamasCasal(valor(dto.getQtdCamasCasal()));
            quarto.setQtdAmbientes(valor(dto.getQtdAmbientes()));
            return quarto;
        }

        throw new IllegalArgumentException("Tipo de quarto invalido: " + dto.getTipo());
    }

    private int valor(Integer valor) {
        if (valor == null) {
            return 0;
        }
        return valor;
    }
}
