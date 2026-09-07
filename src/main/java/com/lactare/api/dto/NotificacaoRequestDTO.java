package com.lactare.api.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class NotificacaoRequestDTO {
    @NotBlank(message = "O campo tipo é obrigatório")
    @Size(max = 50, message = "O campo tipo deve ter no máximo 50 caracteres")
    private String tipo;
    @NotBlank(message = "O campo mensagem é obrigatório")
    @Size(max = 300, message = "O campo mensagem deve ter no máximo 300 caracteres")
    private String mensagem;
    @NotNull(message = "O campo data de envio é obrigatório")
    private LocalDate dataEnvio;
    @NotNull(message = "O campo status de envio é obrigatório")
    private Boolean statusEnvio;
    @NotNull(message = "O campo id do usuário é obrigatório")
    private Long idUsuario;
}
