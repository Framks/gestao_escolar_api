package com.escolar.gestao.application.usecases;

import com.escolar.gestao.application.usecases.useCasesAdmin.UseCaseCreateAdmin;
import com.escolar.gestao.application.usecases.useCasesAdmin.UseCaseDeleteAdmin;
import com.escolar.gestao.application.usecases.useCasesAdmin.UseCaseGetAdmin;
import com.escolar.gestao.application.usecases.useCasesAdmin.UseCaseUpdateAdmin;
import com.escolar.gestao.domain.Admin;
import com.escolar.gestao.domain.repository.AdminRepository;
import java.util.List;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UseCasesAdminImpl implements UseCaseCreateAdmin, UseCaseGetAdmin, UseCaseUpdateAdmin, UseCaseDeleteAdmin {

    private final AdminRepository repository;
    private final PasswordEncoder encoder;

    public UseCasesAdminImpl(AdminRepository repository,  PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @Override
    public Admin createUser(Admin admin) {
        admin.senha =  encoder.encode(admin.senha);
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

