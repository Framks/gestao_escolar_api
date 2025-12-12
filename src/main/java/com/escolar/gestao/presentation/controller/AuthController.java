package com.escolar.gestao.presentation.controller;

import com.escolar.gestao.application.usecases.AuthUseCase;
import com.escolar.gestao.presentation.controller.request.auth.LoginRequest;
import com.escolar.gestao.presentation.controller.response.TokenResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.escolar.gestao.constants.URLconstants.URL_AUHT;

@RestController
@RequestMapping(URL_AUHT)
public class AuthController {

    private final AuthUseCase authUseCase;

    public AuthController(AuthUseCase authUseCase){
        this.authUseCase = authUseCase;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req){
        String token = authUseCase.login(req.email(), req.senha());
        return ResponseEntity.ok(new TokenResponse(token));
    }
}