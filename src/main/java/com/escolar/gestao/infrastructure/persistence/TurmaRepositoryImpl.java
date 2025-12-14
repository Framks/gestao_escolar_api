package com.escolar.gestao.infrastructure.persistence;

import com.escolar.gestao.application.mapper.TurmaMapper;
import com.escolar.gestao.domain.Turma;
import com.escolar.gestao.domain.repository.TurmaRepository;
import com.escolar.gestao.infrastructure.exception.TurmaNotFounException;
import com.escolar.gestao.infrastructure.persistence.jpaRepository.TurmaRepositoryJpa;
import org.springframework.stereotype.Repository;

@Repository
public class TurmaRepositoryImpl implements TurmaRepository {

    private final TurmaRepositoryJpa turmaRepositoryJpa;

    public TurmaRepositoryImpl(
        TurmaRepositoryJpa turmaRepositoryJpa
    ) {
        this.turmaRepositoryJpa = turmaRepositoryJpa;
    }

    @Override
    public Turma findByCodigo(String codigo) {
        return TurmaMapper.toDomain(
                turmaRepositoryJpa.findByCodigo(codigo)
                        .orElseThrow(
                                () -> new TurmaNotFounException("A turma com codigo "+codigo+" não foi encontrada")
                        )
        );
    }

    @Override
    public Turma save(Turma turma) {
        return null;
    }

    @Override
    public void deleteByCodigo(String codigo) {

    }
}
