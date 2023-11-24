package org.example;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.restassured.RestAssured.given;

public class OrderControllerTest {
    @Test
    public void successGettingOrder() {
        given()
                .log()
                .all()
                .when()
                .get("http://51.250.6.164:8080/test-orders/5")
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void negativeGettingOrder() {
        given()
                .log()
                .all()
                .when()
                .log()
                .all()
                .get("http://51.250.6.164:8080/test-orders/15")
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }


    @ParameterizedTest
    @ValueSource(ints = {1,2,5,9,10})
    public void successGettingOrderAndCheckResponseCode(int orderId) {
        String URL = "http://51.250.6.164:8080/test-orders/" + orderId;

        given()
                .log()
                .all()
                .when()
                .get(URL)
                // other way to provide the URL is ( the best wat)
                // .get("http://51.250.6.164:8080/test-orders/{orderId}, orderId) without line number (41)
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_OK);
    }
}