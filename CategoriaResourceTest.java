package br.unitins.topicos1.guitar.resource;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import static io.restassured.RestAssured.given;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class CategoriaResourceTest {

    @Test
    public void buscarTodosTest() {
        given()
            .when().get("/categorias")
            .then()
            .statusCode(200);
    }

    @Test
    public void buscarPorNomeTest() {
        given()
            .pathParam("nome", "Acústico")
            .when().get("/categorias/find/{nome}")
            .then()
            .statusCode(anyOf(is(200), is(404)));
    }

    @Test
    public void incluirTest() {
        String json = """
        {
            "classificacao": "Elétrico"
        }
        """;

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(json)
            .when().post("/categorias")
            .then()
            .statusCode(201)
            .body("classificacao", equalTo("Elétrico"));
    }

    @Test
    public void atualizarTest() {
        String json = """
        {
            "classificacao": "Clássico"
        }
        """;

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(json)
            .pathParam("id", 1)
            .when().put("/categorias/{id}")
            .then()
            .statusCode(anyOf(is(204), is(404)));
    }

    @Test
    public void excluirTest() {
        given()
            .pathParam("id", 1)
            .when().delete("/categorias/{id}")
            .then()
            .statusCode(anyOf(is(204), is(404)));
    }
}
