package com.escolar.gestao.presentation.controller;

import com.escolar.gestao.application.usecases.useCasesTurma.UseCaseCreateTurma;
import com.escolar.gestao.application.usecases.useCasesTurma.UseCaseDeleteTurma;
import com.escolar.gestao.application.usecases.useCasesTurma.UseCaseGetTurma;
import com.escolar.gestao.application.usecases.useCasesTurma.UseCaseUpdateTurma;
import com.escolar.gestao.presentation.controller.request.Turma.TurmaPutRequest;
import com.escolar.gestao.presentation.controller.request.Turma.TurmaRequest;
import com.escolar.gestao.presentation.controller.response.Turma.TurmaResponse;
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

    private final UseCaseGetTurma useCaseGetTurma;
    private final UseCaseCreateTurma useCaseCreateTurma;
    private final UseCaseDeleteTurma useCaseDeleteTurma;
    private final UseCaseUpdateTurma useCaseUpdateTurma;

    public TurmaController(
            UseCaseGetTurma getTurma,
            UseCaseDeleteTurma deleteTurma,
            UseCaseCreateTurma createTurma,
            UseCaseUpdateTurma updateTurma
    ) {
        this.useCaseGetTurma = getTurma;
        this.useCaseCreateTurma = createTurma;
        this.useCaseDeleteTurma = deleteTurma;
        this.useCaseUpdateTurma = updateTurma;
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
            @RequestParam("sort")
            String sortBy
    ) {
        // ToDo implementar
        return null;
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<TurmaResponse> findByCodigo(
            @PathVariable
            String codigo
    ) {
        // ToDo implementar
        return null;
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<TurmaResponse> update(
            @PathVariable
            String codigo,

            @RequestBody
            @Valid
            TurmaPutRequest request
    ) {
        // ToDo implementar
        return null;
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity delete(
            @PathVariable
            String codigo
    ) {
        // ToDo implementar
        return null;
    }

    @PutMapping("/{codigo}/alunos/{matricula}")
    public ResponseEntity addAluno(

    ){
        // ToDo implementar
        return null;
    }

    @DeleteMapping("/{codigo}/alunos/{matricula}")
    public ResponseEntity removeAluno(

    ){
        // ToDo implementar
        return null;
    }
}
