package com.escolar.gestao.infrastructure.persistence;

import com.escolar.gestao.application.mapper.AlunoMapper;
import com.escolar.gestao.domain.Aluno;
import com.escolar.gestao.domain.repository.AlunoRepository;
import com.escolar.gestao.infrastructure.exception.AlunoNotFoundException;
import com.escolar.gestao.infrastructure.persistence.entity.AlunoEntity;
import com.escolar.gestao.infrastructure.persistence.jpaRepository.AlunoRepositoryJpa;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class AlunoRepositoryImpl implements AlunoRepository {

    private final AlunoRepositoryJpa jpa;

    public AlunoRepositoryImpl(AlunoRepositoryJpa jpa) {
        this.jpa = jpa;
    }

    @Override
    public Aluno save(Aluno user) {
        AlunoEntity alunoEntity = AlunoMapper.toEntity(user);
        jpa.save(alunoEntity);
        return user;
    }

    @Override
    public boolean existsByEmail(String email) {
        return jpa.existsByEmail(email);
    }

    @Override
    public List<Aluno> findAll() {
        return List.of(new Aluno());
    }

    @Override
    public Aluno findByEmail(String email) {
        return null;
    }

    @Override
    public Aluno findByMatricula(String matricula) {
        return AlunoMapper.toDomain(
                jpa.findByMatricula(matricula)
                        .orElseThrow(
                                () -> new AlunoNotFoundException("matricula não encontrada %s".formatted(matricula))
                        )
        );
    }

    @Override
    public void deleteByMatricula(String matricula) {
        jpa.deleteByMatricula(matricula);
    }
}

