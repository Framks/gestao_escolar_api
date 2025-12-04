package com.escolar.gestao.application.mapper;

import com.escolar.gestao.infrastructure.persistence.entity.AlunoEntity;
import com.escolar.gestao.presentation.controller.request.Aluno.AlunoRequest;
import com.escolar.gestao.domain.Aluno;
import com.escolar.gestao.presentation.controller.response.Aluno.AlunoResponse;

public class AlunoMapper {
    public static Aluno toDomain(AlunoRequest request) {
        return new Aluno(
                request.nome(),
                request.email(),
                request.senha(),
                request.cpf(),
                request.dataNascimento()
        );
    }

    public static AlunoEntity toEntity(Aluno aluno) {
        return new AlunoEntity(
                aluno.nome,
                aluno.email,
                aluno.senha,
                aluno.cpf,
                aluno.dataNascimento,
                aluno.matricula
        );
    }

    public static Aluno toDomain(AlunoEntity alunoEntity){
        return new Aluno(
                alunoEntity.nome,
                alunoEntity.email,
                alunoEntity.senha,
                alunoEntity.cpf,
                alunoEntity.dataNascimento,
                alunoEntity.matricula
        );
    }

    public static AlunoResponse toResponse(Aluno aluno) {
        return new AlunoResponse(aluno);
    }
}
