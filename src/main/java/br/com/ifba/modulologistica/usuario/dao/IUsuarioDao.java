package br.com.ifba.modulologistica.usuario.dao;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.context.annotation.RequestScope;

import br.com.ifba.modulologistica.usuario.model.Usuario;

@RequestScope
public interface  IUsuarioDao extends JpaRepository<Usuario, Long> {
    // find by email
    public Optional<Usuario> findByEmail(String email);
}

