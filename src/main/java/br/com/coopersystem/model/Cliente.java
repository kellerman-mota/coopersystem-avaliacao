package br.com.coopersystem.model;

import br.com.coopersystem.base.Entidade;
import br.com.coopersystem.converter.EmailAttributeConverter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_cliente")
public class Cliente extends Entidade<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_seq_gen")
    @SequenceGenerator(name = "cliente_seq_gen", sequenceName = "cliente_id_seq")
    private Long id;

    private String nome;

    private String cpf;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "cliente")
    private Set<Telefone> telefones = new HashSet<>();

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "endereco_id", foreignKey = @ForeignKey(name = "ENDERECO_ID_FK"))
    private Endereco endereco = new Endereco();

    @Convert(converter = EmailAttributeConverter.class)
    private Set<String> emails = new HashSet<>();

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Set<Telefone> getTelefones() {
        return telefones;
    }

    public void addTelefone(Telefone telefone) {
        telefone.setCliente(this);
        this.telefones.add(telefone);
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Set<String> getEmails() {
        return emails;
    }

    public void addEmail(String email) {
        this.emails.add(email);
    }
}
