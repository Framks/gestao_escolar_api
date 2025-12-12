package com.escolar.gestao.presentation.controller;

import com.escolar.gestao.application.mapper.AdminMapper;
import com.escolar.gestao.application.usecases.useCasesAdmin.UseCaseCreateAdmin;
import com.escolar.gestao.application.usecases.useCasesAdmin.UseCaseDeleteAdmin;
import com.escolar.gestao.application.usecases.useCasesAdmin.UseCaseGetAdmin;
import com.escolar.gestao.application.usecases.useCasesAdmin.UseCaseUpdateAdmin;
import com.escolar.gestao.constraint.Cpf;
import com.escolar.gestao.domain.Admin;
import com.escolar.gestao.presentation.controller.request.Admin.AdminRequest;
import com.escolar.gestao.presentation.controller.response.Admin.AdminResponse;
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
import static com.escolar.gestao.constants.URLconstants.URL_ADMIN;

@RestController
@RequestMapping(URL_ADMIN)
public class AdminController {

    private final UseCaseGetAdmin useCaseGetAdmin;
    private final UseCaseCreateAdmin useCaseCreateAdmin;
    private final UseCaseDeleteAdmin useCaseDeleteAdmin;
    private final UseCaseUpdateAdmin useCaseUpdateAdmin;

    public AdminController(
            UseCaseCreateAdmin createAdmin,
            UseCaseGetAdmin getAdmin,
            UseCaseUpdateAdmin updateAdmin,
            UseCaseDeleteAdmin deleteAdmin) {
        this.useCaseCreateAdmin = createAdmin;
        this.useCaseGetAdmin = getAdmin;
        this.useCaseUpdateAdmin = updateAdmin;
        this.useCaseDeleteAdmin = deleteAdmin;
    }

    @PostMapping
    public ResponseEntity<AdminResponse> create(
            @RequestBody @Valid AdminRequest request
    ) {
        Admin admin = useCaseCreateAdmin.createUser(AdminMapper.toDomain(request));
        return ResponseEntity.ok(AdminMapper.toResponse(admin));
    }

    @GetMapping
    public ResponseEntity<List<AdminResponse>> findAll(
            @RequestParam(defaultValue = "0")
            Integer page,

            @RequestParam(defaultValue = "10")
            Integer size,

            @RequestParam(defaultValue = "nome")
            String sortBy
    ) {
        List<Admin> list = useCaseGetAdmin.getAdmins(page, size, sortBy);
        List<AdminResponse> responses = list.stream().map(AdminMapper::toResponse).toList();
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{email}")
    public ResponseEntity<AdminResponse> findById(
            @PathVariable String email
    ) {
        Admin admin = useCaseGetAdmin.getAdmin(email);
        return ResponseEntity.ok(AdminMapper.toResponse(admin));
    }

    @PutMapping("/{email}")
    public ResponseEntity<AdminResponse> update(
            @PathVariable String email,
            @RequestBody @Valid AdminRequest request
    ) {
        Admin admin = useCaseUpdateAdmin.updateUser(AdminMapper.toDomain(request), email);
        return ResponseEntity.ok(AdminMapper.toResponse(admin));
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity delete(
            @PathVariable
            @Valid
            @Cpf
            String cpf
    ) {
        useCaseDeleteAdmin.delete(cpf);
        return ResponseEntity.noContent().build();
    }
}
