package com.escolar.gestao.application.mapper;

import com.escolar.gestao.domain.Turma;
import com.escolar.gestao.infrastructure.persistence.entity.TurmaEntity;

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
}
