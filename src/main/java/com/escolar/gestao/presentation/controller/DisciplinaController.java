package com.escolar.gestao.presentation.controller;

import com.escolar.gestao.application.usecases.useCasesDesciplina.UseCaseCreateDisciplina;
import com.escolar.gestao.application.usecases.useCasesDesciplina.UseCaseDeleteDisciplina;
import com.escolar.gestao.application.usecases.useCasesDesciplina.UseCaseGetDisciplina;
import com.escolar.gestao.application.usecases.useCasesDesciplina.UseCaseUpdateDisciplina;
import com.escolar.gestao.domain.Disciplina;
import com.escolar.gestao.presentation.controller.request.Disciplina.DisciplinaPostRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static com.escolar.gestao.constants.URLconstants.URL_DISCIPLINA;

@RestController
@RequestMapping(URL_DISCIPLINA)
public class DisciplinaController {

    private final UseCaseGetDisciplina useCaseGetDisciplina;
    private final UseCaseDeleteDisciplina useCaseDeleteDisciplina;
    private final UseCaseCreateDisciplina useCaseCreateDisciplina;
    private final UseCaseUpdateDisciplina useCaseUpdateDisciplina;

    public DisciplinaController(
        UseCaseGetDisciplina getDisciplina,
        UseCaseCreateDisciplina createDisciplina,
        UseCaseUpdateDisciplina updateDisciplina,
        UseCaseDeleteDisciplina deleteDisciplina
    ) {
        this.useCaseCreateDisciplina = createDisciplina;
        this.useCaseUpdateDisciplina = updateDisciplina;
        this.useCaseDeleteDisciplina = deleteDisciplina;
        this.useCaseGetDisciplina = getDisciplina;
    }

    @GetMapping
    public List<Disciplina> list(
        @RequestParam
        Integer page,

        @RequestParam
        Integer size,

        @RequestParam
        String sort
    ) {
        // ToDo implementar
        return null;
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Disciplina> getByCodigo(
            @PathVariable
            String codigo
    ) {
        // ToDo implementar
        return null;
    }

    @PostMapping
    public ResponseEntity<Disciplina> create(
            @RequestBody
            @Valid
            DisciplinaPostRequest disciplina
    ) {
        // ToDo implementar
        return null;
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Disciplina> update(
            @PathVariable
            String codigo,

            @RequestBody
            @Valid
            DisciplinaPostRequest disciplina
    ) {
        // ToDo implementar
        return null;
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> delete(
            @PathVariable
            String codigo
    ) {
        return null;
    }
}
