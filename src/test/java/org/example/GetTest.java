package org.example;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.restassured.RestAssured.given;

public class GetTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 9, 10})
    public void testPositiveCases(int id) {

        given()
                .baseUri("http://51.250.6.164:8080")
                .contentType(ContentType.JSON)
                .log()
                .all()
                .when()
                .get("/test-orders/{id}", id)
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_OK);

    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 11, 15})
    public void testNegativeCases(int id) {

        given()
                .baseUri("http://51.250.6.164:8080")
                .contentType(ContentType.JSON)
                .log()
                .all()
                .when()
                .get("/test-orders/{id}", id)
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }
}
