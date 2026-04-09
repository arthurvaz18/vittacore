package com.vittacore.model.vo;

import com.vittacore.shared.enums.ProfissionalGeneroEnum;
import com.vittacore.shared.enums.TipoProfissaoEnum;
import com.vittacore.shared.enums.TipoRegistroEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ProfissionalFilterVO {

    private Integer id;

    private String senha;

    private String email;

    private String nome;

    private LocalDate dataNascimento;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;

    private String observacao;

    private ProfissionalGeneroEnum genero;

    private String telefone;

    private TipoProfissaoEnum tipoProfissao;

    private TipoRegistroEnum tipoRegistro;

    private String numeroRegistro;

    private Boolean ativo = true;

    private LocalDateTime ultimoLogin;

    private List<AtendimentoFilterVO> atendimentoFilterVOList;
}
