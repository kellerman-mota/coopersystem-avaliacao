package br.com.coopersystem.endpoints;

import br.com.coopersystem.dto.ClienteDTO;
import br.com.coopersystem.dto.EnderecoDTO;
import br.com.coopersystem.dto.TelefoneDTO;
import br.com.coopersystem.dto.UsuarioDTO;
import br.com.coopersystem.model.Telefone;
import br.com.coopersystem.model.enums.TelefoneTipo;
import br.com.coopersystem.service.ClienteService;
import br.com.coopersystem.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashSet;

@RestController
@RequestMapping("/clientes")
public class ClienteEndpoint {

    @Autowired
    ClienteService clienteService;

    @PostMapping
    public ResponseEntity<String> salvar(@RequestBody ClienteDTO clienteDTO) {
        clienteService.salvar(clienteDTO);
        return ResponseEntity.ok("Usuario salvo com sucesso!");
    }

    @PostMapping(path = "/padrao")
    public ResponseEntity<String> salvar() {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setCpf("01484859103");
        clienteDTO.addEmail("kellermanpaulo@hotmail.com");
        clienteDTO.addEmail("kellermanpaulomota@gmail.com");
        TelefoneDTO telefoneDTO = new TelefoneDTO();
        telefoneDTO.setNumero("62983307018");
        telefoneDTO.setTipo(TelefoneTipo.CELULAR);
        clienteDTO.addTelefone(telefoneDTO);
        EnderecoDTO enderecoDTO = new EnderecoDTO();
        enderecoDTO.setBairro("Campinas");
        enderecoDTO.setCep("74523420");
        enderecoDTO.setCidade("Goiania");
        enderecoDTO.setLogradouro("Rua Formosa");
        enderecoDTO.setComplemento("Proximo Praça Cemiterio");
        enderecoDTO.setUf("GO");
        clienteDTO.setEndereco(enderecoDTO);
        clienteService.salvar(clienteDTO);
        return ResponseEntity.ok("Cliente salvo com sucesso!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(clienteService.getDTO(id));
    }
}
