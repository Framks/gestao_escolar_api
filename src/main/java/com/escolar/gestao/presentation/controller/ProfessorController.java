package com.escolar.gestao.presentation.controller;

import com.escolar.gestao.application.usecases.useCasesProfessor.UseCaseCreateProfessor;
import com.escolar.gestao.application.usecases.useCasesProfessor.UseCaseDeleteProfessor;
import com.escolar.gestao.application.usecases.useCasesProfessor.UseCaseGetProfessor;
import com.escolar.gestao.application.usecases.useCasesProfessor.UseCaseUpdateProfessor;
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

    private final UseCaseCreateProfessor useCaseCreateProfessor;
    private final UseCaseDeleteProfessor useCaseDeleteProfessor;
    private final UseCaseGetProfessor  useCaseGetProfessor;
    private final UseCaseUpdateProfessor useCaseUpdateProfessor;

    public ProfessorController(
            UseCaseCreateProfessor CreateProfessor,
            UseCaseDeleteProfessor DeleteProfessor,
            UseCaseGetProfessor  GetProfessor,
            UseCaseUpdateProfessor UpdateProfessor
    ) {
        this.useCaseCreateProfessor = CreateProfessor;
        this.useCaseDeleteProfessor = DeleteProfessor;
        this.useCaseGetProfessor = GetProfessor;
        this.useCaseUpdateProfessor = UpdateProfessor;
    }

    @PostMapping
    public ResponseEntity<ProfessorResponse> create(@RequestBody @Valid ProfessorRequest dto) {
        // ToDo implementar
        return null;
    }

    @GetMapping
    public ResponseEntity<List<ProfessorResponse>> findAll() {
        // ToDo implementar
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorResponse> findById(@PathVariable Integer id) {
        // ToDo implementar
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessorResponse> update(
            @PathVariable Integer id,
            @RequestBody @Valid ProfessorRequest dto
    ) {
        // ToDo implementar
        return null;
    }

    @DeleteMapping("/{matricula}")
    public ResponseEntity delete(@PathVariable String matricula) {
        // ToDo implementar
        return null;
    }
}
