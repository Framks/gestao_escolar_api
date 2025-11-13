package com.escolar.gestao.controller.request;

import com.escolar.gestao.constraint.Email;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;

public class AlunoPutRequest {
    public String nome;
    @Email()
    public String email;
    public String senha;
    @JsonProperty("data_nascimento")
    public LocalDateTime dataNascimento;
}