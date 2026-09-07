package com.lactare.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.lactare.api.dto.AvaliacaoRequestDTO;
import com.lactare.api.dto.AvaliacaoResponseDTO;
import com.lactare.api.service.AvaliacaoService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @GetMapping
    public ResponseEntity<List<AvaliacaoResponseDTO>> getAll() {
        List<AvaliacaoResponseDTO> list = avaliacaoService.findAllAvaliacoes();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvaliacaoResponseDTO> getById(@PathVariable Long id) {
        AvaliacaoResponseDTO responseDTO = avaliacaoService.findAvaliacaoById(id);
        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping
    public ResponseEntity<AvaliacaoResponseDTO> create(@RequestBody @Valid AvaliacaoRequestDTO requestDTO) {
        AvaliacaoResponseDTO responseDTO = avaliacaoService.saveAvaliacao(requestDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(responseDTO.getId())
                .toUri();
        return ResponseEntity.created(uri).body(responseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AvaliacaoResponseDTO> update(@PathVariable Long id, @Valid @RequestBody AvaliacaoRequestDTO requestDTO) {
        AvaliacaoResponseDTO responseDTO = avaliacaoService.updateAvaliacao(id, requestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        avaliacaoService.deleteAvaliacaoById(id);
        return ResponseEntity.noContent().build();
    }
}
