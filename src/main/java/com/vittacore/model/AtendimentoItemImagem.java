package com.vittacore.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ATENDIMENTOITEMIMAGEM")
@Getter
@Setter
public class AtendimentoItemImagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "url", length = 500, nullable = false)
    private String url;

    @Column(name = "descricao", length = 200)
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "atendimentoitem", nullable = false)
    private AtendimentoItem atendimentoItem;
}