package org.example;

import com.google.gson.Gson;
import dto.OrderDtoTest;
import org.apache.http.HttpStatus;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ApiMockTest {
    @Test
    public void testWithBody() {
//        String requestBody = "{\n" +
//                "  \"status\": \"OPEN\",\n" +
//                "  \"courierId\": 0,\n" +
//                "  \"customerName\": \"string\",\n" +
//                "  \"customerPhone\": \"string\",\n" +
//                "  \"comment\": \"string\",\n" +
//                "  \"id\": 0\n" +
//                "}";

        // dto creation with constructor
        OrderDtoTest orderDtoTest = new OrderDtoTest("name", "123456", "comment");

        // dto creation with constructor by default and setter.
        OrderDtoTest orderDtoTestSetter = new OrderDtoTest();
        orderDtoTestSetter.setComment("new comment");
        orderDtoTestSetter.setCustomerPhone("21546212");
        orderDtoTestSetter.setCustomerName("Name");

        //serialization
        String orderDtoTestAsJson = new Gson().toJson(orderDtoTest);

        given()
                .header("Content-Type", "application/json")
                .body(orderDtoTest)
                .log()
                .all()
                .post(" http://51.250.6.164:8080/test-orders")
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_OK);

    }

}
