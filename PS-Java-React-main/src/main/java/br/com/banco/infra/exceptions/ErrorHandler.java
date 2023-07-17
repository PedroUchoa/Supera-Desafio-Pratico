package br.com.banco.infra.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handlerError404(){
        return ResponseEntity.notFound().build();
    }

}
