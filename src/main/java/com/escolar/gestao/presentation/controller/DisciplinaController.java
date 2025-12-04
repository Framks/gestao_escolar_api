package com.escolar.gestao.presentation.controller;

import com.escolar.gestao.domain.Disciplina;
import com.escolar.gestao.infrastructure.persistence.jpaRepository.DisciplinaRepositoryJpa;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import static com.escolar.gestao.constants.URLconstants.URL_DISCIPLINA;

// ToDo Implementar

@RestController
@RequestMapping(URL_DISCIPLINA)
public class DisciplinaController {

    private final DisciplinaRepositoryJpa disciplinaRepositoryJpa;

    public DisciplinaController(DisciplinaRepositoryJpa disciplinaRepositoryJpa) {
        this.disciplinaRepositoryJpa = disciplinaRepositoryJpa;
    }

    @GetMapping
    public List<Disciplina> list() {
        return null;
    }

    @GetMapping("/{code}")
    public ResponseEntity<Disciplina> getById(
            @PathVariable
            String code
    ) {
        return null;
    }

    @PostMapping
    public ResponseEntity<Disciplina> create(
            @RequestBody
            Disciplina disciplina
    ) {
        return null;
    }

    @PutMapping("/{code}")
    public ResponseEntity<Disciplina> update(
            @PathVariable
            String code,

            @RequestBody
            Disciplina disciplina
    ) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable
            Long id
    ) {
        return null;
    }
}
