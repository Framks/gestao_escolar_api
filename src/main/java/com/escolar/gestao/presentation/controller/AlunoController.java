package com.escolar.gestao.presentation.controller;

import com.escolar.gestao.application.mapper.AlunoMapper;
import com.escolar.gestao.application.usecases.useCasesAluno.UseCaseCreateAluno;
import com.escolar.gestao.application.usecases.useCasesAluno.UseCaseDeleteAluno;
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
    private final UseCaseDeleteAluno deleteAluno;

    public AlunoController(
            UseCaseCreateAluno createAluno,
            UseCaseGetAluno getAluno,
            UseCaseUpdateAluno updateAluno,
            UseCaseDeleteAluno deleteAluno
    ) {
        this.createAluno = createAluno;
        this.getAluno = getAluno;
        this.updateAluno = updateAluno;
        this.deleteAluno = deleteAluno;
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

    @DeleteMapping("/{matricula}")
    public ResponseEntity delete(@PathVariable String matricula) {
        deleteAluno.delete(matricula);
        return ResponseEntity.noContent().build();
    }
}