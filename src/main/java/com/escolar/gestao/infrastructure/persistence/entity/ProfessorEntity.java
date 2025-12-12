package com.escolar.gestao.infrastructure.persistence.entity;


import jakarta.persistence.Entity;

@Entity
public class ProfessorEntity extends UsuarioEntity {
    public String matricula;

    public ProfessorEntity() {
        super();
    }

    public ProfessorEntity(
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
        this.matricula = "PRO_" + java.util.UUID.randomUUID().toString().toUpperCase();
    }
}

