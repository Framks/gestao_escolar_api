package com.escolar.gestao.application.usecases;

import com.escolar.gestao.application.usecases.useCasesDesciplina.UseCaseCreateDisciplina;
import com.escolar.gestao.application.usecases.useCasesDesciplina.UseCaseDeleteDisciplina;
import com.escolar.gestao.application.usecases.useCasesDesciplina.UseCaseGetDisciplina;
import com.escolar.gestao.application.usecases.useCasesDesciplina.UseCaseUpdateDisciplina;
import com.escolar.gestao.domain.repository.DisciplinaRepository;
import org.springframework.stereotype.Service;

@Service
public class UseCasesDisciplinaImpl implements UseCaseCreateDisciplina, UseCaseGetDisciplina, UseCaseUpdateDisciplina, UseCaseDeleteDisciplina {

    private final DisciplinaRepository repository;

    public UseCasesDisciplinaImpl(DisciplinaRepository repository) {
        this.repository = repository;
    }


}
