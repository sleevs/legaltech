package br.com.jsn.legaltech.processo;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.jsn.legaltech.dto.ProcessoDto;
import br.com.jsn.legaltech.dto.ReuDto;
import io.restassured.RestAssured;


import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;



import static io.restassured.RestAssured.given;

@SpringBootTest
public class ProcessoTest {

    @BeforeEach
    public void setUp() {
       
        RestAssured.baseURI = "http://localhost:8080"; 
    }

     @Test
    public void testRegistrarProcessoSuccess() {
        // Dados válidos para registrar um processo
        ProcessoDto processo = new ProcessoDto();
        processo.setNumero(20);
        processo.setDescricao("Descrição do Processo");

        given()
            .contentType("application/json")
            .body(processo)
        .when()
            .post("/processo")
        .then()
            .statusCode(200)
            .body("numero", equalTo(20))
            .body("descricao", equalTo("Descrição do Processo"));
    }



    @Test
    public void testRegistrarProcessoConflict() {
        // Dados válidos, mas o número do processo já está cadastrado
        ProcessoDto processo = new ProcessoDto();
        processo.setNumero(20); // Substitua com um número que você sabe que já está cadastrado
        processo.setDescricao("Descrição do Processo");

        given()
            .contentType("application/json")
            .body(processo)
        .when()
            .post("/processo")
        .then()
            .statusCode(409)
            .body(equalTo("Número de processo já cadastrado anteriormente."));
    }
    
}
