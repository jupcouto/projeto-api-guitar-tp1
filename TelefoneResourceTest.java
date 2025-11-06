package br.unitins.topicos1.guitar.resource;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import static io.restassured.RestAssured.given;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class TelefoneResourceTest {

    @Test
    public void buscarTodosTest() {
        given()
            .when().get("/telefones")
            .then()
            .statusCode(200);
    }

    @Test
    public void buscarPorNumeroTest() {
        given()
            .pathParam("numero", "999999999")
            .when().get("/telefones/numero/{numero}")
            .then()
            .statusCode(anyOf(is(200), is(404))); // depende se há dados no banco
    }

    @Test
    public void incluirTest() {
        String json = """
        {
            "codigoArea": "63",
            "numero": "999999999"
        }
        """;

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(json)
            .when().post("/telefones")
            .then()
            .statusCode(anyOf(is(201), is(404)))
            .body("codigoArea", equalTo("63"))
            .body("numero", equalTo("999999999"));
    }

    @Test
    public void atualizarTest() {
        String json = """
        {
            "codigoArea": "62",
            "numero": "988888888"
        }
        """;

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(json)
            .pathParam("id", 1)
            .when().put("/telefones/{id}")
            .then()
            .statusCode(anyOf(is(204), is(404)));
    }

    @Test
    public void excluirTest() {
        given()
            .pathParam("id", 1)
            .when().delete("/telefones/{id}")
            .then()
            .statusCode(anyOf(is(204), is(404)));
    }
}
