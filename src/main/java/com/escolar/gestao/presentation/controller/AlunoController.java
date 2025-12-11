package com.escolar.gestao.presentation.controller;

import com.escolar.gestao.application.mapper.AlunoMapper;
import com.escolar.gestao.application.usecases.useCasesAluno.UseCaseCreateAluno;
import com.escolar.gestao.application.usecases.useCasesAluno.UseCaseDeleteAluno;
import com.escolar.gestao.application.usecases.useCasesAluno.UseCaseGetAluno;
import com.escolar.gestao.application.usecases.useCasesAluno.UseCaseUpdateAluno;
import com.escolar.gestao.domain.Aluno;
import com.escolar.gestao.presentation.controller.request.Aluno.AlunoRequest;
import com.escolar.gestao.presentation.controller.response.Aluno.AlunoPageableResponse;
import com.escolar.gestao.presentation.controller.response.Aluno.AlunoResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
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
    private final UseCaseGetAluno useCaseGetAluno;
    private final UseCaseUpdateAluno useCaseUpdateAluno;

    public AlunoController(
            UseCaseCreateAluno createAluno,
            UseCaseGetAluno getAluno,
            UseCaseUpdateAluno updateAluno,
            UseCaseDeleteAluno deleteAluno,
            UseCaseGetAluno useCaseGetAluno, UseCaseUpdateAluno useCaseUpdateAluno) {
        this.createAluno = createAluno;
        this.getAluno = getAluno;
        this.updateAluno = updateAluno;
        this.deleteAluno = deleteAluno;
        this.useCaseGetAluno = useCaseGetAluno;
        this.useCaseUpdateAluno = useCaseUpdateAluno;
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
    public ResponseEntity<AlunoPageableResponse> findAll(
        @RequestParam(defaultValue = "0") Integer page,
        @RequestParam(defaultValue = "10") Integer size,
        @RequestParam(defaultValue = "id") String sort
    ){
        List<Aluno> alunos = useCaseGetAluno.getAlunos(page, size, sort);
        List<AlunoResponse> alunosrespose = alunos.stream().map(AlunoResponse::new).toList();
        AlunoPageableResponse response = new AlunoPageableResponse(alunosrespose, page, size, sort);
        return ResponseEntity.ok(response);
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
        useCaseUpdateAluno.updateUser(AlunoMapper.toDomain(request), matricula);
        return null;
    }

    @DeleteMapping("/{matricula}")
    public ResponseEntity delete(@PathVariable String matricula) {
        deleteAluno.delete(matricula);
        return ResponseEntity.noContent().build();
    }
}