package com.trabalhopm.backend.repository;

import com.trabalhopm.backend.entity.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AluguelRepository extends JpaRepository<Aluguel, Long> {
}
