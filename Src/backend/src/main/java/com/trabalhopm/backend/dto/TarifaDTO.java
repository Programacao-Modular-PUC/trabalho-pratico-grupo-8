package com.trabalhopm.backend.dto;

import java.util.List;

public class TarifaDTO {

    private List<String> disponiveis;
    private String ativa;

    public List<String> getDisponiveis() {
        return disponiveis;
    }

    public void setDisponiveis(List<String> disponiveis) {
        this.disponiveis = disponiveis;
    }

    public String getAtiva() {
        return ativa;
    }

    public void setAtiva(String ativa) {
        this.ativa = ativa;
    }
}
