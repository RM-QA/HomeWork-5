package org.example;

import Helper.Authorization;
import com.google.gson.Gson;
import dto.LoggingDto;
import dto.OrderDtoTest;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class OrderCreation {
    static String token;

    @BeforeAll
    public static void setUp() {

        token = Authorization.getToken();
        System.out.println(token);
        System.out.println("this is token befor all this code" + token);
    }

    @Test
    public void OrderCreation() {

        OrderDtoTest orderDto = new OrderDtoTest("New customer", "12345678", "call before arrive");

        String orderDtoAsJson = new Gson().toJson(orderDto);

        given()
                .header("Content-Type", "application/json")
                //.header("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJyZWhhYiIsImV4cCI6MTcwMTAzNjg1OSwiaWF0IjoxNzAxMDE4ODU5fQ.yolgoCvpp2zYOIEVWgvGUx9x0EszEuqD-AggsBpVhRXIu2UKuRXwJEw1c8McIMnreX800fZikPim4FdKLUuWaA")
                .header("Authorization", "Bearer " + token)
                .body(orderDtoAsJson)
                .log()
                .all()
                .post("http://51.250.6.164:8080/orders")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void getOrderById() {

        given()
                .header("Content-Type", "application/json")
                //.header("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJyZWhhYiIsImV4cCI6MTcwMTAzNjg1OSwiaWF0IjoxNzAxMDE4ODU5fQ.yolgoCvpp2zYOIEVWgvGUx9x0EszEuqD-AggsBpVhRXIu2UKuRXwJEw1c8McIMnreX800fZikPim4FdKLUuWaA")
                .header("Authorization", "Bearer " + token)
                .log()
                .all()
                .get("http://51.250.6.164:8080/orders/5067")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }
}
