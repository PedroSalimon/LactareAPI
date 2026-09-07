package com.lactare.api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_solucaoConhecida")
public class SolucaoConhecida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "titulo", nullable = false, length = 150)
    private String titulo;
    @Column(name = "descricaoResposta", nullable = false, length = 1000)
    private String descricaoResposta;
    @Column(name = "linkSite", length = 255)
    private String linkSite;
    @Column(name = "categoria", nullable = false, length = 50)
    private String categoria;

    @OneToMany(mappedBy = "solucao")
    private List<Pergunta> perguntas = new ArrayList<>();

}
