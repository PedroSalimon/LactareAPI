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
@Table(name = "tb_notificacao")
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tipo", nullable = false, length = 50)
    private String tipo;
    @Column(name = "mensagem", nullable = false, length = 300)
    private String mensagem;
    @Column(name = "dataEnvio", nullable = false)
    private LocalDate dataEnvio;
    @Column(name = "statusEnvio", nullable = false)
    private Boolean statusEnvio;
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

}
