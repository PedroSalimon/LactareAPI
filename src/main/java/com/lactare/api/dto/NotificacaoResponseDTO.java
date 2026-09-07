package com.lactare.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.lactare.api.entity.Notificacao;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class NotificacaoResponseDTO {
    private Long id;
    private String tipo;
    private String mensagem;
    private LocalDate dataEnvio;
    private Boolean statusEnvio;
    private Long idUsuario;
    private String nomeUsuario;

    public NotificacaoResponseDTO(Notificacao notificacao) {
        id = notificacao.getId();
        tipo = notificacao.getTipo();
        mensagem = notificacao.getMensagem();
        dataEnvio = notificacao.getDataEnvio();
        statusEnvio = notificacao.getStatusEnvio();
        idUsuario = notificacao.getUsuario().getId();
        nomeUsuario = notificacao.getUsuario().getNome();
    }
}
