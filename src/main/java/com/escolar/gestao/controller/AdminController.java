package com.escolar.gestao.controller;

import com.escolar.gestao.controller.request.AdminRequest;
import com.escolar.gestao.controller.response.AdminResponse;
import com.escolar.gestao.domain.Admin;
import com.escolar.gestao.enums.UserRole;
import com.escolar.gestao.repository.AdminRepository;
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
@RequestMapping("/admins")
public class AdminController {

    private final AdminRepository repository;

    public AdminController(AdminRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<AdminResponse> create(@RequestBody @Valid AdminRequest dto) {

        Admin admin = new Admin(
                dto.nome(),
                dto.email(),
                dto.senha(),
                dto.cpf(),
                dto.dataNascimento(),
                dto.cargo(),
                dto.permissoes()
        );

        admin.role = UserRole.ADMIN; // segurança

        repository.save(admin);

        return ResponseEntity
                .created(URI.create("/admins/" + admin.id))
                .body(new AdminResponse(admin));
    }

    @GetMapping
    public ResponseEntity<List<AdminResponse>> findAll() {
        List<AdminResponse> list = repository.findAll()
                .stream()
                .map(AdminResponse::new)
                .toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminResponse> findById(@PathVariable Integer id) {
        return repository.findById(id)
                .map(admin -> ResponseEntity.ok(new AdminResponse(admin)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdminResponse> update(
            @PathVariable Integer id,
            @RequestBody @Valid AdminRequest dto
    ) {

        return repository.findById(id).map(existing -> {

            existing.nome = dto.nome();
            existing.email = dto.email();
            existing.senha = dto.senha();
            existing.cpf = dto.cpf();
            existing.dataNascimento = dto.dataNascimento();
            existing.cargo = dto.cargo();
            existing.permissoes = dto.permissoes();

            repository.save(existing);

            return ResponseEntity.ok(new AdminResponse(existing));

        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        return repository.findById(id).map(admin -> {
            repository.delete(admin);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
