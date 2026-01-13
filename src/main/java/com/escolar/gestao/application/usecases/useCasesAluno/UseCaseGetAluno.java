package com.escolar.gestao.application.usecases.useCasesAluno;

import com.escolar.gestao.domain.Aluno;
import java.util.List;

public interface UseCaseGetAluno {
    Aluno getAluno(String Matricula);

    List<Aluno> getAlunos(Integer page, Integer size, String orderBy);
}
