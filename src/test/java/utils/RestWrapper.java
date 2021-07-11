package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.specification.RequestSpecification;
import pojos.UserRequest;
import pojos.CreateUserResponse;
import pojos.UserLogin;
import utils.services.OrderServices;
import utils.services.UserService;

import static io.restassured.RestAssured.given;

public class RestWrapper implements Specifiable {

    private static RequestSpecification REQ_SPECS;
    private Cookies cookies;
    public UserService user;
    public OrderServices order;

    private RestWrapper(Cookies cookies) {
        this.cookies = cookies;

        user = new UserService(cookies);
        order = new OrderServices(cookies);

    }

    public CreateUserResponse createUserResponse(UserRequest userRequest) {
        return given()
                .body(userRequest)
                .post()
                .as(CreateUserResponse.class);
    }

    public static RestWrapper loginAs(String login, String password) {
        Cookies cookies = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL)
                .basePath("/login")
                .body(new UserLogin(login, password))
                .post()
                .getDetailedCookies();

        return new RestWrapper(cookies);
    }
}
