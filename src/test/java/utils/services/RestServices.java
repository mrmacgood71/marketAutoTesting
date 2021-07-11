package utils.services;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.specification.RequestSpecification;
import utils.Specifiable;

public abstract class RestServices implements Specifiable {
    protected Cookies cookies;
    protected RequestSpecification REQ_SPECS;

    protected abstract String getBasePath();

    public RestServices(Cookies cookies) {
        this.cookies = cookies;
        REQ_SPECS = new RequestSpecBuilder()
                .addCookies(cookies)
                .setBaseUri(BASE_URL)
                .setBasePath(getBasePath())
                .setContentType(ContentType.JSON)
                .build();
    }
}
