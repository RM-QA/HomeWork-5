package org.example;

import Helper.SetUpFunctions;
import com.google.gson.Gson;
import dto.LoggingDto;
import dto.OrderDtoTest;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class LoggingFeaturesTest {
    static SetUpFunctions setupFunctions;

    @BeforeAll


    public static void setUp() {
        SetUpFunctions setUpFunctions = new SetUpFunctions();
        System.out.println("username" + setUpFunctions.getUsername());
        System.out.println("password" + setUpFunctions.getPassword());
    }

    @Test

    public void successfulLoginTest() {

        //creating the instance of the login dto class
        LoggingDto login = new LoggingDto(setupFunctions.getUsername(), setupFunctions.getPassword());
        // Serialization
        String LoginDtoAsJson = new Gson().toJson(login);

        given().
                log().
                all().
                header("Content-Type", "application/json").
                // header ("Bearer Token", "TOKEN_VALUE").
                        body(LoginDtoAsJson).
                post("http://51.250.6.164:8080/login/student").
                then().
                log().
                all().
                assertThat().
                statusCode(HttpStatus.SC_OK);
    }


    @Test

    public void unsuccessfulLoginTest() {

        LoggingDto login = new LoggingDto("rehab", "p5Twdy7");

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
