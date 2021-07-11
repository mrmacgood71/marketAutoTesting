package utils.services;

import io.restassured.RestAssured;
import io.restassured.http.Cookies;
import org.testng.annotations.Test;
import pojos.UserPojo;
import utils.Specifiable;

import java.util.List;

public class OrderServices extends RestServices implements Specifiable {

    @Override
    protected String getBasePath() {
        return "/orders";
    }

    public OrderServices(Cookies cookies) {
        super(cookies);
    }

    public List<UserPojo> getOrders() {
        return RestAssured
                .given()
                .spec(REQRES_USERS)
                .get()
                .jsonPath()
                .getList("data", UserPojo.class);
    }
}
