package com.escolar.gestao.domain.repository;

import com.escolar.gestao.domain.Turma;

public interface TurmaRepository {
    Turma findByCodigo(String codigo);
    Turma save(Turma turma);
    void deleteByCodigo(String codigo);
}
