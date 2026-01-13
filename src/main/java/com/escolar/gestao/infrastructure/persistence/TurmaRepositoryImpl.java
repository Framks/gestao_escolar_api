package com.escolar.gestao.infrastructure.persistence;

import com.escolar.gestao.application.mapper.TurmaMapper;
import com.escolar.gestao.domain.Turma;
import com.escolar.gestao.domain.repository.TurmaRepository;
import com.escolar.gestao.infrastructure.exception.TurmaNotFounException;
import com.escolar.gestao.infrastructure.persistence.entity.TurmaEntity;
import com.escolar.gestao.infrastructure.persistence.jpaRepository.TurmaRepositoryJpa;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @Override
    public List<Turma> findAll(Integer page, Integer size, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        Page<TurmaEntity> turmas = turmaRepositoryJpa.findAll(pageable);

        return turmas.stream().map(TurmaMapper::toDomain).toList();
    }
}
