package com.escolar.gestao.application.usecases.useCasesTurma;

import com.escolar.gestao.domain.Turma;
import java.util.List;

public interface UseCaseGetTurma {
    Turma getTurma(String codigo);
    List<Turma> getTurmas(Integer page, Integer size, String sort);
}
