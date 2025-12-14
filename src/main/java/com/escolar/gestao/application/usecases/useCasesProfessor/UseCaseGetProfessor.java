package com.escolar.gestao.application.usecases.useCasesProfessor;

import com.escolar.gestao.domain.Professor;
import java.util.List;

public interface UseCaseGetProfessor {
    List<Professor> getProfessores(Integer size, Integer page, String orderBy);
    Professor getProfessorByMatricula(String matricula);
}
