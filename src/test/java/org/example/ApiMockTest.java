package org.example;

import org.apache.http.HttpStatus;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ApiMockTest {
    @Test
    public void testWithBody(){
        String requestBody = "{\n" +
                "  \"status\": \"OPEN\",\n" +
                "  \"courierId\": 0,\n" +
                "  \"customerName\": \"string\",\n" +
                "  \"customerPhone\": \"string\",\n" +
                "  \"comment\": \"string\",\n" +
                "  \"id\": 0\n" +
                "}";
        given().
                 header(" Content-Type:", "application/json")
                .body(requestBody)
                 .log()
                 .all()
                .post(" http://51.250.6.164:8080/test-orders")
                .then()
                 .log()
                 .all()
                .statusCode(HttpStatus.SC_OK);

    }

}
