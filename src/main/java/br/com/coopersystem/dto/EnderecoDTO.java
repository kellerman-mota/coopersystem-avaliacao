package br.com.coopersystem.dto;

import br.com.coopersystem.base.DTO;
import br.com.coopersystem.model.Endereco;

public class EnderecoDTO extends DTO<Endereco> {

    private Long id;

    private String cep;

    private String logradouro;

    private String bairro;

    private String cidade;

    private String uf;

    private String complemento;


    public EnderecoDTO(Endereco endereco) {
        this.id = endereco.getId();
        this.cep = endereco.getCep();
        this.logradouro = endereco.getLogradouro();
        this.bairro = endereco.getBairro();
        this.cidade = endereco.getCidade();
        this.uf = endereco.getUf();
        this.complemento = endereco.getComplemento();
    }

    public EnderecoDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Override
    public Endereco toEntity() {
        Endereco endereco = new Endereco();
        endereco.setComplemento(getComplemento());
        endereco.setCidade(getCidade());
        endereco.setCep(getCep());
        endereco.setBairro(getBairro());
        endereco.setId(getId());
        endereco.setLogradouro(getLogradouro());
        endereco.setUf(getUf());
        return endereco;
    }
}
