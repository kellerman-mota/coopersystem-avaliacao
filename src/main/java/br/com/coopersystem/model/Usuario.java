package br.com.coopersystem.model;

import br.com.coopersystem.model.enums.UsuarioPerfil;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "tb_usuario")
public class Usuario extends Entidade<Long> {

    private String login;

    private String senha;

    @Enumerated(EnumType.STRING)
    private UsuarioPerfil perfil;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public UsuarioPerfil getPerfil() {
        return perfil;
    }

    public void setPerfil(UsuarioPerfil perfil) {
        this.perfil = perfil;
    }
}
