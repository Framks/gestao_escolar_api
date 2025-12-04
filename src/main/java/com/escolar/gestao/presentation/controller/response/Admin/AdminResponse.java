package com.escolar.gestao.presentation.controller.response.Admin;

import com.escolar.gestao.domain.Admin;
import java.time.LocalDateTime;
import java.util.List;

public record AdminResponse(
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
