package psoft.ufcg.lab2.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import psoft.ufcg.lab2.Entities.Usuario;
import psoft.ufcg.lab2.Service.UsuarioService;

@RestController
public class UsuarioController {

    private UsuarioService usuarioService;


    public UsuarioController(){


    }

    @PostMapping("/usuarios")
    public ResponseEntity<Usuario> adcionaUsuario (@RequestBody Usuario usuario) {
        return new ResponseEntity<Usuario>(usuarioService.adcionaUsuario(usuario), HttpStatus.CREATED);

    }

    @PostMapping("/auth/login")
    public ResponseEntity<Usuario> authenticaLogin (@RequestBody Usuario usuario) {
        return new ResponseEntity<Usuario>(usuarioService.authenticaService(usuario.getEmail(), usuario.getSenha()), HttpStatus.CREATED);
    }


}
