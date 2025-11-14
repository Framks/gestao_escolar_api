package com.escolar.gestao.controller.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public record TurmaRequest(
        @NotBlank String codigo,
        @NotNull String disciplinaCodigo,
        @NotNull String professorMatricula,
        @NotBlank String semestre,
        @NotNull Integer capacidadeMaxima,
        List<String> alunosMatriculas
) {}
