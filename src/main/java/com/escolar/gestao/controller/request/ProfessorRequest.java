package com.escolar.gestao.controller.request;

import com.escolar.gestao.constraint.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record ProfessorRequest(
        @NotBlank String nome,
        @Email String email,
        @NotBlank String senha,
        @NotBlank String cpf,
        @NotNull LocalDateTime dataNascimento
) {}
