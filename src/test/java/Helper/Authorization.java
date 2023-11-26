package Helper;

import com.google.gson.Gson;
import dto.LoggingDto;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Authorization {

    // this method help us to getToken everytime
    public static String getToken() {

        SetUpFunctions setupFunctions = new SetUpFunctions();
        LoggingDto login = new LoggingDto(setupFunctions.getUsername(), setupFunctions.getPassword(), setupFunctions.getBaseUrl());

        //serialization
        String LoginDtoAsJson = new Gson().toJson(login);

        Response response = given()
                .log()
                .all()
                .header("Content-Type", "application/json")
                .body(LoginDtoAsJson)
                .post("http://51.250.6.164:8080/login/student")
                .then()
                .extract()
                .response();

        return response.asString();
    }
}
