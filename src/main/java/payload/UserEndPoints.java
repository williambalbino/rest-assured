package payload;

import dto.User;
import endpoints.Routes;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

public class UserEndPoints {

    static ResourceBundle getUrl() {
        return ResourceBundle.getBundle("routes");
    }

    public static Response createUserByPropertiesFIle(User payload){

        String post_url = getUrl().getString("post_url");

        Response response = given()
                .log().all()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(post_url);

        return response;
    }


    public static Response createUser(User payload){
        Response response = given()
                .log().all()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
        .when()
                .post(Routes.POST_URL);

        return response;
    }

    public static Response readUser(String userName){
        Response response = given()
                .pathParam("username", userName)
        .when()
                .get(Routes.GET_URL);

        return response;

    }

    public static Response updateUser(User payload, String userName){
        Response response = given()
                .pathParam("username", userName)
                .log().all()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
        .when()
                .put(Routes.PUT_URL);

        return response;
    }

    public static Response deleteUser(String userName){
        Response response = given()
                .pathParam("username", userName)
                .when()
                .delete(Routes.DELETE_URL);

        return response;
    }

}
