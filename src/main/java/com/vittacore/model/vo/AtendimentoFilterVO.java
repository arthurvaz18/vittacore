package com.vittacore.model.vo;

import com.vittacore.model.AtendimentoItem;
import com.vittacore.model.UnidadeAtendimento;
import com.vittacore.shared.enums.StatusPagamentoEnum;
import com.vittacore.shared.enums.TipoAtendimentoEnum;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class AtendimentoFilterVO {

    private Integer id;

    private TipoAtendimentoEnum tipo;

    private DateRangeVO dataHoraInicio;

    private DateRangeVO dataHoraFim;

    private BigDecimal valor;

    private StatusPagamentoEnum statusPagamento;

    private String observacao;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;

    private ProfissionalFilterVO profissionalFilterVO;

    private UnidadeAtendimento unidadeAtendimento;

    private List<AtendimentoItem> itens;
}
