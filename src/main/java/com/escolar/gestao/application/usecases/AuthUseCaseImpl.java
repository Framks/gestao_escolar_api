package com.escolar.gestao.application.usecases;

import com.escolar.gestao.domain.Usuario;
import com.escolar.gestao.domain.repository.UsuarioRepository;
import com.escolar.gestao.infrastructure.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthUseCaseImpl implements AuthUseCase {

    private final UsuarioRepository repo;
    private final PasswordEncoder encoder;
    private final JwtService jwt;

    public AuthUseCaseImpl(UsuarioRepository repo, PasswordEncoder encoder, JwtService jwt){
        this.repo = repo;
        this.encoder = encoder;
        this.jwt = jwt;
    }

    @Override
    public String login(String email, String senha){
        Usuario user = repo.findByEmail(email).orElseThrow(() -> new RuntimeException("Não foi possivel achar o usuario com esse email."));
        if(!encoder.matches(senha, user.senha))
            throw new RuntimeException("Credenciais inválidas");
        return jwt.generateToken(user);
    }
}
