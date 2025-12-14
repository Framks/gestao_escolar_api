package com.escolar.gestao.domain;

public class Professor extends Usuario {
    public String matricula;

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
        this.matricula = "PRO_" + java.util.UUID.randomUUID().toString().toUpperCase();
    }

    public Professor(
            String nome,
            String email,
            String senha,
            String cpf,
            java.time.LocalDateTime dataNascimento,
            String matricula
    ){
        super(
                nome,
                email,
                senha,
                cpf,
                dataNascimento,
                com.escolar.gestao.enums.UserRole.PROFESSOR
        );
        this.matricula = matricula;
    }
}
