package com.lactare.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.lactare.api.dto.SolucaoConhecidaRequestDTO;
import com.lactare.api.dto.SolucaoConhecidaResponseDTO;
import com.lactare.api.service.SolucaoConhecidaService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/solucoes")
public class SolucaoConhecidaController {

    @Autowired
    private SolucaoConhecidaService solucaoConhecidaService;

    @GetMapping
    public ResponseEntity<List<SolucaoConhecidaResponseDTO>> getAll() {
        List<SolucaoConhecidaResponseDTO> list = solucaoConhecidaService.findAllSolucoes();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolucaoConhecidaResponseDTO> getById(@PathVariable Long id) {
        SolucaoConhecidaResponseDTO responseDTO = solucaoConhecidaService.findSolucaoById(id);
        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping
    public ResponseEntity<SolucaoConhecidaResponseDTO> create(@RequestBody @Valid SolucaoConhecidaRequestDTO requestDTO) {
        SolucaoConhecidaResponseDTO responseDTO = solucaoConhecidaService.saveSolucao(requestDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(responseDTO.getId())
                .toUri();
        return ResponseEntity.created(uri).body(responseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SolucaoConhecidaResponseDTO> update(@PathVariable Long id, @Valid @RequestBody SolucaoConhecidaRequestDTO requestDTO) {
        SolucaoConhecidaResponseDTO responseDTO = solucaoConhecidaService.updateSolucao(id, requestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        solucaoConhecidaService.deleteSolucaoById(id);
        return ResponseEntity.noContent().build();
    }
}
