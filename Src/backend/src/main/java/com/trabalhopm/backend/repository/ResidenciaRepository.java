package com.trabalhopm.backend.repository;

import com.trabalhopm.backend.entity.Residencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResidenciaRepository extends JpaRepository<Residencia, Long> {

}
