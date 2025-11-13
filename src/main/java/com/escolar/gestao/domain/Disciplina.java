package com.escolar.gestao.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Disciplina {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        public Long id;

        public String nome;

        @Column(unique = true)
        public String codigo = "DIS_" + UUID.randomUUID().toString().toUpperCase();

        public String descricao;

        @Column(name = "carga_horaria")
        public int cargaHoraria;

        @Column(name = "data_criacao")
        public LocalDateTime dataCriacao = LocalDateTime.now();

        public Disciplina() {
        }

        public Disciplina(
                String nome,
                int cargaHoraria,
                String descricao
        ) {
                this.nome = nome;
                this.cargaHoraria = cargaHoraria;
                this.descricao = descricao;
        }
}
