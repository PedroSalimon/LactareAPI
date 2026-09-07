package com.lactare.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.lactare.api.entity.SolucaoConhecida;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SolucaoConhecidaResponseDTO {
    private Long id;
    private String titulo;
    private String descricaoResposta;
    private String linkSite;
    private String categoria;

    public SolucaoConhecidaResponseDTO(SolucaoConhecida solucao) {
        id = solucao.getId();
        titulo = solucao.getTitulo();
        descricaoResposta = solucao.getDescricaoResposta();
        linkSite = solucao.getLinkSite();
        categoria = solucao.getCategoria();
    }
}
