package com.trabalhopm.backend.repository;

import com.trabalhopm.backend.entity.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AluguelRepository extends JpaRepository<Aluguel, Long> {

}
