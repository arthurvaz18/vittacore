package com.vittacore.model.vo;

import com.vittacore.model.UnidadeAtendimento;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnidadeEnderecoFilterVO {

    private Integer id;

    private String logradouro;

    private String numero;

    private String complemento;

    private String bairro;

    private String cidade;

    private String estado;

    private String cep;

    private UnidadeAtendimentoFilterVO unidadeAtendimentoFilterVO;
}
