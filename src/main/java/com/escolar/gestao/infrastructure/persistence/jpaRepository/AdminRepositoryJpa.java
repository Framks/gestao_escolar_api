package com.escolar.gestao.infrastructure.persistence.jpaRepository;

import com.escolar.gestao.infrastructure.persistence.entity.AdminEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepositoryJpa extends JpaRepository<AdminEntity, Integer> {
    Optional<AdminEntity> findByEmail(String email);
    void deleteByCpf(String cpf);
}

