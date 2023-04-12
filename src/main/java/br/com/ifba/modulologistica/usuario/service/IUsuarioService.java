package br.com.ifba.modulologistica.usuario.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.ifba.modulologistica.infrastructure.model.RespostaModelo;
import br.com.ifba.modulologistica.usuario.model.Usuario;


public interface IUsuarioService {
     // Salva o usuário.
    public abstract Usuario saveUsuario(Usuario usuario);
    // Deleta usuário.
    public abstract ResponseEntity<RespostaModelo> deleteUsuario(long id);
    // Atualiza o usuario.
    public abstract Usuario updateUsuario(long id, Usuario usuarioDetails);
    // Método que retorna todos os usuários da base de dados.
    public abstract List<Usuario> getAllUsuario();
    // método que retorna um usuário pelo id.
    public abstract Usuario getByIdUsuario(long id);
    // Método que retorna um usuário pelo email.
    public abstract Usuario getByEmailUsuario(String email);
    
}
