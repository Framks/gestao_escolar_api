package com.escolar.gestao.controller;

import com.escolar.gestao.domain.Disciplina;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DisciplinaControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void createAndGetDisciplina() {
        var disciplina = new Disciplina("Matemática", 60, "");

        ResponseEntity<Disciplina> postResponse = restTemplate.postForEntity(
                "http://localhost:" + port + "/api/disciplinas", disciplina, Disciplina.class);

        assertThat(postResponse.getStatusCode().is2xxSuccessful()).isTrue();
        Disciplina created = postResponse.getBody();
        assertThat(created).isNotNull();
        assertThat(created.id).isNotNull();

        ResponseEntity<Disciplina> getResponse = restTemplate.getForEntity(
                "http://localhost:" + port + "/api/disciplinas/" + created.id, Disciplina.class);

        assertThat(getResponse.getStatusCode().is2xxSuccessful()).isTrue();
        Disciplina fetched = getResponse.getBody();
        assertThat(fetched).isNotNull();
        assertThat(fetched.nome).isEqualTo("Matemática");
    }
}
