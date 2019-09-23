package psoft.ufcg.lab2.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import psoft.ufcg.lab2.Entities.Usuario;

import java.io.Serializable;


@Repository
public interface UsuarioRepository<T, T1 extends Serializable> extends JpaRepository<Usuario, String>{
}
