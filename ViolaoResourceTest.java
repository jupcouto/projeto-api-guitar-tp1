package br.unitins.topicos1.guitar.resource;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import static io.restassured.RestAssured.given;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class ViolaoResourceTest {

    @Test
    public void buscarTodosTest() {
        given()
            .when().get("/violoes")
            .then()
            .statusCode(200);
    }

    @Test
    public void buscarPorModeloTest() {
        given()
            .pathParam("nomeModelo", "Fender")
            .when().get("/violoes/modelo/{nomeModelo}")
            .then()
            .statusCode(anyOf(is(200), is(404)));
    }

    @Test
    public void incluirTest() {
        String json = """
        {
            "cor": "Preto",
            "preco": 1200.0,
            "idModelo": 1
        }
        """;

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(json)
            .when().post("/violoes")
            .then()
            .statusCode(anyOf(is(201), is(404)));
    }

    @Test
    public void atualizarTest() {
        String json = """
        {
            "cor": "Vermelho",
            "preco": 1500.0,
            "idModelo": 1
        }
        """;

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(json)
            .pathParam("id", 1)
            .when().put("/violoes/{id}")
            .then()
            .statusCode(anyOf(is(204), is(404)));
    }

    @Test
    public void excluirTest() {
        given()
            .pathParam("id", 1)
            .when().delete("/violoes/{id}")
            .then()
            .statusCode(anyOf(is(204), is(404)));
    }
}
