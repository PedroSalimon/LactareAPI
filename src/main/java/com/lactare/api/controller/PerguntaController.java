package com.lactare.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.lactare.api.dto.PerguntaRequestDTO;
import com.lactare.api.dto.PerguntaResponseDTO;
import com.lactare.api.service.PerguntaService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/perguntas")
public class PerguntaController {

    @Autowired
    private PerguntaService perguntaService;

    @GetMapping
    public ResponseEntity<List<PerguntaResponseDTO>> getAll() {
        List<PerguntaResponseDTO> list = perguntaService.findAllPerguntas();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PerguntaResponseDTO> getById(@PathVariable Long id) {
        PerguntaResponseDTO responseDTO = perguntaService.findPerguntaById(id);
        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping
    public ResponseEntity<PerguntaResponseDTO> create(@RequestBody @Valid PerguntaRequestDTO requestDTO) {
        PerguntaResponseDTO responseDTO = perguntaService.savePergunta(requestDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(responseDTO.getId())
                .toUri();
        return ResponseEntity.created(uri).body(responseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PerguntaResponseDTO> update(@PathVariable Long id, @Valid @RequestBody PerguntaRequestDTO requestDTO) {
        PerguntaResponseDTO responseDTO = perguntaService.updatePergunta(id, requestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        perguntaService.deletePerguntaById(id);
        return ResponseEntity.noContent().build();
    }
}
