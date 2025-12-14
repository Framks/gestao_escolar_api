package com.escolar.gestao.presentation.controller.response.Professor;

import com.escolar.gestao.domain.Professor;
import java.time.LocalDateTime;

public record ProfessorResponse(
        String nome,
        String email,
        String cpf,
        LocalDateTime dataNascimento,
        String matricula,
        Boolean ativo,
        LocalDateTime dataCriacao
) {
}
