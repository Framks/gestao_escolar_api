package com.escolar.gestao.infrastructure.exception;

public class TurmaNotFounException extends RuntimeException{
    public TurmaNotFounException(String message) {
        super(message);
    }
}
