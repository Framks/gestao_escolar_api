package com.escolar.gestao.application.usecases;

import com.escolar.gestao.application.usecases.useCasesAluno.UseCaseCreateAluno;
import com.escolar.gestao.application.usecases.useCasesAluno.UseCaseDeleteAluno;
import com.escolar.gestao.application.usecases.useCasesAluno.UseCaseGetAluno;
import com.escolar.gestao.application.usecases.useCasesAluno.UseCaseUpdateAluno;
import com.escolar.gestao.domain.Aluno;
import com.escolar.gestao.domain.repository.AlunoRepository;
import java.util.List;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UseCasesAlunoImpl implements UseCaseCreateAluno, UseCaseUpdateAluno, UseCaseGetAluno, UseCaseDeleteAluno {

    private final AlunoRepository repository;
    private final PasswordEncoder encoder;

    public UseCasesAlunoImpl(AlunoRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.encoder = passwordEncoder;
    }

    @Override
    public Aluno createUser(Aluno aluno) {
        aluno.senha = encoder.encode(aluno.senha);
        return repository.save(aluno);
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
