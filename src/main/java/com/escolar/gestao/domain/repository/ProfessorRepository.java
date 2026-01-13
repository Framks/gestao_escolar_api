package com.escolar.gestao.domain.repository;

import com.escolar.gestao.domain.Professor;
import java.util.List;

public interface ProfessorRepository {
    Professor save(Professor professor);
    Professor findByMatricula(String matricula);
    Professor update(Professor professor, String matricula);
    void delete(String matricula);
    List<Professor> findAll(Integer page, Integer size, String sortBy);
}
