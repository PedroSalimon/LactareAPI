package com.lactare.api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;
    @Column(name = "regiao", nullable = false, length = 100)
    private String regiao;
    @Column(name = "ehNutriz", nullable = false)
    private Boolean ehNutriz;
    @Column(name = "telefoneWhatsapp", nullable = false, length = 20)
    private String telefoneWhatsapp;
    @Column(name = "dataCadastro", nullable = false)
    private LocalDate dataCadastro;

    @OneToMany(mappedBy = "usuario")
    private List<Pergunta> perguntas = new ArrayList<>();
    @OneToMany(mappedBy = "usuario")
    private List<Notificacao> notificacoes = new ArrayList<>();
    @OneToMany(mappedBy = "usuario")
    private List<Avaliacao> avaliacoes = new ArrayList<>();
    @OneToMany(mappedBy = "usuario")
    private List<ContratoSuporte> contratos = new ArrayList<>();
    @OneToMany(mappedBy = "usuario")
    private List<LogMovimentacao> logs = new ArrayList<>();

}
