package br.com.ifba.modulologistica.veiculo.exception;


import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.ifba.modulologistica.infrastructure.exception.MessageExceptionHandler;

@ControllerAdvice(basePackages = "br.com.ifba.modulologistica.veiculo.controller")
public class VeiculoControllerAdvice {
    
    //veiculo null
    @ResponseBody
    @ExceptionHandler(VeiculoNullException.class)
    public ResponseEntity<MessageExceptionHandler> handleVeiculoNullException(VeiculoNullException ex) {
        MessageExceptionHandler message = new MessageExceptionHandler(new Date(), "Veiculo esta vazio.", HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
    //veiculo existe
    @ResponseBody
    @ExceptionHandler(VeiculoExisteException.class)
    public ResponseEntity<MessageExceptionHandler> handleVeiculoExisteException(VeiculoExisteException ex) {
        MessageExceptionHandler message = new MessageExceptionHandler(new Date(), "Veiculo já existe.", HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
    //veiculo não encontrado
    @ResponseBody
    @ExceptionHandler(VeiculoNotFoundException.class)
    public ResponseEntity<MessageExceptionHandler> handleVeiculoNotFoundException(VeiculoNotFoundException ex) {
        MessageExceptionHandler message = new MessageExceptionHandler(new Date(), "Veiculo não encontrado.", HttpStatus.NOT_FOUND.toString());
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }
}
