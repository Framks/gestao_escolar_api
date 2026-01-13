package com.escolar.gestao.application.usecases.useCasesTurma;

import com.escolar.gestao.domain.Turma;
import java.util.List;

public interface UseCaseCreateTurma {
    Turma createTurma(
        String codigo,
        String codigoDisciplina,
        String matriculaProfessor,
        String semestre,
        Integer capacidadeMaxima,
        List<String> matriculasAlunos
    );
}
