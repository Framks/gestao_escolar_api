package com.escolar.gestao.domain;

import jakarta.persistence.Entity;

@Entity
public class Professor extends Usuario {
    public String Matricula;

    public Professor() {
        super();
    }

    public Professor(
            String nome,
            String email,
            String senha,
            String cpf,
            java.time.LocalDateTime dataNascimento
    ) {
        super(
                nome,
                email,
                senha,
                cpf,
                dataNascimento,
                com.escolar.gestao.enums.UserRole.PROFESSOR
        );
        this.Matricula = "PRO_" + java.util.UUID.randomUUID().toString().toUpperCase();
    }
}
