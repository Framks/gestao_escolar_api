package com.escolar.gestao.infrastructure.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "turma")
public class TurmaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

    public String codigo;

    @ManyToOne
    public DisciplinaEntity disciplinaEntity;

    @ManyToOne
    public ProfessorEntity professor;

    public String semestre;

    public Integer capacidadeMaxima;

    @ManyToMany
    public List<AlunoEntity> alunos;

    @Column(name = "data_criacao")
    public LocalDateTime dataCriacao = LocalDateTime.now();

    public TurmaEntity() {
    }

    public TurmaEntity(
            String codigo,
            DisciplinaEntity disciplinaEntity,
            ProfessorEntity professor,
            String semestre,
            Integer vagas,
            List<AlunoEntity> alunos
    ) {
        this.codigo = codigo;
        this.disciplinaEntity = disciplinaEntity;
        this.professor = professor;
        this.semestre = semestre;
        this.capacidadeMaxima = vagas;
        this.alunos = alunos;
    }
}
