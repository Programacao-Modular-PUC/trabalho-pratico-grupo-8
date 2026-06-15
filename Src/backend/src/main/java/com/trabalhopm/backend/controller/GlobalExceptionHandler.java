package com.trabalhopm.backend.controller;

import com.trabalhopm.backend.exception.CapacidadeExcedidaException;
import com.trabalhopm.backend.exception.DataInvalidaException;
import com.trabalhopm.backend.exception.QuartoIndisponivelException;
import com.trabalhopm.backend.exception.RecursoNaoPermitidoException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleNotFound(EntityNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(QuartoIndisponivelException.class)
    public ResponseEntity<String> handleQuartoIndisponivel(QuartoIndisponivelException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(CapacidadeExcedidaException.class)
    public ResponseEntity<String> handleCapacidadeExcedida(CapacidadeExcedidaException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(DataInvalidaException.class)
    public ResponseEntity<String> handleDataInvalida(DataInvalidaException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(RecursoNaoPermitidoException.class)
    public ResponseEntity<String> handleRecursoNaoPermitido(RecursoNaoPermitidoException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
