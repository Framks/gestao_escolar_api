package com.escolar.gestao.presentation.handler;

import com.escolar.gestao.infrastructure.exception.AdminNotFoundException;
import com.escolar.gestao.infrastructure.exception.AlunoNotFoundException;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<?> alunoHandleException(AlunoNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of(
                        "error", "Aluno não encontrado", "message", exception.getMessage()
                ));
    }

    @ExceptionHandler
    public ResponseEntity<?> adminHandleException(AdminNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of(
                        "error", "administrador não encontrado", "message", exception.getMessage()
                ));
    }

    // implementar uma melhoria nos exceptions de maneira que seja preciso criar apenas um handle ( criar um "sistema" de exception)
}
