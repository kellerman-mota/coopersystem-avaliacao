package br.com.coopersystem.model;

import br.com.coopersystem.base.Entidade;
import br.com.coopersystem.model.enums.UsuarioPerfil;

import javax.persistence.*;

@Entity
@Table(name = "tb_usuario")
public class Usuario extends Entidade<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_seq_gen")
    @SequenceGenerator(name = "usuario_seq_gen", sequenceName = "usuario_id_seq")
    private Long id;

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

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
