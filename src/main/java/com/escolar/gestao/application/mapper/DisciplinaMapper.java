package com.escolar.gestao.application.mapper;

import com.escolar.gestao.domain.Disciplina;
import com.escolar.gestao.infrastructure.persistence.entity.DisciplinaEntity;

public class DisciplinaMapper {
    public static Disciplina toDomain(DisciplinaEntity entity){
        return new Disciplina(
                entity.nome,
                entity.cargaHoraria,
                entity.descricao,
                entity.codigo,
                entity.dataCriacao
        );
    }
}
