package com.lactare.api.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lactare.api.dto.UsuarioRequestDTO;
import com.lactare.api.dto.UsuarioResponseDTO;
import com.lactare.api.entity.Usuario;
import com.lactare.api.exceptions.ResourceNotFoundException;
import com.lactare.api.repositories.UsuarioRepository;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public List<UsuarioResponseDTO> findAllUsuarios() {
        return usuarioRepository.findAll().stream().map(UsuarioResponseDTO::new).toList();
    }

    @Transactional
    public UsuarioResponseDTO findUsuarioById(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado. ID: " + id)
        );
        return new UsuarioResponseDTO(usuario);
    }

    @Transactional
    public UsuarioResponseDTO saveUsuario(UsuarioRequestDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        mapDtoToUsuario(usuarioDTO, usuario);
        usuario = usuarioRepository.save(usuario);
        return new UsuarioResponseDTO(usuario);
    }

    @Transactional
    public UsuarioResponseDTO updateUsuario(Long id, UsuarioRequestDTO usuarioDTO) {
        try {
            Usuario usuario = usuarioRepository.getReferenceById(id);
            mapDtoToUsuario(usuarioDTO, usuario);
            usuario = usuarioRepository.save(usuario);
            return new UsuarioResponseDTO(usuario);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado. ID: " + id);
        }
    }

    @Transactional
    public void deleteUsuarioById(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado. ID: " + id);
        }
        usuarioRepository.deleteById(id);
    }

    private void mapDtoToUsuario(UsuarioRequestDTO usuarioDTO, Usuario usuario) {
        usuario.setNome(usuarioDTO.getNome());
        usuario.setRegiao(usuarioDTO.getRegiao());
        usuario.setEhNutriz(usuarioDTO.getEhNutriz());
        usuario.setTelefoneWhatsapp(usuarioDTO.getTelefoneWhatsapp());
        usuario.setDataCadastro(usuarioDTO.getDataCadastro());
    }
}
