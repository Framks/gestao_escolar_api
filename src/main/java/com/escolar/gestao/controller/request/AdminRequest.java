package com.escolar.gestao.controller.request;

import com.escolar.gestao.constraint.Cpf;
import com.escolar.gestao.constraint.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record AdminRequest(
        @NotBlank
        String nome,

        @Email
        String email,

        @NotBlank
        String senha,

        @Cpf
        String cpf,

        @NotNull
        LocalDateTime dataNascimento,

        @NotBlank
        String cargo,

        @NotNull
        List<String> permissoes
) {}

