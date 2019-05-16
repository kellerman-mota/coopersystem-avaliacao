package br.com.coopersystem.base;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;
import java.util.Objects;

@MappedSuperclass
public abstract class Entidade<T> {

    @Column(name = "dt_cadastro")
    private Date dataCadastro;

    @Column(name = "dt_alteracao")
    private Date dataAlteracao;

    @Column(name = "owner_id")
    private Long owner;

    @PrePersist
    public void onSalvar() {

        this.setDataCadastro(new Date());
    }

    @PreUpdate
    public void onAlterar() {

        this.setDataAlteracao(new Date());
    }

    public abstract T getId();

    public abstract void setId(T id);

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public Long getOwner() {
        return owner;
    }

    public void setOwner(Long owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entidade)) return false;
        Entidade<?> entidade = (Entidade<?>) o;
        return Objects.equals(getId(), entidade.getId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
    }
}
