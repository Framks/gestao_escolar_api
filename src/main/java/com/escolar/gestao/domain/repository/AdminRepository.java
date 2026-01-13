package com.escolar.gestao.domain.repository;

import com.escolar.gestao.domain.Admin;
import java.util.List;

public interface AdminRepository {
    Admin save(Admin admin);
    boolean existsByEmail(String email);
    List<Admin> findAll();
    Admin findByEmail(String email);
    Admin findById(Integer id);
    void deleteByCpf(String cpf);
    List<Admin> findAll(Integer page, Integer size, String sortBy);
    Admin update(Admin admin, String email);
}
