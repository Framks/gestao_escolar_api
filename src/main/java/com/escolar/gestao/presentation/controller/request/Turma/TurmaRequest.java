package com.escolar.gestao.presentation.controller.request.Turma;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public record TurmaRequest(
        @NotBlank
        String codigo,

        @JsonProperty("codigo_disciplina")
        @NotNull
        String disciplinaCodigo,

        @JsonProperty("matricula_professor")
        @NotNull
        String professorMatricula,

        @NotBlank
        String semestre,

        @JsonProperty("capacidade_maxima")
        @NotNull
        Integer capacidadeMaxima,

        @JsonProperty("matriculas_alunos")
        List<String> alunosMatriculas
) {}
