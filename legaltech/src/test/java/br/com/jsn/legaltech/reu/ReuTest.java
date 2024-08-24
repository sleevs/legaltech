package br.com.jsn.legaltech.reu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.jsn.legaltech.dto.ReuDto;
import io.restassured.RestAssured;


import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;



import static io.restassured.RestAssured.given;

@SpringBootTest
public class ReuTest {

    @BeforeEach
    public void setUp() {
       
        RestAssured.baseURI = "http://localhost:8080"; 
    }

     @Test
    public void testRegistrarReuSuccess() {
        
        ReuDto reu = new ReuDto();
        reu.setProcesso(20); 
        reu.setNome("Nome do Reu");
        reu.setDescricao("Descrição do Reu");

        given()
            .contentType("application/json")
            .body(reu)
        .when()
            .post("/reu")
        .then()
            .statusCode(200)
            .body("processo", equalTo(20))
            .body("nome", equalTo("Nome do Reu"))
            .body("descricao", equalTo("Descrição do Reu"));
    }
    
}
