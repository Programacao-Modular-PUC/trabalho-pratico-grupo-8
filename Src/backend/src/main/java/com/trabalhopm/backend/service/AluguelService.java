package com.trabalhopm.backend.service;

import com.trabalhopm.backend.dto.AluguelDTO;
import com.trabalhopm.backend.entity.Aluguel;
import com.trabalhopm.backend.entity.Cliente;
import com.trabalhopm.backend.entity.Quarto;
import com.trabalhopm.backend.entity.Residencia;
import com.trabalhopm.backend.repository.AluguelRepository;
import com.trabalhopm.backend.repository.ClienteRepository;
import com.trabalhopm.backend.repository.QuartoRepository;
import com.trabalhopm.backend.repository.ResidenciaRepository;
import org.springframework.stereotype.Service;

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
        return aluguelRepository.findById(id).orElseThrow(() -> new RuntimeException("Aluguel não encontrado"));
    }


    public Aluguel cadastrarAluguel(AluguelDTO dto) {

        Cliente cliente = clienteRepository.findById(dto.getClienteId()).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Quarto quarto = quartoRepository.findById(dto.getQuartoId()).orElseThrow(() -> new RuntimeException("Quarto não encontrado"));

        Aluguel aluguel = new Aluguel();

        aluguel.setCliente(cliente);
        aluguel.setQuarto(quarto);

        aluguel.setDataEntrada(dto.getDataEntrada());
        aluguel.setDataSaida(dto.getDataSaida());

        aluguel.setNumeroHospedes(dto.getNumeroHospedes());
        aluguel.setQuerBerco(dto.getClienteSolicitouBerco());

        return aluguelRepository.save(aluguel);
    }

}
