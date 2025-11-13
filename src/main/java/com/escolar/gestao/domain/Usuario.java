package com.escolar.gestao.domain;

import com.escolar.gestao.enums.UserRole;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="usuario_nome")
public abstract class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    public String nome;

    public String senha;

    public String cpf;

    @Column(name = "data_nascimento")
    public LocalDateTime dataNascimento;

    @Enumerated(EnumType.STRING)
    public UserRole role;

    public String email;

    public Boolean ativo = true;

    @Column(name = "data_criacao")
    public LocalDateTime dataCriacao = LocalDateTime.now();

    public Usuario() {}

    public Usuario(
            String nome,
            String email,
            String senha,
            String cpf,
            LocalDateTime dataNascimento,
            UserRole role
    ) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.role = role;
    }
}
