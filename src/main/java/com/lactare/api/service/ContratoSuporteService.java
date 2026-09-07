package com.lactare.api.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lactare.api.dto.ContratoSuporteRequestDTO;
import com.lactare.api.dto.ContratoSuporteResponseDTO;
import com.lactare.api.entity.ContratoSuporte;
import com.lactare.api.entity.Usuario;
import com.lactare.api.exceptions.ResourceNotFoundException;
import com.lactare.api.repositories.ContratoSuporteRepository;
import com.lactare.api.repositories.UsuarioRepository;

import java.util.List;

@Service
public class ContratoSuporteService {

    @Autowired
    private ContratoSuporteRepository contratoSuporteRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public List<ContratoSuporteResponseDTO> findAllContratos() {
        return contratoSuporteRepository.findAll().stream().map(ContratoSuporteResponseDTO::new).toList();
    }

    @Transactional
    public ContratoSuporteResponseDTO findContratoById(Long id) {
        ContratoSuporte contrato = contratoSuporteRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado. ID: " + id)
        );
        return new ContratoSuporteResponseDTO(contrato);
    }

    @Transactional
    public ContratoSuporteResponseDTO saveContrato(ContratoSuporteRequestDTO contratoDTO) {
        ContratoSuporte contrato = new ContratoSuporte();
        mapDtoToContrato(contratoDTO, contrato);
        contrato = contratoSuporteRepository.save(contrato);
        return new ContratoSuporteResponseDTO(contrato);
    }

    @Transactional
    public ContratoSuporteResponseDTO updateContrato(Long id, ContratoSuporteRequestDTO contratoDTO) {
        try {
            ContratoSuporte contrato = contratoSuporteRepository.getReferenceById(id);
            mapDtoToContrato(contratoDTO, contrato);
            contrato = contratoSuporteRepository.save(contrato);
            return new ContratoSuporteResponseDTO(contrato);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado. ID: " + id);
        }
    }

    @Transactional
    public void deleteContratoById(Long id) {
        if (!contratoSuporteRepository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado. ID: " + id);
        }
        contratoSuporteRepository.deleteById(id);
    }

    private void mapDtoToContrato(ContratoSuporteRequestDTO contratoDTO, ContratoSuporte contrato) {
        contrato.setTipoContrato(contratoDTO.getTipoContrato());
        contrato.setDataInicio(contratoDTO.getDataInicio());
        contrato.setDataFim(contratoDTO.getDataFim());
        contrato.setStatus(contratoDTO.getStatus());
        Usuario usuario = usuarioRepository.getReferenceById(contratoDTO.getIdUsuario());
        contrato.setUsuario(usuario);
    }
}
