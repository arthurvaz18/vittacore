package com.vittacore.shared.enums;

public enum TipoAtendimentoEnum {

    PLANTAO("Plantão"),
    EXTRA("Extra");

    private final String descricao;

    TipoAtendimentoEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCodigo() {
        return name();
    }
}
