package com.trabalhopm.backend.repository;

import com.trabalhopm.backend.entity.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AluguelRepository extends JpaRepository<Aluguel, Long> {

    List<Aluguel> findByQuartoId(Long quartoId);

    List<Aluguel> findByClienteId(Long clienteId);
}
