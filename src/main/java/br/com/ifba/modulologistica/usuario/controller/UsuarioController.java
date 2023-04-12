package br.com.ifba.modulologistica.usuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import br.com.ifba.modulologistica.infrastructure.model.RespostaModelo;
import br.com.ifba.modulologistica.usuario.model.Usuario;
import br.com.ifba.modulologistica.usuario.service.UsuarioService;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;
    
    @GetMapping("")
    public String index() {
        return "Api MDL funcionando";
    }

    @GetMapping("/usuarios")
    public List<Usuario> readUsuarios() {
        return usuarioService.getAllUsuario();
    }

    @PostMapping("/usuario")
    public Usuario createUsuario(@Validated Usuario usuario) {
        return usuarioService.saveUsuario(usuario);
    }
    
    @PutMapping("/usuario/id/{id}")
    public Usuario updateUsuario(@PathVariable("id") long id, @RequestBody Usuario usuario) {
        return usuarioService.updateUsuario(id, usuario);
    }

    @DeleteMapping("/usuario/id/{id}")
    public ResponseEntity<RespostaModelo> deleteUsuario(@PathVariable("id") long id) {
        return usuarioService.deleteUsuario(id);
    }

    @GetMapping(value="/usuario/email/{email}")
    public Usuario getByEmailUsuario(@PathVariable("email") String email) {
        return usuarioService.getByEmailUsuario(email);
    }

    @GetMapping(value="/usuario/id/{id}")
    public Usuario getByIdUsuario(@PathVariable("id") long id) {
        return usuarioService.getByIdUsuario(id);
    }
    

}
