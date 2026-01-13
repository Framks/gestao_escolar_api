package com.escolar.gestao.presentation.controller;

import com.escolar.gestao.application.mapper.ProfessorMapper;
import com.escolar.gestao.application.usecases.useCasesProfessor.UseCaseCreateProfessor;
import com.escolar.gestao.application.usecases.useCasesProfessor.UseCaseDeleteProfessor;
import com.escolar.gestao.application.usecases.useCasesProfessor.UseCaseGetProfessor;
import com.escolar.gestao.application.usecases.useCasesProfessor.UseCaseUpdateProfessor;
import com.escolar.gestao.domain.Professor;
import com.escolar.gestao.presentation.controller.request.Professor.ProfessorRequest;
import com.escolar.gestao.presentation.controller.response.Professor.ProfessorPageableResponse;
import com.escolar.gestao.presentation.controller.response.Professor.ProfessorResponse;
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
    public ResponseEntity<ProfessorResponse> create(
            @RequestBody
            @Valid
            ProfessorRequest request
    ) {
        Professor result = useCaseCreateProfessor.create(ProfessorMapper.toDomain(request));
        return ResponseEntity.ok(ProfessorMapper.toResponse(result));
    }

    @GetMapping
    public ResponseEntity<ProfessorPageableResponse> findAll(
        @RequestParam(defaultValue = "0")
        Integer page,
        @RequestParam(defaultValue = "10")
        Integer size,
        @RequestParam()
        String sort
    ) {
        List<Professor> list = useCaseGetProfessor.getProfessores(page, size, sort);
        List<ProfessorResponse> result = list.stream().map(ProfessorMapper::toResponse).toList();
        ProfessorPageableResponse response =  new ProfessorPageableResponse(result, page, size,  sort);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{matricula}")
    public ResponseEntity<ProfessorResponse> findByMatricula(
            @PathVariable
            String matricula
    ) {
        Professor professor = useCaseGetProfessor.getProfessorByMatricula(matricula);
        return ResponseEntity.ok(ProfessorMapper.toResponse(professor));
    }

    @PutMapping("/{matricula}")
    public ResponseEntity<ProfessorResponse> update(
            @PathVariable
            String matricula,
            @RequestBody
            @Valid
            ProfessorRequest request
    ) {
        Professor result = useCaseUpdateProfessor.update(ProfessorMapper.toDomain(request), matricula);
        return ResponseEntity.ok(ProfessorMapper.toResponse(result));
    }

    @DeleteMapping("/{matricula}")
    public ResponseEntity delete(
            @PathVariable
            String matricula
    ) {
        useCaseDeleteProfessor.delete(matricula);
        return null;
    }
}
