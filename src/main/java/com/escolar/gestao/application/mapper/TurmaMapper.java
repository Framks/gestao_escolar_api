package com.escolar.gestao.application.mapper;

import com.escolar.gestao.domain.Turma;
import com.escolar.gestao.infrastructure.persistence.entity.TurmaEntity;
import com.escolar.gestao.presentation.controller.response.Turma.TurmaResponse;

public class TurmaMapper {

    public static Turma toDomain(TurmaEntity turmaEntity) {
        return new Turma(
                turmaEntity.codigo,
                DisciplinaMapper.toDomain(turmaEntity.disciplinaEntity),
                ProfessorMapper.toDomain(turmaEntity.professor),
                turmaEntity.semestre,
                turmaEntity.capacidadeMaxima,
                turmaEntity.alunos.stream().map(AlunoMapper::toDomain).toList()
        );
    }

    public static TurmaResponse toResponse(Turma turma) {
        return new TurmaResponse(
                turma.codigo,
                turma.disciplina.codigo,
                turma.professor.matricula,
                turma.semestre,
                turma.capacidadeMaxima,
                turma.alunos.stream().map(aluno -> aluno.matricula).toList(),
                turma.dataCriacao
        );
    }
}
