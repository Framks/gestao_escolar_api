package com.escolar.gestao.infrastructure.persistence;

import com.escolar.gestao.application.mapper.AdminMapper;
import com.escolar.gestao.domain.Admin;
import com.escolar.gestao.domain.repository.AdminRepository;
import com.escolar.gestao.infrastructure.exception.AdminNotFoundException;
import com.escolar.gestao.infrastructure.persistence.entity.AdminEntity;
import com.escolar.gestao.infrastructure.persistence.jpaRepository.AdminRepositoryJpa;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

@Repository
public class AdminRepositoryImpl implements AdminRepository {

    private final AdminRepositoryJpa jpa;

    public AdminRepositoryImpl(AdminRepositoryJpa jpa) {
        this.jpa = jpa;
    }

    @Override
    public Admin save(Admin admin) {
        AdminEntity entity = AdminMapper.toEntity(admin);
        AdminEntity saved = jpa.save(entity);
        return AdminMapper.toDomain(saved);
    }

    @Override
    public boolean existsByEmail(String email) {
        return jpa.findByEmail(email).isPresent();
    }

    @Override
    public List<Admin> findAll() {
        return jpa.findAll().stream().map(AdminMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public Admin findByEmail(String email) {
        AdminEntity e = jpa.findByEmail(email).orElseThrow(() -> new AdminNotFoundException("Admin não encontrado"));
        return AdminMapper.toDomain(e);
    }

    @Override
    public Admin findById(Integer id) {
        AdminEntity e = jpa.findById(id).orElseThrow(() -> new AdminNotFoundException("Admin não encontrado"));
        return AdminMapper.toDomain(e);
    }

    @Override
    public void deleteByCpf(String cpf) {
        jpa.deleteByCpf(cpf);
    }

    @Override
    public List<Admin> findAll(Integer page, Integer size, String sortBy) {
        PageRequest pr = PageRequest.of(page, size, Sort.by(sortBy));
        return jpa.findAll(pr).stream().map(AdminMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public Admin update(Admin admin, String email) {
        AdminEntity existing = jpa.findByEmail(email).orElseThrow(() -> new AdminNotFoundException("Admin não encontrado"));
        existing.nome = admin.nome;
        existing.email = admin.email;
        existing.senha = admin.senha;
        existing.cpf = admin.cpf;
        existing.dataNascimento = admin.dataNascimento;
        existing.cargo = admin.cargo;
        existing.permissoes = admin.permissoes;
        AdminEntity saved = jpa.save(existing);
        return AdminMapper.toDomain(saved);
    }
}

