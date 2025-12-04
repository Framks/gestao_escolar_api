package com.escolar.gestao.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public class Disciplina {

        public String nome;

        public String codigo = "DIS_" + UUID.randomUUID().toString().toUpperCase();

        public String descricao;

        public int cargaHoraria;

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
