package com.lactare.api.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SolucaoConhecidaRequestDTO {
    @NotBlank(message = "O campo título é obrigatório")
    @Size(max = 150, message = "O campo título deve ter no máximo 150 caracteres")
    private String titulo;
    @NotBlank(message = "O campo descrição da resposta é obrigatório")
    @Size(max = 1000, message = "O campo descrição da resposta deve ter no máximo 1000 caracteres")
    private String descricaoResposta;
    @Size(max = 255, message = "O campo link do site deve ter no máximo 255 caracteres")
    private String linkSite;
    @NotBlank(message = "O campo categoria é obrigatório")
    @Size(max = 50, message = "O campo categoria deve ter no máximo 50 caracteres")
    private String categoria;
}
