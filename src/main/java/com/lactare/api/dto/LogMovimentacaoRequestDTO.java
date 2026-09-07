package com.lactare.api.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LogMovimentacaoRequestDTO {
    @NotBlank(message = "O campo ação é obrigatório")
    @Size(max = 100, message = "O campo ação deve ter no máximo 100 caracteres")
    private String acao;
    @NotBlank(message = "O campo origem é obrigatório")
    @Size(max = 50, message = "O campo origem deve ter no máximo 50 caracteres")
    private String origem;
    @NotNull(message = "O campo data/hora é obrigatório")
    private LocalDateTime dataHora;
    private Long idUsuario;
}
