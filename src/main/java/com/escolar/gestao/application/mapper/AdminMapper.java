package com.escolar.gestao.application.mapper;

import com.escolar.gestao.domain.Admin;
import com.escolar.gestao.infrastructure.persistence.entity.AdminEntity;
import com.escolar.gestao.presentation.controller.request.Admin.AdminRequest;
import com.escolar.gestao.presentation.controller.response.Admin.AdminResponse;

public class AdminMapper {

    public static Admin toDomain(AdminRequest request) {
        if (request == null) return null;
        return new Admin(
                request.nome(),
                request.email(),
                request.senha(),
                request.cpf(),
                request.dataNascimento(),
                request.cargo(),
                request.permissoes()
        );
    }

    public static AdminEntity toEntity(Admin admin) {
        if (admin == null) return null;
        return new AdminEntity(
                admin.nome,
                admin.email,
                admin.senha,
                admin.cpf,
                admin.dataNascimento,
                admin.cargo,
                admin.permissoes
        );
    }

    public static Admin toDomain(AdminEntity entity) {
        if (entity == null) return null;
        Admin a = new Admin(
                entity.nome,
                entity.email,
                entity.senha,
                entity.cpf,
                entity.dataNascimento,
                entity.cargo,
                entity.permissoes
        );
        a.ativo = entity.ativo;
        a.dataCriacao = entity.dataCriacao;
        return a;
    }

    public static AdminResponse toResponse(Admin admin) {
        if (admin == null) return null;
        return new AdminResponse(admin);
    }
}

