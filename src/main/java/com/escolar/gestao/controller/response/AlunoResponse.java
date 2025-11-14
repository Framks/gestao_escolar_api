package com.escolar.gestao.controller.response;

import com.escolar.gestao.domain.Aluno;
import java.time.LocalDateTime;

public record AlunoResponse(
        Integer id,
        String nome,
        String email,
        String cpf,
        LocalDateTime dataNascimento,
        String matricula,
        Boolean ativo,
        LocalDateTime dataCriacao
) {
    public AlunoResponse(Aluno a) {
        this(
                a.id,
                a.nome,
                a.email,
                a.cpf,
                a.dataNascimento,
                a.matricula,
                a.ativo,
                a.dataCriacao
        );
    }
}