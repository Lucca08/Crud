package com.example.Crud.ControllerTest;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.restassured.http.ContentType;


public class PessoaControllerTest {

    @BeforeEach
    public void setUp() {
        baseURI = "http://localhost";
        port = 8080;
    }
    @Test
    public void testCriaPessoa() {
        given()
            .contentType(ContentType.JSON)
            .given()
            .contentType(ContentType.JSON)
            .body("{ \"nome\": \"Fulano\", \"cpf\": \"12345678901\", \"dataNascimento\": \"2024-03-19\", \"enderecoPrincipal\": { \"rua\": \"Rua ABC\", \"numero\": \"123\", \"bairro\": \"Centro\", \"cidade\": \"Cidade\", \"estado\": \"Estado\", \"cep\": \"12345678\", \"enderecoCompleto\": \"Rua ABC, 123, Centro, Cidade, Estado, 12345678\" }, \"idade\": 30 }")
        .when()
            .post("/pessoas")
        .then()
            .statusCode(201)
            .body("nome", equalTo("Fulano"))
            .body("cpf", equalTo("12345678901"))
            .body("dataNascimento", equalTo("2024-03-19"))
            .body("enderecoPrincipal.rua", equalTo("Rua ABC"))
            .body("enderecoPrincipal.numero", equalTo("123"))
            .body("enderecoPrincipal.bairro", equalTo("Centro"))
            .body("enderecoPrincipal.cidade", equalTo("Cidade"))
            .body("enderecoPrincipal.estado", equalTo("Estado"))
            .body("enderecoPrincipal.cep", equalTo("12345678"))
            .body("enderecoPrincipal.enderecoCompleto", equalTo("Rua ABC, 123, Centro, Cidade, Estado, 12345678"))
            .body("idade", equalTo(30));
    }
     

    @Test
    public void testBuscarTodasPessoas() {
        when()
            .get("/pessoas")
        .then()
            .statusCode(200)
            .body("size()", greaterThan(0)); 
    }

    @Test
    public void testBuscarPessoaById() {
        int id =2; 
        when()
            .get("/pessoas/{id}", id)
        .then()
            .statusCode(200)
            .body("id", equalTo(id));
    }

    @Test
    public void testAtualizaPessoa() {
        int id = 2;
        given()
            .contentType(ContentType.JSON)
            .body("{ \"nome\": \"Fulano\", \"cpf\": \"12345678901\", \"dataNascimento\": \"2024-03-19\", \"enderecoPrincipal\": { \"rua\": \"Rua ABC\", \"numero\": \"123\", \"bairro\": \"Centro\", \"cidade\": \"Cidade\", \"estado\": \"Estado\", \"cep\": \"12345678\", \"enderecoCompleto\": \"Rua ABC, 123, Centro, Cidade, Estado, 12345678\" }, \"idade\": 30 }")
        .when()
            .put("/pessoas/{id}", id)
        .then()
            .statusCode(200)
            .body("nome", equalTo("Fulano"))
            .body("cpf", equalTo("12345678901"))
            .body("dataNascimento", equalTo("2024-03-19"))
            .body("enderecoPrincipal.rua", equalTo("Rua ABC"))
            .body("enderecoPrincipal.numero", equalTo("123"))
            .body("enderecoPrincipal.bairro", equalTo("Centro"))
            .body("enderecoPrincipal.cidade", equalTo("Cidade"))
            .body("enderecoPrincipal.estado", equalTo("Estado"))
            .body("enderecoPrincipal.cep", equalTo("12345678"))
            .body("enderecoPrincipal.enderecoCompleto", equalTo("Rua ABC, 123, Centro, Cidade, Estado, 12345678"))
            .body("idade", equalTo(30));

    }

    @Test
    public void testDeletaPessoa() {
        int id = 2; 
        when()
            .delete("/pessoas/{id}", id)
        .then()
            .statusCode(204); 
    }

    @Test
    public void testVerificarIdadePessoa() {
        int id = 2;
        when()
            .get("/pessoas/{id}/idade", id)
        .then()
            .statusCode(200)
            .body("idade", equalTo(12));
    }
}
