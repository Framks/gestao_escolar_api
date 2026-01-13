package com.escolar.gestao.domain.repository;

import com.escolar.gestao.domain.Disciplina;

public interface DisciplinaRepository {
    Disciplina save(Disciplina disciplina);
    Disciplina findByCodigo(String codigo);
}
