package com.escolar.gestao.application.usecases.useCasesAdmin;

import com.escolar.gestao.domain.Admin;
import java.util.List;

public interface UseCaseGetAdmin {
    Admin getAdmin(String admin);
    List<Admin> getAdmins(Integer page, Integer size, String orderBy);
}

