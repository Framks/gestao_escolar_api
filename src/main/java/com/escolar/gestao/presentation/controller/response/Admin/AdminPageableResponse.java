package com.escolar.gestao.presentation.controller.response.Admin;

import java.util.List;

public record AdminPageableResponse(
        List<AdminResponse> admins,
        Integer page,
        Integer size,
        String sortBy
){}