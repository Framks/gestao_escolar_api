package com.escolar.gestao.presentation.controller;

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
import org.springframework.web.bind.annotation.RestController;
import static com.escolar.gestao.constants.URLconstants.URL_ADMIN;

@RestController
@RequestMapping(URL_ADMIN)
public class AdminController {

    public AdminController( ) {

    }

    @PostMapping
    public ResponseEntity<AdminResponse> create(@RequestBody @Valid AdminRequest dto) {
        // ToDo Implementar
        return null;
    }

    @GetMapping
    public ResponseEntity<List<AdminResponse>> findAll() {
        // ToDo Implementar
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminResponse> findById(@PathVariable Integer id) {
        return null;
        // ToDo Implementar
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdminResponse> update(
            @PathVariable Integer id,
            @RequestBody @Valid AdminRequest dto
    ) {
        return null;
        // ToDo Implementar
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        return null;
        // ToDo Implementar
    }
}
