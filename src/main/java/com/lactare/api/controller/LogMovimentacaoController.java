package com.lactare.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.lactare.api.dto.LogMovimentacaoRequestDTO;
import com.lactare.api.dto.LogMovimentacaoResponseDTO;
import com.lactare.api.service.LogMovimentacaoService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/logs")
public class LogMovimentacaoController {

    @Autowired
    private LogMovimentacaoService logMovimentacaoService;

    @GetMapping
    public ResponseEntity<List<LogMovimentacaoResponseDTO>> getAll() {
        List<LogMovimentacaoResponseDTO> list = logMovimentacaoService.findAllLogs();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LogMovimentacaoResponseDTO> getById(@PathVariable Long id) {
        LogMovimentacaoResponseDTO responseDTO = logMovimentacaoService.findLogById(id);
        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping
    public ResponseEntity<LogMovimentacaoResponseDTO> create(@RequestBody @Valid LogMovimentacaoRequestDTO requestDTO) {
        LogMovimentacaoResponseDTO responseDTO = logMovimentacaoService.saveLog(requestDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(responseDTO.getId())
                .toUri();
        return ResponseEntity.created(uri).body(responseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LogMovimentacaoResponseDTO> update(@PathVariable Long id, @Valid @RequestBody LogMovimentacaoRequestDTO requestDTO) {
        LogMovimentacaoResponseDTO responseDTO = logMovimentacaoService.updateLog(id, requestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        logMovimentacaoService.deleteLogById(id);
        return ResponseEntity.noContent().build();
    }
}
