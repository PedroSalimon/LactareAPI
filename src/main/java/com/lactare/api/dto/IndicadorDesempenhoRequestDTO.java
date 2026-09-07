package com.lactare.api.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class IndicadorDesempenhoRequestDTO {
    @NotBlank(message = "O campo nome do indicador é obrigatório")
    @Size(max = 100, message = "O campo nome do indicador deve ter no máximo 100 caracteres")
    private String nomeIndicador;
    @NotNull(message = "O campo valor é obrigatório")
    @PositiveOrZero(message = "O valor deve ser zero ou positivo")
    private Double valor;
    @NotBlank(message = "O campo período de referência é obrigatório")
    @Size(max = 20, message = "O campo período de referência deve ter no máximo 20 caracteres")
    private String periodoReferencia;
    @NotBlank(message = "O campo região é obrigatório")
    @Size(max = 100, message = "O campo região deve ter no máximo 100 caracteres")
    private String regiao;
}
