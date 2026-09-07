package com.lactare.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.lactare.api.entity.ContratoSuporte;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ContratoSuporteResponseDTO {
    private Long id;
    private String tipoContrato;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String status;
    private Long idUsuario;
    private String nomeUsuario;

    public ContratoSuporteResponseDTO(ContratoSuporte contrato) {
        id = contrato.getId();
        tipoContrato = contrato.getTipoContrato();
        dataInicio = contrato.getDataInicio();
        dataFim = contrato.getDataFim();
        status = contrato.getStatus();
        idUsuario = contrato.getUsuario().getId();
        nomeUsuario = contrato.getUsuario().getNome();
    }
}
