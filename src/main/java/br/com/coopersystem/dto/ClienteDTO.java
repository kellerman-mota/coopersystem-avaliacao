package br.com.coopersystem.dto;

import br.com.coopersystem.base.DTO;
import br.com.coopersystem.model.Cliente;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ClienteDTO extends DTO<Cliente> {

    private Long id;

    private String nome;

    private String cpf;

    private Set<TelefoneDTO> telefones = new HashSet<>();

    private EnderecoDTO endereco = new EnderecoDTO();

    private Set<String> emails = new HashSet<>();

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.emails = cliente.getEmails();
        this.endereco = new EnderecoDTO(cliente.getEndereco());
        this.telefones.addAll(cliente.getTelefones().stream().map(t -> new TelefoneDTO(t)).collect(Collectors.toList()));
    }

    public ClienteDTO() {
    }

    public Long getId() {
        return id;
    }

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

    public Set<TelefoneDTO> getTelefones() {
        return telefones;
    }

    public void setTelefones(Set<TelefoneDTO> telefones) {
        this.telefones = telefones;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }

    public Set<String> getEmails() {
        return emails;
    }

    public void setEmails(Set<String> emails) {
        this.emails = emails;
    }

    public void addEmail(String email) {
        this.emails.add(email);
    }

    public void addTelefone(TelefoneDTO telefoneDTO) {
        this.telefones.add(telefoneDTO);
    }

    @Override
    public Cliente toEntity() {
        Cliente cliente = new Cliente();
        cliente.setId(getId());
        cliente.setCpf(getCpf());
        cliente.setNome(getNome());
        cliente.setEndereco(getEndereco().toEntity());
        getTelefones().forEach(t -> cliente.addTelefone(t.toEntity()));
        getEmails().forEach(e -> cliente.addEmail(e));
        return cliente;
    }
}
