package br.unitins.topicos1.guitar.resource;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import static io.restassured.RestAssured.given;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class ModeloResourceTest {

    @Test
    public void buscarTodosTest() {
        given()
            .when().get("/modelos")
            .then()
            .statusCode(200);
    }

    @Test
    public void buscarPorNomeTest() {
        given()
            .pathParam("nome", "Fender")
            .when().get("/modelos/find/{nome}")
            .then()
            .statusCode(anyOf(is(200), is(404)));
    }

    @Test
    public void incluirTest() {
        String json = """
        {
            "nome": "Fender Stratocaster",
            "anoFabricacao": 2020,
            "escala": "Rosewood"
        }
        """;

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(json)
            .when().post("/modelos")
            .then()
            .statusCode(201)
            .body("nome", equalTo("Fender Stratocaster"));
    }

    @Test
    public void atualizarTest() {
        String json = """
        {
            "nome": "Gibson Les Paul",
            "anoFabricacao": 2022,
            "escala": "Maple"
        }
        """;

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(json)
            .pathParam("id", 1)
            .when().put("/modelos/{id}")
            .then()
            .statusCode(anyOf(is(204), is(404)));
    }

    @Test
    public void excluirTest() {
        given()
            .pathParam("id", 1)
            .when().delete("/modelos/{id}")
            .then()
            .statusCode(anyOf(is(204), is(404)));
    }
}
