package br.com.coopersystem;

import br.com.coopersystem.service.UsuarioService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    TokenSession tokenSession;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String tokenHeader = request.getHeader("token");
        if (StringUtils.equals(tokenHeader, tokenSession.getValor())) {
            return true;
        }
        throw new Exception("Acesso Negado");
    }
}
