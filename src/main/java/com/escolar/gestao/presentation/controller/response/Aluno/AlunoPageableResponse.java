package com.escolar.gestao.presentation.controller.response.Aluno;

import java.util.List;

public record AlunoPageableResponse(
    List<AlunoResponse> alunos,
    Integer page,
    Integer size,
    String sortBy
){

}