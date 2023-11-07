package org.example;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class PostTest {

    @Test
    void testPostWithSettersPositive() {

        OrderDto orderDto = new OrderDto();
        orderDto.setCustomerName("Michael Jackson");
        orderDto.setStatus("OPEN");
        orderDto.setCustomerPhone("1234-56789");
        orderDto.setComment("Excellent customer");
        orderDto.setCourierId(15);
        given()
                .baseUri("http://51.250.6.164:8080")
                .contentType(ContentType.JSON)
                .body(orderDto)
                .when()
                .post("/test-orders")
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    void testPostWithSettersNegative() {

        OrderDto orderDto = new OrderDto();
        orderDto.setCustomerName("Michael Jackson");
        orderDto.setStatus("NEW");
        orderDto.setCustomerPhone("1234-56789");
        orderDto.setComment("Excellent customer");
        orderDto.setCourierId(15);
        given()
                .baseUri("http://51.250.6.164:8080")
                .contentType(ContentType.JSON)
                .body(orderDto)
                .when()
                .post("/test-orders")
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }


    @Test
    void testPostWithConstructorParametersPositive() {

        OrderDto orderDto = new OrderDto("OPEN", 15, "Michael Jackson",
                "1234-56789", "Excellent customer");
        given()
                .baseUri("http://51.250.6.164:8080")
                .contentType(ContentType.JSON)
                .body(orderDto)
                .when()
                .post("/test-orders")
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    void testPostWithConstructorParametersNegative() {

        OrderDto orderDto = new OrderDto("closed", 15, "Michael Jackson",
                "1234-56789", "Excellent customer");
        given()
                .baseUri("http://51.250.6.164:8080")
                .contentType(ContentType.JSON)
                .body(orderDto)
                .when()
                .post("/test-orders")
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }

}
