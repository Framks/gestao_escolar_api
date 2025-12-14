package com.escolar.gestao.infrastructure.persistence.jpaRepository;

import com.escolar.gestao.infrastructure.persistence.entity.TurmaEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepositoryJpa extends JpaRepository<TurmaEntity, Long> {
    Optional<TurmaEntity> findByCodigo(String codigo);
}
