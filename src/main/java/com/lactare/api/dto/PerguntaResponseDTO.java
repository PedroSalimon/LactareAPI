package com.lactare.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.lactare.api.entity.Pergunta;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PerguntaResponseDTO {
    private Long id;
    private String textoPergunta;
    private String categoria;
    private LocalDate dataRegistro;
    private Long idUsuario;
    private String nomeUsuario;
    private Long idSolucao;
    private String tituloSolucao;

    public PerguntaResponseDTO(Pergunta pergunta) {
        id = pergunta.getId();
        textoPergunta = pergunta.getTextoPergunta();
        categoria = pergunta.getCategoria();
        dataRegistro = pergunta.getDataRegistro();
        idUsuario = pergunta.getUsuario().getId();
        nomeUsuario = pergunta.getUsuario().getNome();
        if (pergunta.getSolucao() != null) {
            idSolucao = pergunta.getSolucao().getId();
            tituloSolucao = pergunta.getSolucao().getTitulo();
        }
    }
}
