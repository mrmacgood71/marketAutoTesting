package utils.services;

import io.restassured.RestAssured;
import io.restassured.http.Cookies;
import pojos.UserRequest;
import pojos.CreateUserResponse;
import pojos.UserPojo;
import utils.Specifiable;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserService extends RestServices implements Specifiable {

    public UserService(Cookies cookies) {
        super(cookies);
    }

    @Override
    protected String getBasePath() {
        return "/users";
    }

    public CreateUserResponse createUserResponse(UserRequest userRequest) {
        return given()
                .body(userRequest)
                .post()
                .as(CreateUserResponse.class);
    }

    public List<UserPojo> getUsers() {
        return RestAssured
                .given()
                .spec(REQRES_USERS)
                .get()
                .jsonPath()
                .getList("data", UserPojo.class);
    }
}
