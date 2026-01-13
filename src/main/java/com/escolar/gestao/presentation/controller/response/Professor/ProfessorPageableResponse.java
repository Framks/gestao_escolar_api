package com.escolar.gestao.presentation.controller.response.Professor;

import java.util.List;

public record ProfessorPageableResponse(
    List<ProfessorResponse> professores,
    Integer page,
    Integer size,
    String sortBy
){}
