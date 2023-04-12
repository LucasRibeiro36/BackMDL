package br.com.ifba.modulologistica.usuario.exception;

import org.springframework.http.HttpStatus;
import java.util.Date;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import br.com.ifba.modulologistica.infrastructure.exception.MessageExceptionHandler;

@ControllerAdvice(basePackages = "br.com.ifba.modulologistica.usuario.controller")
public class UsuarioControllerAdvice {
    
    @ResponseBody
    @ExceptionHandler(UsuarioNotFoundException.class)
    public ResponseEntity<MessageExceptionHandler> handleUsuarioNotFoundException(UsuarioNotFoundException ex) {
        MessageExceptionHandler message = new MessageExceptionHandler(new Date(), "Usuario não encontrado.", HttpStatus.NOT_FOUND.toString());
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @ResponseBody
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<MessageExceptionHandler> handleRuntimeException(RuntimeException ex) {
        MessageExceptionHandler message = new MessageExceptionHandler(new Date(), ex.getMessage(), HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    // usuario null
    @ResponseBody
    @ExceptionHandler(UsuarioNullException.class)
    public ResponseEntity<MessageExceptionHandler> handleUsuarioNullException(UsuarioNullException ex) {
        MessageExceptionHandler message = new MessageExceptionHandler(new Date(), "Usuario esta vazio.", HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
    //usuario existe
    @ResponseBody
    @ExceptionHandler(UsuarioExisteException.class)
    public ResponseEntity<MessageExceptionHandler> handleUsuarioExisteException(UsuarioExisteException ex) {
        MessageExceptionHandler message = new MessageExceptionHandler(new Date(), "Usuario já existe.", HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
}
