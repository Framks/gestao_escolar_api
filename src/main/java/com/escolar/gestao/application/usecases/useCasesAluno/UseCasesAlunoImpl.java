package com.escolar.gestao.application.usecases.useCasesAluno;

import com.escolar.gestao.domain.Aluno;
import com.escolar.gestao.domain.repository.AlunoRepository;
import org.springframework.stereotype.Service;

@Service
public class UseCasesAlunoImpl implements UseCaseCreateAluno,  UseCaseUpdateAluno, UseCaseGetAluno{

    private final AlunoRepository repository;

    public UseCasesAlunoImpl(AlunoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Aluno createUser(Aluno usuario) {
        return repository.save(usuario);
    }

    @Override
    public  Aluno updateUser(Aluno usuario) {
        return null;
    }

    @Override
    public Aluno getAluno(String Matricula) {
        return repository.findByMatricula(Matricula);
    }
}
