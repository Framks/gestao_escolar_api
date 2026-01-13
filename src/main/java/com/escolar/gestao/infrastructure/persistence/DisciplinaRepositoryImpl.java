package com.escolar.gestao.infrastructure.persistence;

import com.escolar.gestao.domain.Disciplina;
import com.escolar.gestao.domain.repository.DisciplinaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DisciplinaRepositoryImpl implements DisciplinaRepository {
    @Override
    public Disciplina save(Disciplina disciplina) {
        return null;
    }

    @Override
    public Disciplina findByCodigo(String codigo) {
        return null;
    }
}