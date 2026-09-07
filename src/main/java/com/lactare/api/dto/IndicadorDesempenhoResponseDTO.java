package com.lactare.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.lactare.api.entity.IndicadorDesempenho;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class IndicadorDesempenhoResponseDTO {
    private Long id;
    private String nomeIndicador;
    private Double valor;
    private String periodoReferencia;
    private String regiao;

    public IndicadorDesempenhoResponseDTO(IndicadorDesempenho indicador) {
        id = indicador.getId();
        nomeIndicador = indicador.getNomeIndicador();
        valor = indicador.getValor();
        periodoReferencia = indicador.getPeriodoReferencia();
        regiao = indicador.getRegiao();
    }
}
