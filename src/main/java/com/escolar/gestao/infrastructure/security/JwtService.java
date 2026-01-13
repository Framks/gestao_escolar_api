package com.escolar.gestao.infrastructure.security;

import com.escolar.gestao.domain.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

@Service
public class JwtService {
    private final String SECRET = "chaveQueDevoPegarPorVariavelDeAmbienteNoFuturo";


    public String generateToken(Usuario user){
        return Jwts.builder()
                .setSubject(user.email)
                .claim("role", user.role)
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }


    public Claims extract(String token){
        return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
    }
}
