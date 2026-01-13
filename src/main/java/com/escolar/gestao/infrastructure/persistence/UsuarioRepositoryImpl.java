package com.escolar.gestao.infrastructure.persistence;

import com.escolar.gestao.application.mapper.UsuarioMapper;
import com.escolar.gestao.domain.Usuario;
import com.escolar.gestao.domain.repository.UsuarioRepository;
import com.escolar.gestao.infrastructure.persistence.jpaRepository.UsuarioJpaRepository;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {


    private final UsuarioJpaRepository repo;


    public UsuarioRepositoryImpl(UsuarioJpaRepository repo){
        this.repo = repo;
    }


    @Override
    public Optional<Usuario> findByEmail(String email) {
        return repo.findByEmail(email).map(UsuarioMapper::toDomain);
    }


    @Override
    public Usuario save(Usuario usuario) {
        return UsuarioMapper.toDomain(repo.save(UsuarioMapper.toEntity(usuario)));
    }
}
