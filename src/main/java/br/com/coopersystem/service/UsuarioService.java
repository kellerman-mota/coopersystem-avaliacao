package br.com.coopersystem.service;

import br.com.coopersystem.dto.UsuarioDTO;
import br.com.coopersystem.model.Usuario;
import br.com.coopersystem.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public void salvar(UsuarioDTO usuarioDTO) {
        usuarioRepository.save(usuarioDTO.toEntity());
    }

    public UsuarioDTO getDTO(Long id) {
        return new UsuarioDTO(usuarioRepository.getOne(id));
    }
}
