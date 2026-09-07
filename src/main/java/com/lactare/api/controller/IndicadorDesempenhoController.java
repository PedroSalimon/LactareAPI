package com.lactare.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.lactare.api.dto.IndicadorDesempenhoRequestDTO;
import com.lactare.api.dto.IndicadorDesempenhoResponseDTO;
import com.lactare.api.service.IndicadorDesempenhoService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/indicadores")
public class IndicadorDesempenhoController {

    @Autowired
    private IndicadorDesempenhoService indicadorDesempenhoService;

    @GetMapping
    public ResponseEntity<List<IndicadorDesempenhoResponseDTO>> getAll() {
        List<IndicadorDesempenhoResponseDTO> list = indicadorDesempenhoService.findAllIndicadores();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IndicadorDesempenhoResponseDTO> getById(@PathVariable Long id) {
        IndicadorDesempenhoResponseDTO responseDTO = indicadorDesempenhoService.findIndicadorById(id);
        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping
    public ResponseEntity<IndicadorDesempenhoResponseDTO> create(@RequestBody @Valid IndicadorDesempenhoRequestDTO requestDTO) {
        IndicadorDesempenhoResponseDTO responseDTO = indicadorDesempenhoService.saveIndicador(requestDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(responseDTO.getId())
                .toUri();
        return ResponseEntity.created(uri).body(responseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IndicadorDesempenhoResponseDTO> update(@PathVariable Long id, @Valid @RequestBody IndicadorDesempenhoRequestDTO requestDTO) {
        IndicadorDesempenhoResponseDTO responseDTO = indicadorDesempenhoService.updateIndicador(id, requestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        indicadorDesempenhoService.deleteIndicadorById(id);
        return ResponseEntity.noContent().build();
    }
}
