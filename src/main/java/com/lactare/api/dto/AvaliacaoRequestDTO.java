package com.lactare.api.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AvaliacaoRequestDTO {
    @NotNull(message = "O campo nota é obrigatório")
    @Min(value = 0, message = "A nota deve ser no mínimo 0")
    @Max(value = 10, message = "A nota deve ser no máximo 10")
    private Integer nota;
    @Size(max = 300, message = "O campo comentário deve ter no máximo 300 caracteres")
    private String comentario;
    @NotNull(message = "O campo data de avaliação é obrigatório")
    @PastOrPresent(message = "O campo data de avaliação deve ser passada ou presente")
    private LocalDate dataAvaliacao;
    @NotNull(message = "O campo id do usuário é obrigatório")
    private Long idUsuario;
}
