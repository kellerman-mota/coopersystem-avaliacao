package br.com.coopersystem.endpoints;

import br.com.coopersystem.TokenSession;
import br.com.coopersystem.dto.UsuarioDTO;
import br.com.coopersystem.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/auth")
public class AuthEndpoint {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    TokenSession tokenSession;

    @PostMapping
    public String login(@RequestHeader(name = "usuario", required = true) String usuario,
                        @RequestHeader(name = "senha", required = true) String senha) throws Exception {
        String token = usuarioService.autenticar(usuario, senha);
        if (token == null) {
            throw new Exception("Usuario ou senha invalidos");
        }

        tokenSession.setValor(token);

        return tokenSession.getValor();
    }
}
