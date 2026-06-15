package com.trabalhopm.backend.service;

import com.trabalhopm.backend.dto.AluguelDTO;
import com.trabalhopm.backend.entity.Aluguel;
import com.trabalhopm.backend.entity.Cliente;
import com.trabalhopm.backend.entity.Quarto;
import com.trabalhopm.backend.exception.DataInvalidaException;
import com.trabalhopm.backend.exception.QuartoIndisponivelException;
import com.trabalhopm.backend.repository.AluguelRepository;
import com.trabalhopm.backend.repository.ClienteRepository;
import com.trabalhopm.backend.repository.QuartoRepository;
import com.trabalhopm.backend.repository.ResidenciaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class AluguelService {

    private final AluguelRepository aluguelRepository;
    private final ClienteRepository clienteRepository;
    private final QuartoRepository quartoRepository;
    private final ResidenciaRepository residenciaRepository;

    public AluguelService(AluguelRepository aluguelRepository, ClienteRepository clienteRepository, QuartoRepository quartoRepository, ResidenciaRepository residenciaRepository){
        this.aluguelRepository = aluguelRepository;
        this.clienteRepository = clienteRepository;
        this.quartoRepository = quartoRepository;
        this.residenciaRepository = residenciaRepository;
    }

    public Aluguel buscarAluguel(Long id){
        return aluguelRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Aluguel nao encontrado"));
    }

    public Aluguel cadastrarAluguel(AluguelDTO dto) {

        Cliente cliente = clienteRepository.findById(dto.getClienteId()).orElseThrow(() -> new EntityNotFoundException("Cliente nao encontrado"));

        Quarto quarto = quartoRepository.findById(dto.getQuartoId()).orElseThrow(() -> new EntityNotFoundException("Quarto nao encontrado"));

        validarDatas(dto.getDataEntrada(), dto.getDataSaida());
        verificarDisponibilidade(quarto, dto.getDataEntrada(), dto.getDataSaida());

        int hospedes = dto.getNumeroHospedes() == null ? 1 : dto.getNumeroHospedes();
        boolean querBerco = Boolean.TRUE.equals(dto.getClienteSolicitouBerco());

        int numeroDiarias = (int) ChronoUnit.DAYS.between(dto.getDataEntrada().toLocalDate(), dto.getDataSaida().toLocalDate());
        double valorDiaria = quarto.calcularDiaria(hospedes, querBerco);

        Aluguel aluguel = new Aluguel();
        aluguel.setCliente(cliente);
        aluguel.setQuarto(quarto);
        aluguel.setDataEntrada(dto.getDataEntrada());
        aluguel.setDataSaida(dto.getDataSaida());
        aluguel.setNumeroHospedes(hospedes);
        aluguel.setQuerBerco(querBerco);
        aluguel.setNumeroDiarias(numeroDiarias);
        aluguel.setValorFinal(valorDiaria * numeroDiarias);

        return aluguelRepository.save(aluguel);
    }

    public Aluguel cancelar(Long id) {
        Aluguel aluguel = buscarAluguel(id);
        aluguel.setCancelado(true);
        return aluguelRepository.save(aluguel);
    }

    public List<Aluguel> historicoPorCliente(Long clienteId) {
        return aluguelRepository.findByClienteId(clienteId);
    }

    private void validarDatas(LocalDateTime entrada, LocalDateTime saida) {
        if (entrada == null || saida == null) {
            throw new DataInvalidaException("Datas de entrada e saida sao obrigatorias");
        }
        if (!saida.isAfter(entrada)) {
            throw new DataInvalidaException("A data de saida deve ser posterior a data de entrada");
        }
    }

    private void verificarDisponibilidade(Quarto quarto, LocalDateTime entrada, LocalDateTime saida) {
        for (Aluguel aluguel : aluguelRepository.findByQuartoId(quarto.getId())) {
            if (!aluguel.isCancelado() && aluguel.conflitaCom(entrada, saida)) {
                throw new QuartoIndisponivelException("Quarto indisponivel para o periodo selecionado");
            }
        }
    }

}
