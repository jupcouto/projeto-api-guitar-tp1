package br.unitins.topicos1.guitar.resource;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import static io.restassured.RestAssured.given;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class MarcaResourceTest {

    @Test
    public void buscarTodosTest() {
        given()
            .when().get("/marcas")
            .then()
            .statusCode(200);
    }

    @Test
    public void buscarPorNomeTest() {
        given()
            .pathParam("nome", "Tagima")
            .when().get("/marcas/find/{nome}")
            .then()
            .statusCode(anyOf(is(200), is(404))); // depende se há dados no banco
    }

    @Test
    public void incluirTest() {
        String json = """
        {
            "nome": "Fender"
        }
        """;

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(json)
            .when().post("/marcas")
            .then()
            .statusCode(201)
            .body("nome", equalTo("Fender"));
    }

    @Test
    public void atualizarTest() {
        String json = """
        {
            "nome": "Gibson"
        }
        """;

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(json)
            .pathParam("id", 1)
            .when().put("/marcas/{id}")
            .then()
            .statusCode(anyOf(is(204), is(404)));
    }

    @Test
    public void excluirTest() {
        given()
            .pathParam("id", 1)
            .when().delete("/marcas/{id}")
            .then()
            .statusCode(anyOf(is(204), is(404)));
    }
}
