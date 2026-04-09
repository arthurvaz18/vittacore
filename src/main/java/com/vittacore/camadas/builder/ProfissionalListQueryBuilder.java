package com.vittacore.camadas.builder;

import com.vittacore.model.Profissional;
import com.vittacore.model.vo.ProfissionalFilterVO;
import com.vittacore.shared.base.BaseQueryBuilder;

public class ProfissionalListQueryBuilder extends BaseQueryBuilder<ProfissionalFilterVO, Profissional> {

    public ProfissionalListQueryBuilder() {
        super(Profissional.class, "profissional");
    }

    @Override
    public void build(ProfissionalFilterVO filter) {

        if (filter == null) return;

        andLike("nome", filter.getNome());
        andEquals("email", filter.getEmail());
        andEquals("ativo", filter.getAtivo());
        andEquals("tipoProfissao", filter.getTipoProfissao());
        andEquals("tipoRegistro", filter.getTipoRegistro());
    }
}