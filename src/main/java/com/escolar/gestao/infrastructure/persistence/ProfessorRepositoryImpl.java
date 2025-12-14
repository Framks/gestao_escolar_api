package com.escolar.gestao.infrastructure.persistence;

import com.escolar.gestao.application.mapper.ProfessorMapper;
import com.escolar.gestao.domain.Professor;
import com.escolar.gestao.domain.repository.ProfessorRepository;
import com.escolar.gestao.infrastructure.exception.ProfessorNotFoundException;
import com.escolar.gestao.infrastructure.persistence.entity.ProfessorEntity;
import com.escolar.gestao.infrastructure.persistence.jpaRepository.ProfessorRepositoryJpa;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class ProfessorRepositoryImpl implements ProfessorRepository {

    private final ProfessorRepositoryJpa jpaProfessor;

    public ProfessorRepositoryImpl(ProfessorRepositoryJpa jpaProfessor) {
        this.jpaProfessor = jpaProfessor;
    }

    @Override
    public Professor save(Professor professor) {
        ProfessorEntity professorEntity = ProfessorMapper.toEntity(professor);
        return ProfessorMapper.toDomain(jpaProfessor.save(professorEntity));
    }

    @Override
    public Professor findByMatricula(String matricula) {
        return ProfessorMapper.toDomain(
                jpaProfessor.findByMatricula(matricula)
                        .orElseThrow(
                                () -> new ProfessorNotFoundException("matricula não encontrada: "+matricula)
                        )
        );
    }

    @Override
    public Professor update(Professor professor, String matricula) {
        ProfessorEntity saved = jpaProfessor.findByMatricula(matricula).orElseThrow(() -> new ProfessorNotFoundException("Professor não encontrado para ser auterado"));
        saved.email = professor.email;
        saved.cpf = professor.cpf;
        saved.nome = professor.nome;
        saved.senha = professor.senha;
        saved = jpaProfessor.save(saved);
        return ProfessorMapper.toDomain(saved);
    }

    @Override
    public void delete(String matricula) {
        jpaProfessor.deleteByMatricula(matricula);
    }

    @Override
    public List<Professor> findAll(Integer page, Integer size, String sortBy) {

        return List.of();
    }
}
