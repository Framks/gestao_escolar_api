package com.escolar.gestao.domain;

import com.escolar.gestao.enums.UserRole;
import java.time.LocalDateTime;
import java.util.UUID;

public class Aluno extends Usuario{

        public String matricula;

        public Aluno() { super();  }

        public Aluno(
                String nome,
                String email,
                String senha,
                String cpf,
                LocalDateTime dataNascimento
        ) {
                super(
                        nome,
                        email,
                        senha,
                        cpf,
                        dataNascimento,
                        UserRole.ALUNO
                );
                this.matricula = "ALU_" + UUID.randomUUID().toString().toUpperCase();
        }

        public Aluno(
                String nome,
                String email,
                String senha,
                String cpf,
                LocalDateTime dataNascimento,
                String matricula
        ){
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
