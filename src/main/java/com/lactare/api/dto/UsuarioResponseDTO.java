package com.lactare.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.lactare.api.entity.Usuario;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UsuarioResponseDTO {
    private Long id;
    private String nome;
    private String regiao;
    private Boolean ehNutriz;
    private String telefoneWhatsapp;
    private LocalDate dataCadastro;

    public UsuarioResponseDTO(Usuario usuario) {
        id = usuario.getId();
        nome = usuario.getNome();
        regiao = usuario.getRegiao();
        ehNutriz = usuario.getEhNutriz();
        telefoneWhatsapp = usuario.getTelefoneWhatsapp();
        dataCadastro = usuario.getDataCadastro();
    }
}
