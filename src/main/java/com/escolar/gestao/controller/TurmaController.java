package com.escolar.gestao.controller;

import com.escolar.gestao.controller.request.TurmaRequest;
import com.escolar.gestao.controller.response.TurmaResponse;
import com.escolar.gestao.domain.Aluno;
import com.escolar.gestao.domain.Disciplina;
import com.escolar.gestao.domain.Professor;
import com.escolar.gestao.domain.Turma;
import com.escolar.gestao.repository.AlunoRepository;
import com.escolar.gestao.repository.DisciplinaRepository;
import com.escolar.gestao.repository.ProfessorRepository;
import com.escolar.gestao.repository.TurmaRepository;
import jakarta.validation.Valid;
import java.net.URI;
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

@RestController
@RequestMapping("/turmas")
public class TurmaController {

    private final TurmaRepository turmaRepo;
    private final DisciplinaRepository discRepo;
    private final ProfessorRepository profRepo;
    private final AlunoRepository alunoRepo;

    public TurmaController(
            TurmaRepository turmaRepo,
            DisciplinaRepository discRepo,
            ProfessorRepository profRepo,
            AlunoRepository alunoRepo
    ) {
        this.turmaRepo = turmaRepo;
        this.discRepo = discRepo;
        this.profRepo = profRepo;
        this.alunoRepo = alunoRepo;
    }

    @PostMapping
    public ResponseEntity<TurmaResponse> create(@RequestBody @Valid TurmaRequest dto) {

        Disciplina disciplina = discRepo.findByCodigo(dto.disciplinaCodigo())
                .orElseThrow(() -> new RuntimeException("Disciplina não encontrada"));

        Professor professor = profRepo.findByMatricula(dto.professorMatricula())
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));

        List<Aluno> alunos = dto.alunosMatriculas() == null ? List.of() :
                alunoRepo.findAllByMatriculaIn(dto.alunosMatriculas());

        Turma turma = new Turma(
                dto.codigo(),
                disciplina,
                professor,
                dto.semestre(),
                dto.capacidadeMaxima(),
                alunos
        );

        turmaRepo.save(turma);

        return ResponseEntity
                .created(URI.create("/turmas/" + turma.id))
                .body(new TurmaResponse(turma));
    }

    @GetMapping
    public ResponseEntity<List<TurmaResponse>> findAll() {
        List<TurmaResponse> list = turmaRepo.findAll()
                .stream()
                .map(TurmaResponse::new)
                .toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurmaResponse> findById(@PathVariable Long id) {
        return turmaRepo.findById(id)
                .map(t -> ResponseEntity.ok(new TurmaResponse(t)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TurmaResponse> update(
            @PathVariable Long id,
            @RequestBody @Valid TurmaRequest dto
    ) {
        return turmaRepo.findById(id).map(existing -> {

            Disciplina disciplina = discRepo.findByCodigo(dto.disciplinaCodigo())
                    .orElseThrow(() -> new RuntimeException("Disciplina não encontrada"));
            Professor professor = profRepo.findByMatricula(dto.professorMatricula())
                    .orElseThrow(() -> new RuntimeException("Professor não encontrado"));

            List<Aluno> alunos = dto.alunosMatriculas() == null ? List.of() :
                    alunoRepo.findAllByMatriculaIn(dto.alunosMatriculas());

            existing.codigo = dto.codigo();
            existing.disciplina = disciplina;
            existing.professor = professor;
            existing.semestre = dto.semestre();
            existing.capacidadeMaxima = dto.capacidadeMaxima();
            existing.alunos = alunos;

            turmaRepo.save(existing);

            return ResponseEntity.ok(new TurmaResponse(existing));

        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        return turmaRepo.findById(id).map(t -> {
            turmaRepo.delete(t);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
