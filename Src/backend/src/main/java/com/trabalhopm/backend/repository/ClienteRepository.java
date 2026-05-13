package com.trabalhopm.backend.repository;

import com.trabalhopm.backend.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
