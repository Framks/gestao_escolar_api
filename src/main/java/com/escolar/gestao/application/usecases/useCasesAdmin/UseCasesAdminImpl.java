package com.escolar.gestao.application.usecases.useCasesAdmin;

import com.escolar.gestao.domain.Admin;
import com.escolar.gestao.domain.repository.AdminRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UseCasesAdminImpl implements UseCaseCreateAdmin, UseCaseGetAdmin, UseCaseUpdateAdmin, UseCaseDeleteAdmin {

    private final AdminRepository repository;

    public UseCasesAdminImpl(AdminRepository repository) {
        this.repository = repository;
    }

    @Override
    public Admin createUser(Admin admin) {
        return repository.save(admin);
    }

    @Override
    public Admin updateUser(Admin request, String email) {
        Admin existing = repository.findByEmail(email);
        existing.nome = request.nome;
        existing.cpf = request.cpf;
        existing.email = request.email;
        existing.senha = request.senha;
        existing.cargo = request.cargo;
        existing.permissoes = request.permissoes;
        repository.update(existing, email);
        return existing;
    }

    @Override
    public Admin getAdmin(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public void delete(String cpf) {
        repository.deleteByCpf(cpf);
    }

    @Override
    public List<Admin> getAdmins(Integer page, Integer size, String orderBy) {
        return repository.findAll(page, size, orderBy);
    }
}

