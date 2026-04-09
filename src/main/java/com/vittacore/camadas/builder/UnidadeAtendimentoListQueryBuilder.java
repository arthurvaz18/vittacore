package com.vittacore.camadas.builder;

import com.vittacore.model.UnidadeAtendimento;
import com.vittacore.model.vo.UnidadeAtendimentoFilterVO;
import com.vittacore.shared.base.BaseQueryBuilder;
import org.springframework.stereotype.Component;

@Component
public class UnidadeAtendimentoListQueryBuilder extends BaseQueryBuilder<UnidadeAtendimentoFilterVO, UnidadeAtendimento> {

    public UnidadeAtendimentoListQueryBuilder(){
        super(UnidadeAtendimento.class, "unidadeAtendimento");
    }

    @Override
    public void build(UnidadeAtendimentoFilterVO filterVO){

        if (filterVO == null) return;

        andLike("razaoSocial", filterVO.getRazaoSocial());
        andLike("cnpj", filterVO.getCnpj());
        andLike("razaoSocial", filterVO.getRazaoSocial());
        andEquals("ativo", filterVO.getAtivo());
        andEquals("id", filterVO.getId());

    }
}
