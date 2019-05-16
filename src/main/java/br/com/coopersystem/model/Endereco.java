package br.com.coopersystem.model;

import br.com.coopersystem.base.Entidade;

import javax.persistence.*;

@Entity
@Table(name = "tb_endereco")
public class Endereco extends Entidade<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco_seq_gen")
    @SequenceGenerator(name = "endereco_seq_gen", sequenceName = "endereco_id_seq")
    private Long id;

    private String cep;

    private String logradouro;

    private String bairro;

    private String cidade;

    private String uf;

    private String complemento;

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
}
