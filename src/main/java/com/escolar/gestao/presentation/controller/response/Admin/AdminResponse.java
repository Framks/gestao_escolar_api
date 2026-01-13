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
    public AdminResponse(Admin a) {
        this(
                a.nome,
                a.email,
                a.cpf,
                a.dataNascimento,
                a.cargo,
                a.permissoes,
                a.ativo,
                a.dataCriacao
        );
    }
}

