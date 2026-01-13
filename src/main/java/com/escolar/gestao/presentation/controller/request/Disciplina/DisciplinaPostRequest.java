package com.escolar.gestao.presentation.controller.request.Disciplina;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public record DisciplinaPostRequest(
    @NotBlank
    String descricao,

    @JsonProperty("carga_horaria")
    Integer cargaHoraria,

    @NotBlank
    String nome
){ }