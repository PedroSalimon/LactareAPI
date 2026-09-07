package com.lactare.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.lactare.api.dto.NotificacaoRequestDTO;
import com.lactare.api.dto.NotificacaoResponseDTO;
import com.lactare.api.service.NotificacaoService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/notificacoes")
public class NotificacaoController {

    @Autowired
    private NotificacaoService notificacaoService;

    @GetMapping
    public ResponseEntity<List<NotificacaoResponseDTO>> getAll() {
        List<NotificacaoResponseDTO> list = notificacaoService.findAllNotificacoes();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificacaoResponseDTO> getById(@PathVariable Long id) {
        NotificacaoResponseDTO responseDTO = notificacaoService.findNotificacaoById(id);
        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping
    public ResponseEntity<NotificacaoResponseDTO> create(@RequestBody @Valid NotificacaoRequestDTO requestDTO) {
        NotificacaoResponseDTO responseDTO = notificacaoService.saveNotificacao(requestDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(responseDTO.getId())
                .toUri();
        return ResponseEntity.created(uri).body(responseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotificacaoResponseDTO> update(@PathVariable Long id, @Valid @RequestBody NotificacaoRequestDTO requestDTO) {
        NotificacaoResponseDTO responseDTO = notificacaoService.updateNotificacao(id, requestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        notificacaoService.deleteNotificacaoById(id);
        return ResponseEntity.noContent().build();
    }
}
