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

@Entity
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

    public String codigo;

    @ManyToOne
    public Disciplina disciplina;

    @ManyToOne
    public ProfessorEntity professor;

    public String semestre;

    public Integer capacidadeMaxima;

    @ManyToMany
    public List<AlunoEntity> alunos;

    @Column(name = "data_criacao")
    public LocalDateTime dataCriacao = LocalDateTime.now();

    public Turma() {
    }

    public Turma(
            String codigo,
            Disciplina disciplina,
            ProfessorEntity professor,
            String semestre,
            Integer vagas,
            List<AlunoEntity> alunos
    ) {
        this.codigo = codigo;
        this.disciplina = disciplina;
        this.professor = professor;
        this.semestre = semestre;
        this.capacidadeMaxima = vagas;
        this.alunos = alunos;
    }
}
