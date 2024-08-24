package br.com.jsn.legaltech.usuario;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.restassured.RestAssured;


import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;


import static io.restassured.RestAssured.given;

@SpringBootTest
public class UsuarioTest {

    @BeforeEach
    public void setUp() {
       
        RestAssured.baseURI = "http://localhost:8080"; 
    }



    @Test
    public void testCriarUsuario() {
        // Cria um objeto UsuarioDto para o teste
        String requestBody = "{ \"nome\": \"João\", \"email\": \"joao@example.com\" }";

        // Faz uma solicitação POST e verifica a resposta
        given()
            .contentType("application/json")
            .body(requestBody)
        .when()
            .post("/usuario")
        .then()
            .statusCode(200)
            .body("nome", equalTo("João"))
            .body("email", equalTo("joao@example.com"))
            .body("id", notNullValue()); 
    }


    @Test
    public void testCriarUsuarioBadRequest() {
        String requestBody = "{}"; // Dados ausentes

        given()
            .contentType("application/json")
            .body(requestBody)
        .when()
            .post("/usuario")
        .then()
            .statusCode(400)
            .body(equalTo("Requisição inválida: dados do Usuário são obrigatórios."));
    }

    
}
