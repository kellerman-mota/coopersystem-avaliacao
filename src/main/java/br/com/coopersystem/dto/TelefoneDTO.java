package br.com.coopersystem.dto;

import br.com.coopersystem.base.DTO;
import br.com.coopersystem.model.Telefone;
import br.com.coopersystem.model.enums.TelefoneTipo;

public class TelefoneDTO extends DTO<Telefone> {

    private String numero;

    private TelefoneTipo tipo;

    public TelefoneDTO(Telefone telefone) {
        this.numero = telefone.getNumero();
        this.tipo = telefone.getTipo();
    }

    public TelefoneDTO() {
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

    @Override
    public Telefone toEntity() {
        Telefone telefone = new Telefone();
        telefone.setNumero(getNumero());
        telefone.setTipo(getTipo());
        return telefone;
    }
}
