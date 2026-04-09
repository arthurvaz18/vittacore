package com.vittacore.shared.enums;

public enum TipoProfissaoEnum {

    MEDICO("Médico"),
    ENFERMEIRO("Enfermeiro"),
    DENTISTA("Dentista"),
    VETERINARIO("Veterinário"),
    FISIOTERAPEUTA("Fisioterapeuta"),
    OUTRO("Outro");

    private final String descricao;

    TipoProfissaoEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCodigo() {
        return name();
    }
}