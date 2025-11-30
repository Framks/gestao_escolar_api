package com.escolar.gestao.domain;

import com.escolar.gestao.enums.UserRole;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
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
}
