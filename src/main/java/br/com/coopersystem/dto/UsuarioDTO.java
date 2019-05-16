package br.com.coopersystem.dto;

import br.com.coopersystem.base.DTO;
import br.com.coopersystem.model.Usuario;
import br.com.coopersystem.model.enums.UsuarioPerfil;

public class UsuarioDTO extends DTO<Usuario> {

    private String login;

    private UsuarioPerfil perfil;

    public UsuarioDTO(Usuario usuario) {
        this.login = usuario.getLogin();
        this.perfil = usuario.getPerfil();
    }

    public UsuarioDTO() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public UsuarioPerfil getPerfil() {
        return perfil;
    }

    public void setPerfil(UsuarioPerfil perfil) {
        this.perfil = perfil;
    }

    @Override
    public Usuario toEntity() {
        Usuario usuario = new Usuario();
        usuario.setLogin(getLogin());
        usuario.setPerfil(getPerfil());
        return usuario;
    }
}
