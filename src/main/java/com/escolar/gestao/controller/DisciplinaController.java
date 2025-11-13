package com.escolar.gestao.controller;

import com.escolar.gestao.domain.Disciplina;
import com.escolar.gestao.repository.DisciplinaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/disciplinas")
public class DisciplinaController {

    private final DisciplinaRepository disciplinaRepository;

    public DisciplinaController(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }

    @GetMapping
    public List<Disciplina> list() {
        return disciplinaRepository.findAll();
    }

    @GetMapping("/{code}")
    public ResponseEntity<Disciplina> getById(
            @PathVariable
            String code
    ) {
        return disciplinaRepository.findByCodigo(code)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Disciplina> create(
            @RequestBody
            Disciplina disciplina
    ) {
        Disciplina saved = disciplinaRepository.save(disciplina);
        return ResponseEntity.created(URI.create("/api/disciplinas/" + saved.codigo)).body(saved);
    }

    @PutMapping("/{code}")
    public ResponseEntity<Disciplina> update(
            @PathVariable
            String code,

            @RequestBody
            Disciplina disciplina
    ) {
        return disciplinaRepository.findByCodigo(code)
                .map(existing -> {
                    existing.nome = disciplina.nome;
                    existing.cargaHoraria = disciplina.cargaHoraria;
                    Disciplina saved = disciplinaRepository.save(existing);
                    return ResponseEntity.ok(saved);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable
            Long id
    ) {
        return disciplinaRepository.findById(id)
                .map(existing -> {
                    disciplinaRepository.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
