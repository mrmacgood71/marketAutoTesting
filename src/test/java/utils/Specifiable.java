package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public interface Specifiable {

    String BASE_URL = "https://reqres.in/api";

    RequestSpecification REQRES_USERS =
            new RequestSpecBuilder()
                    .setBaseUri(BASE_URL)
                    .setBasePath("/users")
                    .setContentType(ContentType.JSON)
                    .build();

}
