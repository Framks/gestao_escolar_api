package com.escolar.gestao.controller.response;

import com.escolar.gestao.domain.Turma;
import java.time.LocalDateTime;
import java.util.List;

public record TurmaResponse(
        String codigo,
        String disciplinaId,
        String professorId,
        String semestre,
        Integer capacidadeMaxima,
        List<String> alunosMatriculas,
        LocalDateTime dataCriacao
) {
    public TurmaResponse(Turma t) {
        this(
                t.codigo,
                t.disciplina != null ? t.disciplina.codigo : null,
                t.professor != null ? t.professor.matricula : null,
                t.semestre,
                t.capacidadeMaxima,
                t.alunos != null ? t.alunos.stream().map(a -> a.matricula).toList() : null,
                t.dataCriacao
        );
    }
}
