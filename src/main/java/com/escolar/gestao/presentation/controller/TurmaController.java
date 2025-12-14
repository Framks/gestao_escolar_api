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
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<TurmaResponse> create(
            @RequestBody
            @Valid
            TurmaRequest request
    ) {
        // ToDo implementar
        return null;
    }

    @GetMapping
    public ResponseEntity<List<TurmaResponse>> findAll(
            @RequestParam(defaultValue = "0")
            Integer page,
            @RequestParam(defaultValue = "10")
            Integer size,
            @RequestParam
            String sortBy
    ) {
        // ToDo implementar
        return null;
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<TurmaResponse> findByCode(
            @PathVariable
            String codigo
    ) {
        // ToDo implementar
        return null;
    }

    @PutMapping("/{code}")
    public ResponseEntity<TurmaResponse> update(
            @PathVariable
            String code,

            @RequestBody
            @Valid
            TurmaRequest request
    ) {
        // ToDo implementar
        return null;
    }

    @DeleteMapping("/{code}")
    public ResponseEntity delete(
            @PathVariable
            String code
    ) {
        // ToDo implementar
        return null;
    }
}
