package com.escolar.gestao.domain;

import jakarta.persistence.Entity;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Admin extends  Usuario {
    public String cargo;
    public List<String> permissoes;

    public Admin() {
        super();
    }

    public Admin(
            String nome,
            String email,
            String senha,
            String cpf,
            LocalDateTime dataNascimento,
            String cargo,
            List<String> permissoes
    ) {
        super(
                nome,
                email,
                senha,
                cpf,
                dataNascimento,
                com.escolar.gestao.enums.UserRole.ADMIN
        );
        this.cargo = cargo;
        this.permissoes = permissoes;
    }
}
