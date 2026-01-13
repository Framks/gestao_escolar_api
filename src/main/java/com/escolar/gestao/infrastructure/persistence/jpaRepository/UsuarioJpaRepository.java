package com.escolar.gestao.infrastructure.persistence.jpaRepository;

import com.escolar.gestao.infrastructure.persistence.entity.UsuarioEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioJpaRepository extends JpaRepository<UsuarioEntity, Long> {
    Optional<UsuarioEntity> findByEmail(String email);
}
