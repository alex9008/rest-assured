package test;

import api.CharactersDTO;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.JsonUtil;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class CharactersTest {

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI =  "https://gateway.marvel.com/v1/public";
    }

    @Test
    public void test_get_all_characters() {
        given()
                .queryParams(getQueryParams())
                .when().get("/characters")
                .then()
                .assertThat().statusCode(200);

        //Assertions.assertEquals(characters.getCode(), 200);

    }

    @Test
    public void test_get_all_characterss() {
        Response response =
                given()
                        .baseUri("https://gateway.marvel.com/v1/public")
                        .queryParams(getQueryParams())
                        .when().get("/characters")
                        .then()
                        .assertThat().statusCode(200)
                        .extract().response();

        CharactersDTO charactersDTO = JsonUtil.deserializeCamel(response.asString(), CharactersDTO.class);
        JsonPath jsonPath = new JsonPath(response.asString());
        Integer limit = jsonPath.get("data.limit");
        System.out.println("limit = " + limit);
        Assertions.assertEquals(limit, 20, "Verify limit");
        Assertions.assertEquals(charactersDTO.getCopyright(), "© 2022 MARVEL", "Verify coyright");
    }

    private Map<String, String> getQueryParams() {
        Map<String, String> params = new HashMap<>();
        params.put("apikey", "d30d0f73daa5ca5000f81db5d2958e79");
        params.put("hash", "8052bf42b3a0c30a18af1e8bf3a2fbd6");
        params.put("ts", "1");
        return params;
    }

}
