package org.example;

import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetTest {

    private Object Assert;

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 9, 10})
    public void testPositiveCases(int id) {


        Response response = given()
                .baseUri("http://51.250.6.164:8080")
                .contentType(ContentType.JSON)
                .log()
                .all()
                .when()
                .get("/test-orders/{id}", id)
                .then()
                .log()
                .all()
                //.statusCode(HttpStatus.SC_OK);
                .extract()
                .response();

        OrderDto receivedResult = new Gson().fromJson(response.asString(), OrderDto.class);

        assertAll(
                "Grouped Assertions of User",
                () -> Assertions.assertEquals(HttpStatus.SC_OK, response.getStatusCode(), "1rd Assert"),
                () -> Assertions.assertEquals("application/json", response.contentType(), "2nd Assert"),
                () -> Assertions.assertEquals(0, receivedResult.getCourierId(), "3rd Assert"),
                () -> Assertions.assertEquals("OPEN", receivedResult.getStatus(), "4th Assert")
        );
    }

    private void AssertAll() {
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 11, 15})
    public void testNegativeCases(int id) {

        Response response = given()
                .baseUri("http://51.250.6.164:8080")
                .contentType(ContentType.JSON)
                .log()
                .all()
                .when()
                .get("/test-orders/{id}", id)
                .then()
                .log()
                .all()
                //.statusCode(HttpStatus.SC_BAD_REQUEST);
                .extract()
                .response();

        Assertions.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusCode());
    }
}
