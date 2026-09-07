package com.lactare.api.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lactare.api.dto.SolucaoConhecidaRequestDTO;
import com.lactare.api.dto.SolucaoConhecidaResponseDTO;
import com.lactare.api.entity.SolucaoConhecida;
import com.lactare.api.exceptions.ResourceNotFoundException;
import com.lactare.api.repositories.SolucaoConhecidaRepository;

import java.util.List;

@Service
public class SolucaoConhecidaService {

    @Autowired
    private SolucaoConhecidaRepository solucaoConhecidaRepository;

    @Transactional
    public List<SolucaoConhecidaResponseDTO> findAllSolucoes() {
        return solucaoConhecidaRepository.findAll().stream().map(SolucaoConhecidaResponseDTO::new).toList();
    }

    @Transactional
    public SolucaoConhecidaResponseDTO findSolucaoById(Long id) {
        SolucaoConhecida solucao = solucaoConhecidaRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado. ID: " + id)
        );
        return new SolucaoConhecidaResponseDTO(solucao);
    }

    @Transactional
    public SolucaoConhecidaResponseDTO saveSolucao(SolucaoConhecidaRequestDTO solucaoDTO) {
        SolucaoConhecida solucao = new SolucaoConhecida();
        mapDtoToSolucao(solucaoDTO, solucao);
        solucao = solucaoConhecidaRepository.save(solucao);
        return new SolucaoConhecidaResponseDTO(solucao);
    }

    @Transactional
    public SolucaoConhecidaResponseDTO updateSolucao(Long id, SolucaoConhecidaRequestDTO solucaoDTO) {
        try {
            SolucaoConhecida solucao = solucaoConhecidaRepository.getReferenceById(id);
            mapDtoToSolucao(solucaoDTO, solucao);
            solucao = solucaoConhecidaRepository.save(solucao);
            return new SolucaoConhecidaResponseDTO(solucao);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado. ID: " + id);
        }
    }

    @Transactional
    public void deleteSolucaoById(Long id) {
        if (!solucaoConhecidaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado. ID: " + id);
        }
        solucaoConhecidaRepository.deleteById(id);
    }

    private void mapDtoToSolucao(SolucaoConhecidaRequestDTO solucaoDTO, SolucaoConhecida solucao) {
        solucao.setTitulo(solucaoDTO.getTitulo());
        solucao.setDescricaoResposta(solucaoDTO.getDescricaoResposta());
        solucao.setLinkSite(solucaoDTO.getLinkSite());
        solucao.setCategoria(solucaoDTO.getCategoria());
    }
}
