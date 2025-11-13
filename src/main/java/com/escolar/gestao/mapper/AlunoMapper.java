package com.escolar.gestao.mapper;

import com.escolar.gestao.controller.request.AlunoRequest;
import com.escolar.gestao.domain.Aluno;

public class AlunoMapper {
    public static Aluno toEntity(AlunoRequest request) {
        return new Aluno(
                request.nome,
                request.email,
                request.senha,
                request.cpf,
                request.dataNascimento
        );
    }
}
