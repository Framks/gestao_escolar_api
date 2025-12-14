package com.escolar.gestao.application.mapper;

import com.escolar.gestao.domain.Professor;
import com.escolar.gestao.infrastructure.persistence.entity.ProfessorEntity;
import com.escolar.gestao.presentation.controller.request.Professor.ProfessorRequest;
import com.escolar.gestao.presentation.controller.response.Professor.ProfessorResponse;

public final class ProfessorMapper {

    public static Professor toDomain(ProfessorRequest professor) {
        return new Professor(
                professor.nome(),
                professor.email(),
                professor.senha(),
                professor.cpf(),
                professor.dataNascimento()
        );
    }

    public static Professor toDomain(ProfessorEntity professor){
        return new Professor(
                professor.nome,
                professor.email,
                professor.senha,
                professor.cpf,
                professor.dataNascimento,
                professor.matricula
        );
    }

    public static ProfessorEntity toEntity(Professor domain) {
        return new ProfessorEntity(
                domain.nome,
                domain.email,
                domain.senha,
                domain.cpf,
                domain.dataNascimento,
                domain.matricula
        );
    }

    public static ProfessorResponse toResponse(Professor domain) {
        return new ProfessorResponse(
                domain.nome,
                domain.email,
                domain.cpf,
                domain.dataNascimento,
                domain.matricula,
                domain.ativo,
                domain.dataCriacao
        );
    }
}
