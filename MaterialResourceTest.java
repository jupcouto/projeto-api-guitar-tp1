package br.unitins.topicos1.guitar.resource;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import static io.restassured.RestAssured.given;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class MaterialResourceTest {

    @Test
    public void buscarTodosTest() {
        given()
            .when().get("/materiais")
            .then()
            .statusCode(200);
    }

    @Test
    public void buscarPorDescricaoTest() {
        given()
            .pathParam("descricao", "Madeira")
            .when().get("/materiais/find/{descricao}")
            .then()
            .statusCode(anyOf(is(200), is(404))); // pode não existir no banco
    }

    @Test
    public void incluirTest() {
        String json = """
        {
            "descricao": "Madeira Nobre"
        }
        """;

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(json)
            .when().post("/materiais")
            .then()
            .statusCode(201)
            .body("descricao", equalTo("Madeira Nobre"));
    }

    @Test
    public void atualizarTest() {
        String json = """
        {
            "descricao": "Madeira Atualizada"
        }
        """;

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(json)
            .pathParam("id", 1)
            .when().put("/materiais/{id}")
            .then()
            .statusCode(anyOf(is(204), is(404)));
    }

    @Test
    public void excluirTest() {
        given()
            .pathParam("id", 1)
            .when().delete("/materiais/{id}")
            .then()
            .statusCode(anyOf(is(204), is(404)));
    }
}
