package com.escolar.gestao.infrastructure.persistence.jpaRepository;

import com.escolar.gestao.infrastructure.persistence.entity.AlunoEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepositoryJpa extends JpaRepository<AlunoEntity, Integer> {

    Optional<AlunoEntity> findByMatricula(String matricula);

    List<AlunoEntity> findAllByMatriculaIn(Iterable<String> matriculas);

    boolean existsByEmail(String email);
}
