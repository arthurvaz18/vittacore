package com.vittacore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.vittacore.shared.enums.StatusPagamentoEnum;
import com.vittacore.shared.enums.TipoAtendimentoEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ATENDIMENTO")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 30, nullable = false)
    private TipoAtendimentoEnum tipo;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraInicio;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraFim;

    @Column(precision = 10, scale = 2)
    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    @Column(name = "statuspagamento", length = 30)
    private StatusPagamentoEnum statusPagamento;

    @Column(columnDefinition = "TEXT")
    private String observacao;

    @CreatedDate
    @Column(name = "datacriacao", updatable = false)
    private LocalDateTime dataCriacao;

    @LastModifiedDate
    @Column(name = "dataatualizacao")
    private LocalDateTime dataAtualizacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profissional", nullable = false)
    private Profissional profissional;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unidadeatendimento", nullable = false)
    private UnidadeAtendimento unidadeAtendimento;

    @OneToMany(mappedBy = "atendimento", cascade = CascadeType.ALL)
    private List<AtendimentoItem> itens;
}