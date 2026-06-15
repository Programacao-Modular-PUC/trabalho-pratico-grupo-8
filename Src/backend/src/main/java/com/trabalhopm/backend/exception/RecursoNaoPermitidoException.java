package com.trabalhopm.backend.exception;

public class RecursoNaoPermitidoException extends RuntimeException {
    public RecursoNaoPermitidoException(String mensagem) {
        super(mensagem);
    }
}
