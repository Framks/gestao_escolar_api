package com.escolar.gestao.domain.repository;

import com.escolar.gestao.domain.Turma;
import java.util.List;

public interface TurmaRepository {
    Turma findByCodigo(String codigo);
    Turma save(Turma turma);
    void deleteByCodigo(String codigo);
    List<Turma> findAll(Integer page, Integer size, String sort);
}
