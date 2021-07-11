package steps;

import io.restassured.RestAssured;
import pojos.UserRequest;
import pojos.CreateUserResponse;
import pojos.UserPojo;
import utils.Specifiable;
import static io.restassured.RestAssured.*;
import java.util.List;

public class UsersSteps implements Specifiable {
    private CreateUserResponse user;

    public static List<UserPojo> getUsers() {
        return RestAssured
                .given()
                .spec(REQRES_USERS)
                .get()
                .jsonPath()
                .getList("data", UserPojo.class);
    }


    public CreateUserResponse createUserResponse(UserRequest userRequest) {
        user = given()
                .body(userRequest)
                .post()
                .as(CreateUserResponse.class);
        return user;
    }

    public UserPojo getUser() {
        return given().get("/" + user.getId()).as(UserPojo.class);
    }
}
