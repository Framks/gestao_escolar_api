package com.escolar.gestao.repository;

import com.escolar.gestao.domain.Professor;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

    public Optional<Professor> findByMatricula(String matricula);
}
