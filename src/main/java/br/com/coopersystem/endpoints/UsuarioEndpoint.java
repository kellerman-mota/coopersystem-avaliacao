package br.com.coopersystem.endpoints;

import br.com.coopersystem.dto.UsuarioDTO;
import br.com.coopersystem.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioEndpoint {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<String> salvar(@RequestBody UsuarioDTO usuarioDTO) {
        usuarioService.salvar(usuarioDTO);
        return ResponseEntity.ok("Usuario salvo com sucesso!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(usuarioService.getDTO(id));
    }
}
