package com.escolar.gestao.application.usecases.useCasesAdmin;

import com.escolar.gestao.domain.Admin;

public interface UseCaseUpdateAdmin {
    Admin updateUser(Admin admin, String email);
}

