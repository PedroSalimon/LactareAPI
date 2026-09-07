package com.lactare.api.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lactare.api.dto.AvaliacaoRequestDTO;
import com.lactare.api.dto.AvaliacaoResponseDTO;
import com.lactare.api.entity.Avaliacao;
import com.lactare.api.entity.Usuario;
import com.lactare.api.exceptions.ResourceNotFoundException;
import com.lactare.api.repositories.AvaliacaoRepository;
import com.lactare.api.repositories.UsuarioRepository;

import java.util.List;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public List<AvaliacaoResponseDTO> findAllAvaliacoes() {
        return avaliacaoRepository.findAll().stream().map(AvaliacaoResponseDTO::new).toList();
    }

    @Transactional
    public AvaliacaoResponseDTO findAvaliacaoById(Long id) {
        Avaliacao avaliacao = avaliacaoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado. ID: " + id)
        );
        return new AvaliacaoResponseDTO(avaliacao);
    }

    @Transactional
    public AvaliacaoResponseDTO saveAvaliacao(AvaliacaoRequestDTO avaliacaoDTO) {
        Avaliacao avaliacao = new Avaliacao();
        mapDtoToAvaliacao(avaliacaoDTO, avaliacao);
        avaliacao = avaliacaoRepository.save(avaliacao);
        return new AvaliacaoResponseDTO(avaliacao);
    }

    @Transactional
    public AvaliacaoResponseDTO updateAvaliacao(Long id, AvaliacaoRequestDTO avaliacaoDTO) {
        try {
            Avaliacao avaliacao = avaliacaoRepository.getReferenceById(id);
            mapDtoToAvaliacao(avaliacaoDTO, avaliacao);
            avaliacao = avaliacaoRepository.save(avaliacao);
            return new AvaliacaoResponseDTO(avaliacao);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado. ID: " + id);
        }
    }

    @Transactional
    public void deleteAvaliacaoById(Long id) {
        if (!avaliacaoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado. ID: " + id);
        }
        avaliacaoRepository.deleteById(id);
    }

    private void mapDtoToAvaliacao(AvaliacaoRequestDTO avaliacaoDTO, Avaliacao avaliacao) {
        avaliacao.setNota(avaliacaoDTO.getNota());
        avaliacao.setComentario(avaliacaoDTO.getComentario());
        avaliacao.setDataAvaliacao(avaliacaoDTO.getDataAvaliacao());
        Usuario usuario = usuarioRepository.getReferenceById(avaliacaoDTO.getIdUsuario());
        avaliacao.setUsuario(usuario);
    }
}
