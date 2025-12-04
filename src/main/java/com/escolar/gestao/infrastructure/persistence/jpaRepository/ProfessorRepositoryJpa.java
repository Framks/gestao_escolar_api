package com.escolar.gestao.infrastructure.persistence.jpaRepository;

import com.escolar.gestao.infrastructure.persistence.entity.ProfessorEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepositoryJpa extends JpaRepository<ProfessorEntity, Integer> {

    public Optional<ProfessorEntity> findByMatricula(String matricula);
}
