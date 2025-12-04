package com.escolar.gestao.infrastructure.exception;

public class AlunoNotFoundException extends RuntimeException {
    public AlunoNotFoundException(String message) {
        super(message);
    }
}
