package com.lactare.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.lactare.api.entity.Avaliacao;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AvaliacaoResponseDTO {
    private Long id;
    private Integer nota;
    private String comentario;
    private LocalDate dataAvaliacao;
    private Long idUsuario;
    private String nomeUsuario;

    public AvaliacaoResponseDTO(Avaliacao avaliacao) {
        id = avaliacao.getId();
        nota = avaliacao.getNota();
        comentario = avaliacao.getComentario();
        dataAvaliacao = avaliacao.getDataAvaliacao();
        idUsuario = avaliacao.getUsuario().getId();
        nomeUsuario = avaliacao.getUsuario().getNome();
    }
}
