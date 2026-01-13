package com.escolar.gestao.application.usecases.useCasesAluno;

import com.escolar.gestao.domain.Aluno;

public interface UseCaseUpdateAluno {
    Aluno updateUser(Aluno usuario, String matricula);
}
