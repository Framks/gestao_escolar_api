package com.escolar.gestao.infrastructure.persistence;

import com.escolar.gestao.application.mapper.AlunoMapper;
import com.escolar.gestao.domain.Aluno;
import com.escolar.gestao.domain.repository.AlunoRepository;
import com.escolar.gestao.infrastructure.exception.AlunoNotFoundException;
import com.escolar.gestao.infrastructure.persistence.entity.AlunoEntity;
import com.escolar.gestao.infrastructure.persistence.jpaRepository.AlunoRepositoryJpa;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @Override
    public List<Aluno> findAll( Integer page, Integer size, String sortBy) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        Page<AlunoEntity> result = jpa.findAll(pageable);

        return result.stream().map(AlunoMapper::toDomain).toList();
    }

    @Override
    public Aluno update(Aluno request, String matricula) {
        AlunoEntity alunoEntity = jpa.findByMatricula(matricula).orElseThrow(() -> new AlunoNotFoundException("Aluno não foi encontrado"));
        alunoEntity.email = request.email;
        alunoEntity.cpf = request.cpf;
        alunoEntity.senha = request.senha;
        alunoEntity.nome = request.nome;
        jpa.save(alunoEntity);
        return request;
    }
}

