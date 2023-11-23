package org.example;

import com.google.gson.Gson;
import dto.OrderDtoTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PostTest {

    @Test
    void testPostWithSettersPositive() {

        OrderDto orderDto = new OrderDto();
        orderDto.setCustomerName("Michael Jackson");
        orderDto.setStatus("OPEN");
        orderDto.setCustomerPhone("1234-56789");
        orderDto.setComment("Excellent customer");
        orderDto.setCourierId(15);

        Response response = given()
                .baseUri("http://51.250.6.164:8080")
                .contentType(ContentType.JSON)
                .body(orderDto)
                .when()
                .post("/test-orders")
                .then()
                .log()
                .all()
                //.statusCode(HttpStatus.SC_OK);
                .extract()
                .response();

        //deserialization
        OrderDtoTest receivedResult = new Gson().fromJson(response.asString(), OrderDtoTest.class);

        assertAll(
                "Grouped Assertions of User",
                () -> Assertions.assertEquals("OPEN", receivedResult.getStatus(), "1nd Assert"),
                () -> Assertions.assertEquals(HttpStatus.SC_OK, response.getStatusCode(), "2rd Assert"),
                () -> Assertions.assertEquals(15, receivedResult.getCourierId(), "3rd Assert")
        );

    }

    @Test
    void testPostWithSettersNegative() {

        OrderDto orderDto = new OrderDto();
        orderDto.setCustomerName("Michael Jackson");
        orderDto.setStatus("NEW");
        orderDto.setCustomerPhone("1234-56789");
        orderDto.setComment("Excellent customer");
        orderDto.setCourierId(15);

        Response response = given()
                .baseUri("http://51.250.6.164:8080")
                .contentType(ContentType.JSON)
                .body(orderDto)
                .when()
                .post("/test-orders")
                .then()
                .log()
                .all()
                // .statusCode(HttpStatus.SC_BAD_REQUEST);
                .extract()
                .response();

        // No deserialization and assertAll-> bad request (No response body)

        Assertions.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusCode());

    }

    @Test
    void testPostWithConstructorParametersPositive() {

        OrderDto orderDto = new OrderDto("OPEN", 15, "Michael Jackson",
                "1234-56789", "Excellent customer");
        Response response = given()
                .baseUri("http://51.250.6.164:8080")
                .contentType(ContentType.JSON)
                .body(orderDto)
                .when()
                .post("/test-orders")
                .then()
                .log()
                .all()
                //.statusCode(HttpStatus.SC_OK);
                .extract()
                .response();

        OrderDtoTest receivedResult = new Gson().fromJson(response.asString(), OrderDtoTest.class);

        assertAll(
                "Grouped Assertions of User",
                () -> Assertions.assertEquals("Excellent customer", receivedResult.getComment(), "1nd Assert"),
                () -> Assertions.assertEquals(HttpStatus.SC_OK, response.getStatusCode(), "2rd Assert"),
                () -> Assertions.assertEquals("Michael Jackson", receivedResult.getCustomerName(), "3rd Assert")
        );


    }

    @Test
    void testPostWithConstructorParametersNegative() {

        OrderDto orderDto = new OrderDto("closed", 15, "Michael Jackson",
                "1234-56789", "Excellent customer");
        Response response = given()
                .baseUri("http://51.250.6.164:8080")
                .contentType(ContentType.JSON)
                .body(orderDto)
                .when()
                .post("/test-orders")
                .then()
                .log()
                .all()
                //.statusCode(HttpStatus.SC_BAD_REQUEST);
                .extract()
                .response();

        Assertions.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusCode());

    }
}
