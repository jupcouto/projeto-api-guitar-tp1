package br.unitins.topicos1.guitar.resource;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import static io.restassured.RestAssured.given;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class CorResourceTest {

    @Test
    public void buscarTodosTest() {
        given()
            .when().get("/cores")
            .then()
            .statusCode(200);
    }

    @Test
    public void buscarPorNomeTest() {
        given()
            .pathParam("nome", "Azul")
            .when().get("/cores/find/{nome}")
            .then()
            .statusCode(anyOf(is(200), is(404)));
    }

    @Test
    public void incluirTest() {
        String json = """
        {
            "nome": "Azul"
        }
        """;

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(json)
            .when().post("/cores")
            .then()
            .statusCode(anyOf(is(201), is(404)));
    }

    @Test
    public void atualizarTest() {
        String json = """
        {
            "nome": "Vermelho"
        }
        """;

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(json)
            .pathParam("id", 1)
            .when().put("/cores/{id}")
            .then()
            .statusCode(anyOf(is(204), is(404)));
    }

    @Test
    public void excluirTest() {
        given()
            .pathParam("id", 1)
            .when().delete("/cores/{id}")
            .then()
            .statusCode(anyOf(is(204), is(404)));
    }
}
