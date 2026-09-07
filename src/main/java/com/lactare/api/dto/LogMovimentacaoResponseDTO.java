package com.lactare.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.lactare.api.entity.LogMovimentacao;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LogMovimentacaoResponseDTO {
    private Long id;
    private String acao;
    private String origem;
    private LocalDateTime dataHora;
    private Long idUsuario;
    private String nomeUsuario;

    public LogMovimentacaoResponseDTO(LogMovimentacao log) {
        id = log.getId();
        acao = log.getAcao();
        origem = log.getOrigem();
        dataHora = log.getDataHora();
        if (log.getUsuario() != null) {
            idUsuario = log.getUsuario().getId();
            nomeUsuario = log.getUsuario().getNome();
        }
    }
}
