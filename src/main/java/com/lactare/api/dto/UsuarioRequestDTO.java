package com.lactare.api.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UsuarioRequestDTO {
    @NotBlank(message = "O campo nome é obrigatório")
    @Size(max = 100, message = "O campo nome deve ter no máximo 100 caracteres")
    private String nome;
    @NotBlank(message = "O campo região é obrigatório")
    @Size(max = 100, message = "O campo região deve ter no máximo 100 caracteres")
    private String regiao;
    @NotNull(message = "O campo ehNutriz é obrigatório")
    private Boolean ehNutriz;
    @NotBlank(message = "O campo telefone do WhatsApp é obrigatório")
    @Size(max = 20, message = "O campo telefone deve ter no máximo 20 caracteres")
    private String telefoneWhatsapp;
    @NotNull(message = "O campo data de cadastro é obrigatório")
    @PastOrPresent(message = "O campo data de cadastro deve ser passada ou presente")
    private LocalDate dataCadastro;
}
