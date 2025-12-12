package com.escolar.gestao.application.mapper;

import com.escolar.gestao.domain.Admin;
import com.escolar.gestao.domain.Aluno;
import com.escolar.gestao.domain.Professor;
import com.escolar.gestao.domain.Usuario;
import com.escolar.gestao.infrastructure.persistence.entity.AdminEntity;
import com.escolar.gestao.infrastructure.persistence.entity.AlunoEntity;
import com.escolar.gestao.infrastructure.persistence.entity.ProfessorEntity;
import com.escolar.gestao.infrastructure.persistence.entity.UsuarioEntity;

public class UsuarioMapper {

    public static Usuario toDomain(UsuarioEntity entity){
        return switch(entity.role){
            case ADMIN -> map(entity, new Admin());
            case PROFESSOR -> map(entity, new Professor());
            case ALUNO -> map(entity, new Aluno());
        };
    }


    private static Usuario map(UsuarioEntity e, Usuario u){
        u.email = e.email;
        u.nome = e.nome;
        u.senha = e.senha;
        u.role = e.role;
        return u;
    }


    public static UsuarioEntity toEntity(Usuario usuario) {
        return switch(usuario.role){
            case ADMIN -> copy(usuario, new AdminEntity());
            case PROFESSOR -> copy(usuario, new ProfessorEntity());
            case ALUNO -> copy(usuario, new AlunoEntity());
        };
    }


    private static UsuarioEntity copy(Usuario u, UsuarioEntity e){
        e.email =u.email;
        e.nome = u.nome;
        e.senha = u.senha;
        e.role = u.role;
        return e;
    }
}
