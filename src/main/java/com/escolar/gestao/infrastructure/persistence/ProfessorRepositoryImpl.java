package com.escolar.gestao.infrastructure.persistence;

import com.escolar.gestao.domain.Professor;
import com.escolar.gestao.domain.repository.ProfessorRepository;
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
        return null;
    }

    @Override
    public Professor findById(String matricula) {
        return null;
    }

    @Override
    public Professor update(Professor professor) {
        return null;
    }

    @Override
    public void delete(String matricula) {

    }

    @Override
    public List<Professor> findAll(Integer page, Integer size, String sortBy) {
        return List.of();
    }
}
