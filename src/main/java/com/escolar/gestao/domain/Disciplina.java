package com.escolar.gestao.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public class Disciplina {

        public String nome;

        public String codigo;

        public String descricao;

        public Integer cargaHoraria;

        public LocalDateTime dataCriacao;

        public Disciplina() {
        }

        public Disciplina(
                String nome,
                Integer cargaHoraria,
                String descricao
        ) {
                this.nome = nome;
                this.cargaHoraria = cargaHoraria;
                this.descricao = descricao;
                this.dataCriacao = LocalDateTime.now();
                this.codigo = "DIS_" + UUID.randomUUID().toString().toUpperCase();
        }

        public Disciplina(
                String nome,
                Integer cargaHoraria,
                String descricao,
                String codigo,
                LocalDateTime dataCriacao
        ) {
            this.nome = nome;
            this.cargaHoraria = cargaHoraria;
            this.descricao = descricao;
            this.codigo = codigo;
            this.dataCriacao = dataCriacao;
        }
}
