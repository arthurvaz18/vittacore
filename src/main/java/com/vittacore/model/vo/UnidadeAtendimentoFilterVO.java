package com.vittacore.model.vo;

import com.vittacore.model.UnidadeEndereco;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class UnidadeAtendimentoFilterVO {

    private Integer id;

    private String razaoSocial;

    private String cnpj;

    private String telefone;

    private String email;

    private String observacao;

    private Boolean ativo = true;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;

    private UnidadeEndereco unidadeEndereco;

    private List<AtendimentoFilterVO> atendimentoFilterVOList;
}
