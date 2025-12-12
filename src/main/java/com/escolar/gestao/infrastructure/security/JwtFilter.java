package com.escolar.gestao.infrastructure.security;

import com.escolar.gestao.domain.Usuario;
import com.escolar.gestao.domain.repository.UsuarioRepository;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtFilter extends OncePerRequestFilter {


    private final JwtService jwt;
    private final UsuarioRepository repo;


    public JwtFilter(JwtService jwt, UsuarioRepository repo){
        this.jwt = jwt;
        this.repo = repo;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws ServletException, IOException {


        String header = req.getHeader("Authorization");
        if(header != null && header.startsWith("Bearer ")){
            String token = header.substring(7);
            Claims c = jwt.extract(token);
            Usuario user = repo.findByEmail(c.getSubject()).orElse(null);


            if(user != null){
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                        user, null, List.of(new SimpleGrantedAuthority("ROLE_"+user.role))
                );
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }
        chain.doFilter(req, res);
    }
}