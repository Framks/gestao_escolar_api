package com.escolar.gestao.domain.repository;

import com.escolar.gestao.domain.Aluno;
import java.util.List;

public interface AlunoRepository {
    Aluno save(Aluno aluno);
    boolean existsByEmail(String email);
    List<Aluno> findAll();
    Aluno findByEmail(String email);
    Aluno findByMatricula(String matricula);
}
