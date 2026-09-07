package com.lactare.api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_pergunta")
public class Pergunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "textoPergunta", nullable = false, length = 500)
    private String textoPergunta;
    @Column(name = "categoria", nullable = false, length = 50)
    private String categoria;
    @Column(name = "dataRegistro", nullable = false)
    private LocalDate dataRegistro;
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    @ManyToOne(optional = true)
    @JoinColumn(name = "id_solucao")
    private SolucaoConhecida solucao;

}
