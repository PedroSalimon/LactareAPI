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
@Table(name = "tb_contratoSuporte")
public class ContratoSuporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tipoContrato", nullable = false, length = 50)
    private String tipoContrato;
    @Column(name = "dataInicio", nullable = false)
    private LocalDate dataInicio;
    @Column(name = "dataFim")
    private LocalDate dataFim;
    @Column(name = "status", nullable = false, length = 30)
    private String status;
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

}
