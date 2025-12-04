package com.escolar.gestao.presentation.controller;

import com.escolar.gestao.application.mapper.AlunoMapper;
import com.escolar.gestao.application.usecases.useCasesAluno.UseCaseCreateAluno;
import com.escolar.gestao.application.usecases.useCasesAluno.UseCaseGetAluno;
import com.escolar.gestao.application.usecases.useCasesAluno.UseCaseUpdateAluno;
import com.escolar.gestao.presentation.controller.request.Aluno.AlunoRequest;
import com.escolar.gestao.presentation.controller.response.Aluno.AlunoResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static com.escolar.gestao.constants.URLconstants.URL_ALUNO;

@RestController
@RequestMapping(URL_ALUNO)
public class AlunoController {

    private final UseCaseCreateAluno createAluno;
    private final UseCaseGetAluno getAluno;
    private final UseCaseUpdateAluno updateAluno;

    public AlunoController(
            UseCaseCreateAluno createAluno,
            UseCaseGetAluno getAluno,
            UseCaseUpdateAluno updateAluno
    ) {
        this.createAluno = createAluno;
        this.getAluno = getAluno;
        this.updateAluno = updateAluno;
    }

    @PostMapping
    public ResponseEntity<AlunoResponse> create(@RequestBody @Valid AlunoRequest request) {
        AlunoResponse response = AlunoMapper.toResponse(
                createAluno.createUser(
                        AlunoMapper.toDomain(request)
                )
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<AlunoResponse>> findAll() {
        // ToDo Implementar
        return null;
    }

    @GetMapping("/{matricula}")
    public ResponseEntity<AlunoResponse> findByMatricula(
            @PathVariable
            String matricula
    ) {
        AlunoResponse response = AlunoMapper.toResponse(getAluno.getAluno(matricula));
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{matricula}")
    public ResponseEntity<AlunoResponse> update(
            @PathVariable
            String matricula,

            @RequestBody
            @Valid
            AlunoRequest request
    ) {
        // ToDo Implementar
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        // ToDo Implementar
        return null;
    }
}