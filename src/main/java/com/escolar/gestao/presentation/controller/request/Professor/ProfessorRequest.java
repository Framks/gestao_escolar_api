package com.escolar.gestao.presentation.controller.request.Professor;

import com.escolar.gestao.constraint.Cpf;
import com.escolar.gestao.constraint.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record ProfessorRequest(
        @NotBlank
        String nome,

        @Email
        String email,

        @NotBlank
        String senha,

        @NotBlank
        @Cpf
        String cpf,

        @NotNull
        LocalDateTime dataNascimento
) {}
