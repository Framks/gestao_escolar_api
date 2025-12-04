package com.escolar.gestao.presentation.controller;

import com.escolar.gestao.presentation.controller.request.Professor.ProfessorRequest;
import com.escolar.gestao.presentation.controller.response.Professor.ProfessorResponse;
import com.escolar.gestao.infrastructure.persistence.jpaRepository.ProfessorRepositoryJpa;
import jakarta.validation.Valid;
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
import static com.escolar.gestao.constants.URLconstants.URL_PROFESSOR;

@RestController
@RequestMapping(URL_PROFESSOR)
public class ProfessorController {

    private final ProfessorRepositoryJpa repository;

    public ProfessorController(ProfessorRepositoryJpa repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<ProfessorResponse> create(@RequestBody @Valid ProfessorRequest dto) {
        return null;
    }

    @GetMapping
    public ResponseEntity<List<ProfessorResponse>> findAll() {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorResponse> findById(@PathVariable Integer id) {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessorResponse> update(
            @PathVariable Integer id,
            @RequestBody @Valid ProfessorRequest dto
    ) {
        return null;
    }

    @DeleteMapping("/{matricula}")
    public ResponseEntity delete(@PathVariable String matricula) {
        return null;
    }
}
