package psoft.ufcg.lab2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import psoft.ufcg.lab2.Entities.Usuario;
import psoft.ufcg.lab2.Repository.UsuarioRepository;

import javax.servlet.ServletException;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository<Usuario, String> usuarioDAO;

    public UsuarioService (UsuarioRepository<Usuario, String> usuarioDAO)  {
        super();
        this.usuarioDAO = usuarioDAO;
    }

    public Usuario adcionaUsuario(Usuario usuario) {
        usuarioDAO.save(usuario);
        return usuario;
    }


    public Usuario authenticaService(String email, String senha) {
         Usuario usuario = usuarioDAO.findById(email).get();
         return usuario;

    }

    public Optional<Usuario> getUsuario(String email) {
        return this.usuarioDAO.findById(email);
    }

    public Usuario removeUsuario (String email) throws  ServletException{
        Optional<Usuario> usuario = usuarioDAO.findById(email);
        if (usuario.isPresent()) {
            usuarioDAO.delete(usuario.get());
            return usuario.get();
        }
        throw new ServletException("Usuario not founded");
    }
}
