package br.unitins.topicos1.guitar.resource;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import static io.restassured.RestAssured.given;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class FornecedorResourceTest {

    @Test
    public void buscarTodosTest() {
        given()
            .when().get("/fornecedores")
            .then()
            .statusCode(200);
    }

    @Test
    public void buscarPorNomeTest() {
        given()
            .pathParam("nome", "Tagima Distribuidora")
            .when().get("/fornecedores/find/{nome}")
            .then()
            .statusCode(anyOf(is(200), is(404)));
    }

    @Test
    public void incluirTest() {
        String json = """
        {
            "nome": "Tagima Distribuidora",
            "cnpj": "12.345.678/0001-99",
            "razaoSocial": "Tagima Instrumentos Musicais LTDA"
        }
        """;

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(json)
            .when().post("/fornecedores")
            .then()
            .statusCode(anyOf(is(201), is(404)))
            .body("nome", equalTo("Tagima Distribuidora"))
            .body("cnpj", equalTo("12.345.678/0001-99"))
            .body("razaoSocial", equalTo("Tagima Instrumentos Musicais LTDA"));
    }

    @Test
    public void atualizarTest() {
        String json = """
        {
            "nome": "Fender Brasil",
            "cnpj": "98.765.432/0001-11",
            "razaoSocial": "Fender Musical Instruments LTDA"
        }
        """;

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(json)
            .pathParam("id", 1)
            .when().put("/fornecedores/{id}")
            .then()
            .statusCode(anyOf(is(204), is(404)));
    }

    @Test
    public void excluirTest() {
        given()
            .pathParam("id", 1)
            .when().delete("/fornecedores/{id}")
            .then()
            .statusCode(anyOf(is(204), is(404)));
    }
}
