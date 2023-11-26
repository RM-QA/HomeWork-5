package org.example;

import Helper.SetUpFunctions;
import com.google.gson.Gson;
import dto.LoggingDto;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class LoggingFeaturesTest {
    static SetUpFunctions setupFunctions;

    @BeforeAll
    public static void setUp() {
        setupFunctions = new SetUpFunctions();
        System.out.println("username" + setupFunctions.getUsername());
        System.out.println("password" + setupFunctions.getPassword());
    }

    @Test
    public void successfulLoginTest() {

        //creating the instance of the login dto class
        LoggingDto login = new LoggingDto(setupFunctions.getUsername(), setupFunctions.getPassword(), setupFunctions.getBaseUrl());

        // Serialization
        String LoginDtoAsJson = new Gson().toJson(login);

        Response response = given()
                .log()
                .all()
                .header("Content-Type", "application/json")
                //.header ("Bearer Token", "TOKEN_VALUE")
                .body(LoginDtoAsJson)
                .post("http://51.250.6.164:8080/login/student")
                .then()
                .log()
                .all()
                //.and()
                //.assertThat()
                //statusCode(HttpStatus.SC_OK);
                .extract()
                .response();

        Assertions.assertNotNull(response.getBody());

        //Assertions.assertEquals( "", response.asString());
        //Assertions.assertEquals( 401, response.getStatusCode());
    }


    @Test
    public void unsuccessfulLoginTest() {

        LoggingDto login = new LoggingDto("rehab", "p5Twdy7", "http://51.250.6.164:8080");

        String loggingDtoAsJson = new Gson().toJson(login);

        given()
                .header("Content-Type", "application/json")
                .body(loggingDtoAsJson)
                .log()
                .all()
                .post("http://51.250.6.164:8080/login/student")
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_UNAUTHORIZED);
    }
}
