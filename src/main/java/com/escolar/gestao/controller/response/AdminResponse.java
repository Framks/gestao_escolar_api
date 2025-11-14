package com.escolar.gestao.controller.response;

import com.escolar.gestao.domain.Admin;
import java.time.LocalDateTime;
import java.util.List;

public record AdminResponse(
        Integer id,
        String nome,
        String email,
        String cpf,
        LocalDateTime dataNascimento,
        String cargo,
        List<String> permissoes,
        Boolean ativo,
        LocalDateTime dataCriacao
) {

    public AdminResponse(Admin admin) {
        this(
                admin.id,
                admin.nome,
                admin.email,
                admin.cpf,
                admin.dataNascimento,
                admin.cargo,
                admin.permissoes,
                admin.ativo,
                admin.dataCriacao
        );
    }
}
