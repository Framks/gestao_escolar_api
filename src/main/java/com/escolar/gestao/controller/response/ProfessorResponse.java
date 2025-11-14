package com.escolar.gestao.controller.response;

import com.escolar.gestao.domain.Professor;
import java.time.LocalDateTime;

public record ProfessorResponse(
        Integer id,
        String nome,
        String email,
        String cpf,
        LocalDateTime dataNascimento,
        String matricula,
        Boolean ativo,
        LocalDateTime dataCriacao
) {
    public ProfessorResponse(Professor p) {
        this(
                p.id,
                p.nome,
                p.email,
                p.cpf,
                p.dataNascimento,
                p.matricula,
                p.ativo,
                p.dataCriacao
        );
    }
}
