package com.lactare.api.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lactare.api.dto.PerguntaRequestDTO;
import com.lactare.api.dto.PerguntaResponseDTO;
import com.lactare.api.entity.Pergunta;
import com.lactare.api.entity.SolucaoConhecida;
import com.lactare.api.entity.Usuario;
import com.lactare.api.exceptions.ResourceNotFoundException;
import com.lactare.api.repositories.PerguntaRepository;
import com.lactare.api.repositories.SolucaoConhecidaRepository;
import com.lactare.api.repositories.UsuarioRepository;

import java.util.List;

@Service
public class PerguntaService {

    @Autowired
    private PerguntaRepository perguntaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private SolucaoConhecidaRepository solucaoConhecidaRepository;

    @Transactional
    public List<PerguntaResponseDTO> findAllPerguntas() {
        return perguntaRepository.findAll().stream().map(PerguntaResponseDTO::new).toList();
    }

    @Transactional
    public PerguntaResponseDTO findPerguntaById(Long id) {
        Pergunta pergunta = perguntaRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado. ID: " + id)
        );
        return new PerguntaResponseDTO(pergunta);
    }

    @Transactional
    public PerguntaResponseDTO savePergunta(PerguntaRequestDTO perguntaDTO) {
        Pergunta pergunta = new Pergunta();
        mapDtoToPergunta(perguntaDTO, pergunta);
        pergunta = perguntaRepository.save(pergunta);
        return new PerguntaResponseDTO(pergunta);
    }

    @Transactional
    public PerguntaResponseDTO updatePergunta(Long id, PerguntaRequestDTO perguntaDTO) {
        try {
            Pergunta pergunta = perguntaRepository.getReferenceById(id);
            mapDtoToPergunta(perguntaDTO, pergunta);
            pergunta = perguntaRepository.save(pergunta);
            return new PerguntaResponseDTO(pergunta);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado. ID: " + id);
        }
    }

    @Transactional
    public void deletePerguntaById(Long id) {
        if (!perguntaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado. ID: " + id);
        }
        perguntaRepository.deleteById(id);
    }

    private void mapDtoToPergunta(PerguntaRequestDTO perguntaDTO, Pergunta pergunta) {
        pergunta.setTextoPergunta(perguntaDTO.getTextoPergunta());
        pergunta.setCategoria(perguntaDTO.getCategoria());
        pergunta.setDataRegistro(perguntaDTO.getDataRegistro());
        Usuario usuario = usuarioRepository.getReferenceById(perguntaDTO.getIdUsuario());
        pergunta.setUsuario(usuario);
        if (perguntaDTO.getIdSolucao() != null) {
            SolucaoConhecida solucao = solucaoConhecidaRepository.getReferenceById(perguntaDTO.getIdSolucao());
            pergunta.setSolucao(solucao);
        } else {
            pergunta.setSolucao(null);
        }
    }
}
