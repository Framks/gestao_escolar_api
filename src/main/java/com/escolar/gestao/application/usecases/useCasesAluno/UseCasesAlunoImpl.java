package com.escolar.gestao.application.usecases.useCasesAluno;

import com.escolar.gestao.domain.Aluno;
import com.escolar.gestao.domain.repository.AlunoRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UseCasesAlunoImpl implements UseCaseCreateAluno,  UseCaseUpdateAluno, UseCaseGetAluno, UseCaseDeleteAluno{

    private final AlunoRepository repository;

    public UseCasesAlunoImpl(AlunoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Aluno createUser(Aluno usuario) {
        return repository.save(usuario);
    }

    @Override
    public  Aluno updateUser(Aluno request, String matricula) {
        Aluno aluno = repository.findByMatricula(matricula);
        aluno.nome = request.nome;
        aluno.matricula = request.matricula;
        aluno.cpf = request.cpf;
        aluno.email = request.email;
        repository.update(aluno, matricula);
        return null;
    }

    @Override
    public Aluno getAluno(String Matricula) {
        return repository.findByMatricula(Matricula);
    }

    @Override
    public void delete(String Matricula) {
        repository.deleteByMatricula(Matricula);
    }

    @Override
    public List<Aluno> getAlunos(Integer page, Integer size, String orderBy){
        return repository.findAll(page, size, orderBy);
    }
}
