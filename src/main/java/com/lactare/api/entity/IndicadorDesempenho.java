package com.lactare.api.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_indicadorDesempenho")
public class IndicadorDesempenho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nomeIndicador", nullable = false, length = 100)
    private String nomeIndicador;
    @Column(name = "valor", nullable = false)
    private Double valor;
    @Column(name = "periodoReferencia", nullable = false, length = 20)
    private String periodoReferencia;
    @Column(name = "regiao", nullable = false, length = 100)
    private String regiao;

}
