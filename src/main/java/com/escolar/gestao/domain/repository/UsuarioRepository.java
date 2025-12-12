package com.escolar.gestao.domain.repository;

import com.escolar.gestao.domain.Usuario;
import java.util.Optional;

public interface UsuarioRepository {
    Optional<Usuario> findByEmail(String email);
    Usuario save(Usuario usuario);
}
