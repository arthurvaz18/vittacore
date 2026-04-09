package com.vittacore.camadas.builder;

import com.vittacore.model.AtendimentoItem;
import com.vittacore.model.AtendimentoItemFilterVO;
import com.vittacore.model.vo.DateRangeVO;
import com.vittacore.shared.base.BaseQueryBuilder;
import org.springframework.stereotype.Component;

@Component
public class AtendimentoItemListQueryBuilder extends BaseQueryBuilder<AtendimentoItemFilterVO, AtendimentoItem> {

    public AtendimentoItemListQueryBuilder() {
        super(AtendimentoItem.class, "atendimentoItem");
    }

    @Override
    public void build(AtendimentoItemFilterVO filterVO) {

        if (filterVO == null) return;

        DateRangeVO dataAtendimento = filterVO.getDataAtendimento();

        andLike("observacao", filterVO.getObservacao());
        andLike("nomePaciente", filterVO.getNomePaciente());
        andEquals("id", filterVO.getId());
        andEquals("tipoAtendimento", filterVO.getTipoAtendimento());

        if (dataAtendimento != null) {
            andBetweenFlexible("dataAtendimento", dataAtendimento.getLower(), dataAtendimento.getUpper());
        }

    }
}
