package com.vittacore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "UNIDADEATENDIMENTO")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class UnidadeAtendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "razaosocial", length = 150, nullable = false)
    private String razaoSocial;

    @Column(name = "cnpj", length = 18, nullable = false, unique = true)
    private String cnpj;

    @Column(length = 20)
    private String telefone;

    @Column(length = 100)
    private String email;

    @Column(columnDefinition = "TEXT")
    private String observacao;

    @Column(nullable = false)
    private Boolean ativo = true;

    @CreatedDate
    @Column(name = "datacriacao", updatable = false)
    private LocalDateTime dataCriacao;

    @LastModifiedDate
    @Column(name = "dataatualizacao")
    private LocalDateTime dataAtualizacao;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "unidade_endereco_id", nullable = false)
    private UnidadeEndereco unidadeEndereco;

    @JsonIgnore
    @OneToMany(mappedBy = "unidadeAtendimento", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.LAZY)
    private List<Atendimento> atendimentos;
}