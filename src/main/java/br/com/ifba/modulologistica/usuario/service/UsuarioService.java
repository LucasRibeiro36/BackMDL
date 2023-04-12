package br.com.ifba.modulologistica.usuario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.ifba.modulologistica.infrastructure.model.RespostaModelo;
import br.com.ifba.modulologistica.usuario.dao.IUsuarioDao;
import br.com.ifba.modulologistica.usuario.model.Usuario;
import br.com.ifba.modulologistica.usuario.exception.UsuarioExisteException;
import br.com.ifba.modulologistica.usuario.exception.UsuarioNotFoundException;
import br.com.ifba.modulologistica.usuario.exception.UsuarioNullException;



@Service
public class UsuarioService implements IUsuarioService {
    
    @Autowired
    IUsuarioDao usuarioDao;

    @Autowired
    private RespostaModelo rm;

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        Optional<Usuario> usuarioExistente = usuarioDao.findByEmail(usuario.getEmail());
        if (usuarioExistente.isPresent()) {
            throw new UsuarioExisteException();
        }
        
        if (usuario.getEmail() == null || usuario.getNome() == null || usuario.getSenha() == null) {
            throw new UsuarioNullException();
        }
        
        return usuarioDao.save(usuario);        
    }

    


    @Override
    public Usuario updateUsuario(long id, Usuario usuarioDetails) {
        Optional<Usuario> usuario = usuarioDao.findById(id);
        if (usuario.isPresent()) {
            usuarioDetails.setId(id);
            return usuarioDao.save(usuarioDetails);
        }
        return usuario.orElseThrow(() -> new UsuarioNotFoundException());
    }

    

    @Override
    public List<Usuario> getAllUsuario() {
        return usuarioDao.findAll();
    }

    @Override
    public Usuario getByIdUsuario(long id) {
        Optional<Usuario> usuario = usuarioDao.findById(id);
        return usuario.orElseThrow(() -> new UsuarioNotFoundException());
    }

    @Override
    public Usuario getByEmailUsuario(String email) {
        Optional<Usuario> usuario = usuarioDao.findByEmail(email);
        return usuario.orElseThrow(() -> new UsuarioNotFoundException());
    }

    @Override
    public ResponseEntity<RespostaModelo>  deleteUsuario(long id) {
        Optional<Usuario> usuario = usuarioDao.findById(id);
        if (usuario.isPresent()) {
            usuarioDao.deleteById(id);
            rm.setMensagem("Usuário deletado com sucesso!");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.OK);
        }
        rm.setMensagem("Usuário não encontrado!");
        return new ResponseEntity<RespostaModelo>(rm, HttpStatus.NOT_FOUND);
    }
    
}
