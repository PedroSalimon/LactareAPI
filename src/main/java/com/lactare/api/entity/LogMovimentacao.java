package com.lactare.api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_logMovimentacao")
public class LogMovimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "acao", nullable = false, length = 100)
    private String acao;
    @Column(name = "origem", nullable = false, length = 50)
    private String origem;
    @Column(name = "dataHora", nullable = false)
    private LocalDateTime dataHora;
    @ManyToOne(optional = true)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

}
