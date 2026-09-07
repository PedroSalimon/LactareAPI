package com.lactare.api.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ContratoSuporteRequestDTO {
    @NotBlank(message = "O campo tipo de contrato é obrigatório")
    @Size(max = 50, message = "O campo tipo de contrato deve ter no máximo 50 caracteres")
    private String tipoContrato;
    @NotNull(message = "O campo data de início é obrigatório")
    private LocalDate dataInicio;
    @Future(message = "O campo de data do fim do contrato não pode ser hoje nem no passado")
    private LocalDate dataFim;
    @NotBlank(message = "O campo status é obrigatório")
    @Size(max = 30, message = "O campo status deve ter no máximo 30 caracteres")
    private String status;
    @NotNull(message = "O campo id do usuário é obrigatório")
    private Long idUsuario;
}
