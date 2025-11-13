package com.escolar.gestao.repository;

import com.escolar.gestao.domain.Aluno;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

    public Optional<Aluno> findByMatricula(String matricula);
}
