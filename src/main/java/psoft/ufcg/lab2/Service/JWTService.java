package psoft.ufcg.lab2.Service;


import com.fasterxml.jackson.core.filter.TokenFilter;
import org.springframework.stereotype.Service;
import psoft.ufcg.lab2.Entities.Usuario;

import javax.servlet.ServletException;
import java.security.SignatureException;
import java.util.Optional;

@Service
public class JWTService {
    private UsuarioService usuarioService;
    private final String TOKEN_KEY = "Login";

    public JWTService (UsuarioService usuarioService) {
        super();
        this.usuarioService = usuarioService;

    }

    public boolean usuarioExists (String authorizationHeader) throws ServletException {
        String subject = getSujeitoDoToken(authorizationHeader);

        return usuarioService.getUsuario(subject).isPresent();

    }

    public boolean usuarioHavePermision (String authorizationHeader, String email) throws ServletException {
        String subject = getSujeitoDoToken(authorizationHeader);

        Optional<Usuario> optUsuario = usuarioService.getUsuario(subject);
        return optUsuario.isPresent() && optUsuario.get().getEmail().equals(email);
    }

    private String getSujeitoDoToken (String authorizationHeader) throws ServletException{
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new ServletException("Token Inexistente ou errado");
        }

        String token = authorizationHeader.substring(TokenFilter.TOKEN_INDEX);
        String subject = null;

        try {
            subject = Jwts.parser().setSigningKey("login").parseClaimsJws(token).getBody().getSubject();
        } catch (SignatureException s) {
            throw new ServletException()
        }
    }

}
