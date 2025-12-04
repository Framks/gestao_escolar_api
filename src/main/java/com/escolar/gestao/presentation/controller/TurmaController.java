package com.escolar.gestao.presentation.controller;

import com.escolar.gestao.presentation.controller.request.Turma.TurmaRequest;
import com.escolar.gestao.presentation.controller.response.Turma.TurmaResponse;
import com.escolar.gestao.infrastructure.persistence.jpaRepository.AlunoRepositoryJpa;
import com.escolar.gestao.infrastructure.persistence.jpaRepository.DisciplinaRepositoryJpa;
import com.escolar.gestao.infrastructure.persistence.jpaRepository.ProfessorRepositoryJpa;
import com.escolar.gestao.infrastructure.persistence.jpaRepository.TurmaRepositoryJpa;
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
import static com.escolar.gestao.constants.URLconstants.URL_TURMA;

@RestController
@RequestMapping(URL_TURMA)
public class TurmaController {

    private final TurmaRepositoryJpa turmaRepo;
    private final DisciplinaRepositoryJpa discRepo;
    private final ProfessorRepositoryJpa profRepo;
    private final AlunoRepositoryJpa alunoRepo;

    public TurmaController(
            TurmaRepositoryJpa turmaRepo,
            DisciplinaRepositoryJpa discRepo,
            ProfessorRepositoryJpa profRepo,
            AlunoRepositoryJpa alunoRepo
    ) {
        this.turmaRepo = turmaRepo;
        this.discRepo = discRepo;
        this.profRepo = profRepo;
        this.alunoRepo = alunoRepo;
    }

    @PostMapping
    public ResponseEntity<TurmaResponse> create(@RequestBody @Valid TurmaRequest dto) {
        return null;
    }

    @GetMapping
    public ResponseEntity<List<TurmaResponse>> findAll() {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurmaResponse> findById(@PathVariable Long id) {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<TurmaResponse> update(
            @PathVariable Long id,
            @RequestBody @Valid TurmaRequest dto
    ) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        return null;
    }
}
