package com.escolar.gestao.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
    public Professor professor;

    public String semestre;

    public Integer capacidadeMaxima;

    @ManyToMany
    public List<Aluno> alunos;

    @Column(name = "data_criacao")
    public LocalDateTime dataCriacao = LocalDateTime.now();

    public Turma() {
    }

    public Turma(
            String codigo,
            Disciplina disciplina,
            Professor professor,
            String semestre,
            Integer vagas,
            List<Aluno> alunos
    ) {
        this.codigo = codigo;
        this.disciplina = disciplina;
        this.professor = professor;
        this.semestre = semestre;
        this.capacidadeMaxima = vagas;
        this.alunos = alunos;
    }
}
