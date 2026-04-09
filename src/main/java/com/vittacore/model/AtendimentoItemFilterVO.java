package com.vittacore.model;

import com.vittacore.model.vo.AtendimentoFilterVO;
import com.vittacore.model.vo.DateRangeVO;
import com.vittacore.shared.enums.TipoAtendimentoEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtendimentoItemFilterVO {

    private Integer id;

    private String observacao;

    private String imagem;

    private Boolean pacienteAtendido = false;

    private String nomePaciente;

    private DateRangeVO dataAtendimento;

    private TipoAtendimentoEnum tipoAtendimento;

    private AtendimentoFilterVO atendimentoFilterVO;
}
