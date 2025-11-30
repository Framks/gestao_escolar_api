package com.escolar.gestao.controller;

import com.escolar.gestao.controller.request.ProfessorRequest;
import com.escolar.gestao.controller.response.ProfessorResponse;
import com.escolar.gestao.domain.Professor;
import com.escolar.gestao.enums.UserRole;
import com.escolar.gestao.repository.ProfessorRepository;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    private final ProfessorRepository repository;

    public ProfessorController(ProfessorRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<ProfessorResponse> create(@RequestBody @Valid ProfessorRequest dto) {

        Professor professor = new Professor(
                dto.nome(),
                dto.email(),
                dto.senha(),
                dto.cpf(),
                dto.dataNascimento()
        );

        professor.role = UserRole.PROFESSOR;

        repository.save(professor);

        return ResponseEntity
                .created(URI.create("/professores/" + professor.matricula))
                .body(new ProfessorResponse(professor));
    }

    @GetMapping
    public ResponseEntity<List<ProfessorResponse>> findAll() {
        List<ProfessorResponse> list = repository.findAll()
                .stream()
                .map(ProfessorResponse::new)
                .toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorResponse> findById(@PathVariable Integer id) {
        return repository.findById(id)
                .map(p -> ResponseEntity.ok(new ProfessorResponse(p)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessorResponse> update(
            @PathVariable Integer id,
            @RequestBody @Valid ProfessorRequest dto
    ) {

        return repository.findById(id).map(existing -> {

            existing.nome = dto.nome();
            existing.email = dto.email();
            existing.senha = dto.senha();
            existing.cpf = dto.cpf();
            existing.dataNascimento = dto.dataNascimento();

            repository.save(existing);

            return ResponseEntity.ok(new ProfessorResponse(existing));

        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{matricula}")
    public ResponseEntity delete(@PathVariable String matricula) {
        return repository.findByMatricula(matricula).map(professor -> {
            repository.delete(professor);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
