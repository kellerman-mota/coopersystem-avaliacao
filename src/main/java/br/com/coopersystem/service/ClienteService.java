package br.com.coopersystem.service;

import br.com.coopersystem.dto.ClienteDTO;
import br.com.coopersystem.dto.UsuarioDTO;
import br.com.coopersystem.repository.ClienteRepository;
import br.com.coopersystem.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public void salvar(ClienteDTO clienteDTO) {
        clienteRepository.save(clienteDTO.toEntity());
    }

    public ClienteDTO getDTO(Long id) {
        return new ClienteDTO(clienteRepository.getOne(id));
    }
}
