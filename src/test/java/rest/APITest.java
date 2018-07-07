package rest;

import domain.Person;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import static org.hamcrest.CoreMatchers.*;
import org.testng.annotations.BeforeMethod;

public class APITest {

    @BeforeMethod
    public void setup() {
        baseURI = "http://localhost";
        port = 4567;
        basePath = "/api/v1/";

        RestAssured.defaultParser = Parser.JSON;
    }

    @Test
    public void apiTest() {
    }

    @Test
    public void inserirPessoa() {
        given()
           .contentType(ContentType.JSON)
           .body(new Person("John Doe", "Unknow", "Nothing"))
           .when()
              .post("person")
           .then()
              .body("name", equalTo("John Doe")).and()
              .body("address", equalTo("Unknow")).and()
              .body("hobbies", equalTo("Nothing")).and()
              .statusCode(201);
    }

    @Test
    public void validarPessoa() {
        when()
          .get("person/{id}", "101")
          .then()
             .contentType(ContentType.JSON).and()
             .body("id", equalTo(101)).and()
             .body("name", equalTo("Fernando Schwambach")).and()
             .body("address", equalTo("Rio do Sul, SC")).and()
             .body("hobbies", equalTo("Animes, livros")).and()
             .statusCode(200);

    }

    @Test
    public void removerPessoa() {
        int id =
           given()
              .contentType(ContentType.JSON)
              .body(new Person("John Doe", "Unknow", "Nothing"))
              .when()
                 .post("person")
              .then()
                 .extract()
                     .path("id");

        when()
          .delete("person/{id}", id)
        .then()
          .body("statusMessage", equalTo("success")).and()
          .body("message", equalTo("Person removed!")).and()
          .statusCode(202);

    }

    @Test
    public void alterarPessoa() {
        int id =
           given()
              .contentType(ContentType.JSON)
              .body(new Person("Marie Doe", "Unknow", "Nothing"))
              .when()
                 .post("person")
              .then()
                 .extract()
                 .path("id");

        given()
           .contentType(ContentType.JSON)
           .body(new Person("Marie Doe 2", "Unknow", "Nothing"))
           .when()
              .put("person/{id}", id)
           .then()
              .body("id", equalTo(id)).and()
              .body("name", equalTo("Marie Doe 2")).and()
              .body("address", equalTo("Unknow")).and()
              .body("hobbies", equalTo("Nothing")).and()
              .statusCode(200);

    }
}
