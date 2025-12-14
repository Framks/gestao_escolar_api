package com.escolar.gestao.presentation.controller.request.auth;

import com.escolar.gestao.constraint.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
    @Email
    String email,

    @NotBlank
    String senha
){}
