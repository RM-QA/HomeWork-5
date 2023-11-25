package org.example;

import com.google.gson.Gson;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.example.CardValueMapper.getCardValue;

public class Blackjack {

    public static void main(String[] args) {

        String ace = "ACE";
        String queen = "QUEEN";

        Response response = given()
                .log()
                .all()
                .get("https://deckofcardsapi.com/api/deck/new/")
                .then()
                .log()
                .all()
                //  statusCode(HttpStatus.SC_OK);
                .extract()
                .response();
        // Deserialization
        DeckDto result = new Gson().fromJson(response.asString(), DeckDto.class);

        String deckId = result.getDeck_id();

        String urlForCards = "https://deckofcardsapi.com/api/deck/" + deckId + "/draw/?count=6";

        String urlForShuffling = "https://deckofcardsapi.com/api/deck/" + deckId + "/shuffle/";


        // for Drawing cards
        Response responseCards =
                given()
                        .log()
                        .all()
                        .get(urlForCards)
                        .then()
                        .log()
                        .all()
                        //  statusCode(HttpStatus.SC_OK);
                        .extract()
                        .response();

//        // for shuffling cards
        given()
                .log()
                .all()
                .get(urlForShuffling)
                .then()
                .log()
                .all();

        // Parse the JSON response using JsonPath
        JsonPath jsonPath = JsonPath.from(responseCards.asString());

        // Extract the ArrayList of "value"
        List<String> valuesList = jsonPath.get("cards.value");

        System.out.println("Value list = " + valuesList);

        // Convert ArrayList to String[]
        String[] values = valuesList.toArray(new String[0]);

        System.out.println("Queen: " + getCardValue("Queen"));

        System.out.println("ace: " + getCardValue(ace));

    }

}

