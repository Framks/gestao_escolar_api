package com.escolar.gestao.application.usecases.useCasesTurma;

import com.escolar.gestao.domain.Turma;

public interface UseCaseUpdateTurma {
    void updateTurma(Turma turma);
    void addAluno(String matricula, String codigoTurma);
    void removeAluno(String matricula, String codigoTurma);

}
