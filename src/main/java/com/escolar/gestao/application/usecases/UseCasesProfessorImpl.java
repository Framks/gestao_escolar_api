package com.escolar.gestao.application.usecases;

import com.escolar.gestao.application.usecases.useCasesProfessor.UseCaseCreateProfessor;
import com.escolar.gestao.application.usecases.useCasesProfessor.UseCaseDeleteProfessor;
import com.escolar.gestao.application.usecases.useCasesProfessor.UseCaseGetProfessor;
import com.escolar.gestao.application.usecases.useCasesProfessor.UseCaseUpdateProfessor;
import com.escolar.gestao.domain.Professor;
import com.escolar.gestao.domain.repository.ProfessorRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UseCasesProfessorImpl implements UseCaseUpdateProfessor, UseCaseDeleteProfessor, UseCaseGetProfessor, UseCaseCreateProfessor {

    private final ProfessorRepository professorRepository;

    public  UseCasesProfessorImpl(
            ProfessorRepository professorRepository
    ) {
        this.professorRepository = professorRepository;
    }

    @Override
    public Professor create(Professor professor) {
        return null;
    }

    @Override
    public void delete(String matricula) {

    }

    @Override
    public List<Professor> getProfessores(Integer size, Integer page, String orderBy) {
        return List.of();
    }

    @Override
    public Professor getProfessorByMatricula(String matricula) {
        return null;
    }

    @Override
    public Professor update(Professor professor) {
        return null;
    }
}
