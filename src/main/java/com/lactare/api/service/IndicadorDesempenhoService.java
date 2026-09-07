package com.lactare.api.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lactare.api.dto.IndicadorDesempenhoRequestDTO;
import com.lactare.api.dto.IndicadorDesempenhoResponseDTO;
import com.lactare.api.entity.IndicadorDesempenho;
import com.lactare.api.exceptions.ResourceNotFoundException;
import com.lactare.api.repositories.IndicadorDesempenhoRepository;

import java.util.List;

@Service
public class IndicadorDesempenhoService {

    @Autowired
    private IndicadorDesempenhoRepository indicadorDesempenhoRepository;

    @Transactional
    public List<IndicadorDesempenhoResponseDTO> findAllIndicadores() {
        return indicadorDesempenhoRepository.findAll().stream().map(IndicadorDesempenhoResponseDTO::new).toList();
    }

    @Transactional
    public IndicadorDesempenhoResponseDTO findIndicadorById(Long id) {
        IndicadorDesempenho indicador = indicadorDesempenhoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado. ID: " + id)
        );
        return new IndicadorDesempenhoResponseDTO(indicador);
    }

    @Transactional
    public IndicadorDesempenhoResponseDTO saveIndicador(IndicadorDesempenhoRequestDTO indicadorDTO) {
        IndicadorDesempenho indicador = new IndicadorDesempenho();
        mapDtoToIndicador(indicadorDTO, indicador);
        indicador = indicadorDesempenhoRepository.save(indicador);
        return new IndicadorDesempenhoResponseDTO(indicador);
    }

    @Transactional
    public IndicadorDesempenhoResponseDTO updateIndicador(Long id, IndicadorDesempenhoRequestDTO indicadorDTO) {
        try {
            IndicadorDesempenho indicador = indicadorDesempenhoRepository.getReferenceById(id);
            mapDtoToIndicador(indicadorDTO, indicador);
            indicador = indicadorDesempenhoRepository.save(indicador);
            return new IndicadorDesempenhoResponseDTO(indicador);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado. ID: " + id);
        }
    }

    @Transactional
    public void deleteIndicadorById(Long id) {
        if (!indicadorDesempenhoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado. ID: " + id);
        }
        indicadorDesempenhoRepository.deleteById(id);
    }

    private void mapDtoToIndicador(IndicadorDesempenhoRequestDTO indicadorDTO, IndicadorDesempenho indicador) {
        indicador.setNomeIndicador(indicadorDTO.getNomeIndicador());
        indicador.setValor(indicadorDTO.getValor());
        indicador.setPeriodoReferencia(indicadorDTO.getPeriodoReferencia());
        indicador.setRegiao(indicadorDTO.getRegiao());
    }
}
