package com.vittacore.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vittacore.shared.enums.TipoAtendimentoEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ATENDIMENTOITEM")
@Getter
@Setter
public class AtendimentoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String observacao;

    @Column(name = "pacienteatendido")
    private Boolean pacienteAtendido = false;

    @Column(name = "nomepaciente", length = 150)
    private String nomePaciente;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtendimento;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipoatendimento", length = 30)
    private TipoAtendimentoEnum tipoAtendimento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "atendimento_id", nullable = false)
    @JsonIgnoreProperties("itens")
    private Atendimento atendimento;

    @OneToMany(mappedBy = "atendimentoItem", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<AtendimentoItemImagem> atendimentoItemImagemList;
}