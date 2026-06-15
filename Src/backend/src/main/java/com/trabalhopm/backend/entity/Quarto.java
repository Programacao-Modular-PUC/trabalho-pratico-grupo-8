package com.trabalhopm.backend.entity;

import com.trabalhopm.backend.exception.CapacidadeExcedidaException;
import com.trabalhopm.backend.exception.RecursoNaoPermitidoException;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class Quarto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double valorBase;
    private boolean possuiAR;
    private boolean possuiHidro;

    @ManyToOne
    private Residencia residencia;

    public abstract double calcularDiaria(int hospedes, boolean querBerco);

    public abstract int getCapacidade();

    public abstract String getTipo();

    public boolean aceitaBerco() {
        return true;
    }

    protected void validar(int hospedes, boolean querBerco) {
        if (hospedes > getCapacidade()) {
            throw new CapacidadeExcedidaException("Numero de hospedes excede a capacidade do quarto");
        }
        if (querBerco && !aceitaBerco()) {
            throw new RecursoNaoPermitidoException("Berco nao e permitido neste tipo de quarto");
        }
    }

    protected double extrasComuns() {
        double extra = 0;
        if (possuiAR) extra += 30;
        if (possuiHidro) extra += 50;
        return extra;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValorBase() {
        return valorBase;
    }

    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }

    public boolean isPossuiAR() {
        return possuiAR;
    }

    public void setPossuiAR(boolean possuiAR) {
        this.possuiAR = possuiAR;
    }

    public boolean isPossuiHidro() {
        return possuiHidro;
    }

    public void setPossuiHidro(boolean possuiHidro) {
        this.possuiHidro = possuiHidro;
    }

    public Residencia getResidencia() {
        return residencia;
    }

    public void setResidencia(Residencia residencia) {
        this.residencia = residencia;
    }
}