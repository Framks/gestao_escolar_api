package com.escolar.gestao.infrastructure.persistence.jpaRepository;

import com.escolar.gestao.infrastructure.persistence.entity.Disciplina;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaRepositoryJpa extends JpaRepository<Disciplina, Long> {

    public Optional<Disciplina> findByCodigo(String codigo);
}
