package com.lactare.api.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lactare.api.dto.NotificacaoRequestDTO;
import com.lactare.api.dto.NotificacaoResponseDTO;
import com.lactare.api.entity.Notificacao;
import com.lactare.api.entity.Usuario;
import com.lactare.api.exceptions.ResourceNotFoundException;
import com.lactare.api.repositories.NotificacaoRepository;
import com.lactare.api.repositories.UsuarioRepository;

import java.util.List;

@Service
public class NotificacaoService {

    @Autowired
    private NotificacaoRepository notificacaoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public List<NotificacaoResponseDTO> findAllNotificacoes() {
        return notificacaoRepository.findAll().stream().map(NotificacaoResponseDTO::new).toList();
    }

    @Transactional
    public NotificacaoResponseDTO findNotificacaoById(Long id) {
        Notificacao notificacao = notificacaoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado. ID: " + id)
        );
        return new NotificacaoResponseDTO(notificacao);
    }

    @Transactional
    public NotificacaoResponseDTO saveNotificacao(NotificacaoRequestDTO notificacaoDTO) {
        Notificacao notificacao = new Notificacao();
        mapDtoToNotificacao(notificacaoDTO, notificacao);
        notificacao = notificacaoRepository.save(notificacao);
        return new NotificacaoResponseDTO(notificacao);
    }

    @Transactional
    public NotificacaoResponseDTO updateNotificacao(Long id, NotificacaoRequestDTO notificacaoDTO) {
        try {
            Notificacao notificacao = notificacaoRepository.getReferenceById(id);
            mapDtoToNotificacao(notificacaoDTO, notificacao);
            notificacao = notificacaoRepository.save(notificacao);
            return new NotificacaoResponseDTO(notificacao);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado. ID: " + id);
        }
    }

    @Transactional
    public void deleteNotificacaoById(Long id) {
        if (!notificacaoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado. ID: " + id);
        }
        notificacaoRepository.deleteById(id);
    }

    private void mapDtoToNotificacao(NotificacaoRequestDTO notificacaoDTO, Notificacao notificacao) {
        notificacao.setTipo(notificacaoDTO.getTipo());
        notificacao.setMensagem(notificacaoDTO.getMensagem());
        notificacao.setDataEnvio(notificacaoDTO.getDataEnvio());
        notificacao.setStatusEnvio(notificacaoDTO.getStatusEnvio());
        Usuario usuario = usuarioRepository.getReferenceById(notificacaoDTO.getIdUsuario());
        notificacao.setUsuario(usuario);
    }
}
