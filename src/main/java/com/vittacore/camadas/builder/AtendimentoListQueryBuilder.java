package com.vittacore.camadas.builder;

import com.vittacore.model.Atendimento;
import com.vittacore.model.vo.AtendimentoFilterVO;
import com.vittacore.model.vo.DateRangeVO;
import com.vittacore.shared.base.BaseQueryBuilder;
import org.springframework.stereotype.Component;

@Component
public class AtendimentoListQueryBuilder extends BaseQueryBuilder<AtendimentoFilterVO, Atendimento> {

    public AtendimentoListQueryBuilder() {
        super(Atendimento.class, "atendimento");
    }

    @Override
    public void build(AtendimentoFilterVO filterVO) {

        if (filterVO == null) return;

        DateRangeVO inicioRange = filterVO.getDataHoraInicio();
        DateRangeVO fimRange = filterVO.getDataHoraFim();

        andLike("observacao", filterVO.getObservacao());
        andEquals("tipo", filterVO.getTipo());
        andEquals("statusPagamento", filterVO.getStatusPagamento());

        if (inicioRange != null) {
            andBetweenFlexible("dataHoraInicio", inicioRange.getLower(), inicioRange.getUpper());
        }

        if (fimRange != null) {
            andBetweenFlexible("dataHoraFim", fimRange.getLower(), fimRange.getUpper());
        }

    }
}
