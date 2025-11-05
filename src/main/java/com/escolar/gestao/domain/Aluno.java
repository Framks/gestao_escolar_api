package com.escolar.gestao.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.UUID;

@Entity

record Aluno(
        @Id
        Integer id,
        String nome,
        String matricula,
        String email
) {
}
