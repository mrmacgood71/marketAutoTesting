package rest;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pojos.UserRequest;
import pojos.CreateUserResponse;
import pojos.UserPojo;
import utils.RestWrapper;
import utils.Specifiable;
import utils.UserRequestGenerator;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class RestTests implements Specifiable {

    private static RestWrapper api;

    @BeforeTest
    public static void prepareUser() {
        api = new RestWrapper.loginAs("eve.holt@reqres.in","cityslicka");
    }


    @Test
    public void getUserByEmail() {
        given()
                .spec(REQRES_USERS)
                .when().get()
                .then()
                .statusCode(200)
                .body("data[0].email", equalTo("george.bluth@reqres.in"));
    }

    @Test
    public void getUserId() {
        given()
                .spec(REQRES_USERS)
                .when().get()
                .then()
                .statusCode(200)
                .body("data[3].id", equalTo(4));
    }

    @Test
    public void getUserIdWithFinder() {
        given()
                .spec(REQRES_USERS)
                .when().get()
                .then()
                .statusCode(200)
                .body("data.find{it.id == 2}.first_name", equalTo("Janet"));
    }

    @Test
    public void getUsers() {
        api.user.getUsers();
    }


    @Test
    public void getUserByEmailWithFinder() {
        given()
                .spec(REQRES_USERS)
                .when().get()
                .then()
                .statusCode(200)
                .body("data.find{it.email == 'george.bluth@reqres.in'}.last_name", equalTo("Bluth"));
    }

    @Test
    public void getJSONData() {
        List<UserPojo> emails = given()
                .spec(REQRES_USERS)
                .when().get()
                .then()
                .statusCode(200)
                .extract().jsonPath().getList("data", UserPojo.class);
    }

    @Test
    public void createUser() {
        UserRequest userRequest = UserRequestGenerator.getDefaultUser("root", "Admin");
        CreateUserResponse userResponse = api.user.createUserResponse(userRequest);


        Assert.assertNotNull(userResponse);
        Assert.assertEquals(userRequest.getName(), userResponse.getName());
    }
}
