package br.com.coopersystem.model;

import br.com.coopersystem.base.Entidade;
import br.com.coopersystem.model.enums.TelefoneTipo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_telefone")
@IdClass(Telefone.ID.class)
public class Telefone extends Entidade<String> {

    @Id
    private String numero;

    @Id
    @Enumerated(EnumType.STRING)
    private TelefoneTipo tipo;

    @ManyToOne
    @JoinColumn(name = "cliente_id", foreignKey = @ForeignKey(name = "CLIENTE_ID_FK"))
    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TelefoneTipo getTipo() {
        return tipo;
    }

    public void setTipo(TelefoneTipo tipo) {
        this.tipo = tipo;
    }

    public static class ID implements Serializable {
        String numero;
        TelefoneTipo tipo;
    }

    @Override
    public String getId() {
        return String.join(":", numero, tipo.toString());
    }

    @Override
    public void setId(String id) {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Telefone)) return false;
        Telefone telefone = (Telefone) o;
        return Objects.equals(numero, telefone.numero) &&
                tipo == telefone.tipo;
    }

    @Override
    public int hashCode() {

        return Objects.hash(numero, tipo);
    }
}
