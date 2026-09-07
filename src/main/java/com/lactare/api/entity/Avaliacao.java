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
@Table(name = "tb_avaliacao")
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nota", nullable = false)
    private Integer nota;
    @Column(name = "comentario", length = 300)
    private String comentario;
    @Column(name = "dataAvaliacao", nullable = false)
    private LocalDate dataAvaliacao;
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

}
