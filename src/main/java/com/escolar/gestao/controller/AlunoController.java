package com.escolar.gestao.controller;

import com.escolar.gestao.controller.request.AlunoPutRequest;
import com.escolar.gestao.controller.request.AlunoRequest;
import com.escolar.gestao.controller.response.AlunoResponse;
import com.escolar.gestao.domain.Aluno;
import com.escolar.gestao.enums.UserRole;
import com.escolar.gestao.mapper.AlunoMapper;
import com.escolar.gestao.repository.AlunoRepository;
import jakarta.validation.Valid;
import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoRepository repository;

    public AlunoController(AlunoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<AlunoResponse> create(@RequestBody @Valid AlunoRequest dto) {

        Aluno aluno = new Aluno(
                dto.nome(),
                dto.email(),
                dto.senha(),
                dto.cpf(),
                dto.dataNascimento()
        );

        aluno.role = UserRole.ALUNO;

        repository.save(aluno);

        return ResponseEntity
                .created(URI.create("/alunos/" + aluno.id))
                .body(new AlunoResponse(aluno));
    }

    @GetMapping
    public ResponseEntity<List<AlunoResponse>> findAll() {
        List<AlunoResponse> list = repository.findAll()
                .stream()
                .map(AlunoResponse::new)
                .toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoResponse> findById(@PathVariable Integer id) {
        return repository.findById(id)
                .map(a -> ResponseEntity.ok(new AlunoResponse(a)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoResponse> update(
            @PathVariable Integer id,
            @RequestBody @Valid AlunoRequest dto
    ) {
        return repository.findById(id).map(existing -> {

            existing.nome = dto.nome();
            existing.email = dto.email();
            existing.senha = dto.senha();
            existing.cpf = dto.cpf();
            existing.dataNascimento = dto.dataNascimento();

            repository.save(existing);

            return ResponseEntity.ok(new AlunoResponse(existing));

        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        return repository.findById(id).map(aluno -> {
            repository.delete(aluno);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}