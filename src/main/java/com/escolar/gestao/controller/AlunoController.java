package com.escolar.gestao.controller;

import com.escolar.gestao.controller.request.AlunoPutRequest;
import com.escolar.gestao.controller.request.AlunoRequest;
import com.escolar.gestao.domain.Aluno;
import com.escolar.gestao.mapper.AlunoMapper;
import com.escolar.gestao.repository.AlunoRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    private final AlunoRepository alunoRepository;

    public AlunoController(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @GetMapping
    public List<Aluno> list() {
        return alunoRepository.findAll();
    }

    @GetMapping("/{matricula}")
    public ResponseEntity<Aluno> getById(@PathVariable String matricula) {
        return alunoRepository.findByMatricula(matricula)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Aluno create(
            @Valid
            @RequestBody
            AlunoRequest aluno
    ) {
        return alunoRepository.save(AlunoMapper.toEntity(aluno));
    }

    @PutMapping("/{matricula}")
    public ResponseEntity<Aluno> update(
            @PathVariable
            String matricula,

            @RequestBody
            @Valid
            AlunoPutRequest aluno
    ) {
        return alunoRepository.findByMatricula(matricula)
                .map(existing -> {
                    existing.nome = aluno.nome;
                    existing.email = aluno.email;
                    existing.dataNascimento = aluno.dataNascimento;
                    existing.senha = aluno.senha;

                    Aluno saved = alunoRepository.save(existing);
                    return ResponseEntity.ok(saved);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{matricula}")
    public ResponseEntity<Void> delete(
            @PathVariable
            String matricula
    ) {
        return alunoRepository.findByMatricula(matricula)
                .map(existing -> {
                    existing.ativo = false;
                    alunoRepository.save(existing);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
