package com.lactare.api.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lactare.api.dto.LogMovimentacaoRequestDTO;
import com.lactare.api.dto.LogMovimentacaoResponseDTO;
import com.lactare.api.entity.LogMovimentacao;
import com.lactare.api.entity.Usuario;
import com.lactare.api.exceptions.ResourceNotFoundException;
import com.lactare.api.repositories.LogMovimentacaoRepository;
import com.lactare.api.repositories.UsuarioRepository;

import java.util.List;

@Service
public class LogMovimentacaoService {

    @Autowired
    private LogMovimentacaoRepository logMovimentacaoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public List<LogMovimentacaoResponseDTO> findAllLogs() {
        return logMovimentacaoRepository.findAll().stream().map(LogMovimentacaoResponseDTO::new).toList();
    }

    @Transactional
    public LogMovimentacaoResponseDTO findLogById(Long id) {
        LogMovimentacao log = logMovimentacaoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado. ID: " + id)
        );
        return new LogMovimentacaoResponseDTO(log);
    }

    @Transactional
    public LogMovimentacaoResponseDTO saveLog(LogMovimentacaoRequestDTO logDTO) {
        LogMovimentacao log = new LogMovimentacao();
        mapDtoToLog(logDTO, log);
        log = logMovimentacaoRepository.save(log);
        return new LogMovimentacaoResponseDTO(log);
    }

    @Transactional
    public LogMovimentacaoResponseDTO updateLog(Long id, LogMovimentacaoRequestDTO logDTO) {
        try {
            LogMovimentacao log = logMovimentacaoRepository.getReferenceById(id);
            mapDtoToLog(logDTO, log);
            log = logMovimentacaoRepository.save(log);
            return new LogMovimentacaoResponseDTO(log);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado. ID: " + id);
        }
    }

    @Transactional
    public void deleteLogById(Long id) {
        if (!logMovimentacaoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado. ID: " + id);
        }
        logMovimentacaoRepository.deleteById(id);
    }

    private void mapDtoToLog(LogMovimentacaoRequestDTO logDTO, LogMovimentacao log) {
        log.setAcao(logDTO.getAcao());
        log.setOrigem(logDTO.getOrigem());
        log.setDataHora(logDTO.getDataHora());
        if (logDTO.getIdUsuario() != null) {
            Usuario usuario = usuarioRepository.getReferenceById(logDTO.getIdUsuario());
            log.setUsuario(usuario);
        } else {
            log.setUsuario(null);
        }
    }
}
