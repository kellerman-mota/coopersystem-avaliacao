package br.com.coopersystem.service;

import br.com.coopersystem.dto.UsuarioDTO;
import br.com.coopersystem.model.Usuario;
import br.com.coopersystem.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

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

    public String autenticar(String login, String senha) {
        Usuario usuario = new Usuario();
        usuario.setLogin(login);
        usuario.setSenha(senha);
        List<Usuario> usuarios = usuarioRepository.findAll(Example.of(usuario));
        if (usuarios.stream().findFirst().isPresent()) {
            return UUID.randomUUID().toString();
        }
        return null;
    }
}
