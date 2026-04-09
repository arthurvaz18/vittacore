package com.vittacore.shared.enums;

public enum TipoRegistroEnum {

    CRM("CRM - Conselho Regional de Medicina"),
    COREN("COREN - Conselho Regional de Enfermagem"),
    CRO("CRO - Conselho Regional de Odontologia"),
    CRMV("CRMV - Conselho Regional de Medicina Veterinária"),
    OUTRO("Outro");

    private final String descricao;

    TipoRegistroEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCodigo() {
        return name();
    }
}