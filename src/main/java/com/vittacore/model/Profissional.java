package com.vittacore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vittacore.shared.enums.ProfissionalGeneroEnum;
import com.vittacore.shared.enums.TipoProfissaoEnum;
import com.vittacore.shared.enums.TipoRegistroEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "PROFISSIONAL")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Profissional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank
    @Size(min = 6)
    @Column(nullable = false)
    private String senha;

    @Email
    @NotBlank
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank
    @Column(name = "nome", length = 150, nullable = false)
    private String nome;

    @Column(name = "datanascimento")
    private LocalDate dataNascimento;

    @CreatedDate
    @Column(name = "datacriacao", updatable = false)
    private LocalDateTime dataCriacao;

    @LastModifiedDate
    @Column(name = "dataatualizacao")
    private LocalDateTime dataAtualizacao;

    @Column(columnDefinition = "TEXT")
    private String observacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "genero", length = 30)
    private ProfissionalGeneroEnum genero;

    @Column(length = 20)
    private String telefone;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipoprofissao", length = 50)
    private TipoProfissaoEnum tipoProfissao;

    @Enumerated(EnumType.STRING)
    @Column(name = "tiporegistro", length = 20)
    private TipoRegistroEnum tipoRegistro;

    @Column(name = "numeroregistro", length = 50)
    private String numeroRegistro;

    @Column(nullable = false)
    private Boolean ativo = true;

    @Column(name = "ultimologin")
    private LocalDateTime ultimoLogin;

    @JsonIgnore
    @OneToMany(mappedBy = "profissional", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Atendimento> atendimentos;
}