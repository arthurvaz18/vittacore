package com.vittacore.shared.enums;

public enum ProfissionalGeneroEnum {

    MASCULINO("Masculino"),
    FEMININO("Feminino"),
    OUTRO("Outro"),
    NAO_INFORMADO("Não informado");

    private final String descricao;

    ProfissionalGeneroEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}