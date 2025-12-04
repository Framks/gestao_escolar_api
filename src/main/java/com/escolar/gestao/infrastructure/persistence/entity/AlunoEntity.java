package com.escolar.gestao.infrastructure.persistence.entity;

import com.escolar.gestao.enums.UserRole;
import jakarta.persistence.Entity;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class AlunoEntity extends Usuario {

    public String matricula;

    public AlunoEntity() { super(); }

    public AlunoEntity(
            String nome,
            String email,
            String senha,
            String cpf,
            LocalDateTime dataNascimento,
            String matricula
    ) {
        super(
                nome,
                email,
                senha,
                cpf,
                dataNascimento,
                UserRole.ALUNO
        );
        this.matricula = matricula;
    }
}
