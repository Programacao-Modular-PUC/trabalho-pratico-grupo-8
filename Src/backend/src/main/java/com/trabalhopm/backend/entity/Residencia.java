package com.trabalhopm.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Residencia {
    @Id
    @GeneratedValue
    private Long id;
    private String endereco;
    private String numero;
    private String bairro;
    private String cep;
    private String telefone;
    private String email;

    @OneToMany(mappedBy = "residencia")
    private List<Quarto> quartos = new ArrayList<>();
}