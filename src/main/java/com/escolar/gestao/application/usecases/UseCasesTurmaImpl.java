package com.escolar.gestao.application.usecases;

import com.escolar.gestao.application.usecases.useCasesTurma.UseCaseCreateTurma;
import com.escolar.gestao.application.usecases.useCasesTurma.UseCaseDeleteTurma;
import com.escolar.gestao.application.usecases.useCasesTurma.UseCaseGetTurma;
import com.escolar.gestao.application.usecases.useCasesTurma.UseCaseUpdateTurma;
import com.escolar.gestao.domain.Aluno;
import com.escolar.gestao.domain.Disciplina;
import com.escolar.gestao.domain.Professor;
import com.escolar.gestao.domain.Turma;
import com.escolar.gestao.domain.repository.AlunoRepository;
import com.escolar.gestao.domain.repository.DisciplinaRepository;
import com.escolar.gestao.domain.repository.ProfessorRepository;
import com.escolar.gestao.domain.repository.TurmaRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UseCasesTurmaImpl implements UseCaseGetTurma, UseCaseCreateTurma, UseCaseDeleteTurma, UseCaseUpdateTurma {

    private final TurmaRepository turmaRepository;
    private final AlunoRepository alunoRepository;
    private final DisciplinaRepository disciplinaRepository;
    private final ProfessorRepository professorRepository;

    public  UseCasesTurmaImpl(
            TurmaRepository turmaRepository,
            AlunoRepository alunoRepository,
            DisciplinaRepository disciplinaRepository,
            ProfessorRepository professorRepository
    ) {
        this.alunoRepository =  alunoRepository;
        this.turmaRepository = turmaRepository;
        this.disciplinaRepository = disciplinaRepository;
        this.professorRepository = professorRepository;
    }

    @Override
    public Turma createTurma(
        String codigo,
        String codigoDisciplina,
        String matriculaProfessor,
        String semestre,
        Integer capacidadeMaxima,
        List<String> matriculasAlunos
    ) {
        List<Aluno> alunos = matriculasAlunos
                .stream()
                .map(alunoRepository::findByMatricula)
                .toList();
        Disciplina disciplina = disciplinaRepository.findByCodigo(codigoDisciplina);
        Professor professor = professorRepository.findByMatricula(matriculaProfessor);
        Turma turma = new Turma(
            codigo,
            disciplina,
            professor,
            semestre,
            capacidadeMaxima,
            alunos
        );
        return turmaRepository.save(turma);
    }

    @Override
    public void delete(String codigo) {
        turmaRepository.deleteByCodigo(codigo);
    }

    @Override
    public Turma getTurma(String codigo) {
        return turmaRepository.findByCodigo(codigo);
    }

    @Override
    public List<Turma> getTurmas(
        Integer page,
        Integer size,
        String sort
    ) {
        return turmaRepository.findAll(page, size, sort);
    }

    @Override
    public void updateTurma(Turma turma) {

    }

    @Override
    public void addAluno(
        String matricula,
        String codigoTurma
    ) {

    }

    @Override
    public void removeAluno(
        String matricula,
        String codigoTurma
    ) {

    }
}
