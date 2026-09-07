package com.lactare.api.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PerguntaRequestDTO {
    @NotBlank(message = "O campo texto da pergunta é obrigatório")
    @Size(max = 500, message = "O campo texto da pergunta deve ter no máximo 500 caracteres")
    private String textoPergunta;
    @NotBlank(message = "O campo categoria é obrigatório")
    @Size(max = 50, message = "O campo categoria deve ter no máximo 50 caracteres")
    private String categoria;
    @NotNull(message = "O campo data de registro é obrigatório")
    @PastOrPresent(message = "O campo data de registro deve ser passada ou presente")
    private LocalDate dataRegistro;
    @NotNull(message = "O campo id do usuário é obrigatório")
    private Long idUsuario;
    private Long idSolucao;
}
