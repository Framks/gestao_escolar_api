package com.escolar.gestao.controller.request;

import com.escolar.gestao.constraint.Cpf;
import com.escolar.gestao.constraint.Email;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;

public record AlunoRequest (
    String nome,

    @Email()
    String email,

    String senha,

    @Cpf()
    String cpf,

    @JsonProperty("data_nascimento")
    LocalDateTime dataNascimento
){ }