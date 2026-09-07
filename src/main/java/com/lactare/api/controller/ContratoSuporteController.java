package com.lactare.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.lactare.api.dto.ContratoSuporteRequestDTO;
import com.lactare.api.dto.ContratoSuporteResponseDTO;
import com.lactare.api.service.ContratoSuporteService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/contratos")
public class ContratoSuporteController {

    @Autowired
    private ContratoSuporteService contratoSuporteService;

    @GetMapping
    public ResponseEntity<List<ContratoSuporteResponseDTO>> getAll() {
        List<ContratoSuporteResponseDTO> list = contratoSuporteService.findAllContratos();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContratoSuporteResponseDTO> getById(@PathVariable Long id) {
        ContratoSuporteResponseDTO responseDTO = contratoSuporteService.findContratoById(id);
        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping
    public ResponseEntity<ContratoSuporteResponseDTO> create(@RequestBody @Valid ContratoSuporteRequestDTO requestDTO) {
        ContratoSuporteResponseDTO responseDTO = contratoSuporteService.saveContrato(requestDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(responseDTO.getId())
                .toUri();
        return ResponseEntity.created(uri).body(responseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContratoSuporteResponseDTO> update(@PathVariable Long id, @Valid @RequestBody ContratoSuporteRequestDTO requestDTO) {
        ContratoSuporteResponseDTO responseDTO = contratoSuporteService.updateContrato(id, requestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        contratoSuporteService.deleteContratoById(id);
        return ResponseEntity.noContent().build();
    }
}
