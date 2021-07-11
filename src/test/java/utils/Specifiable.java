package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public interface RequestSpecs {

        public static final RequestSpecification REQRES =
            new RequestSpecBuilder()
                    .setBaseUri("https://reqres.in/api")
                    .setBasePath("/users")
                    .setContentType(ContentType.JSON)
                    .build();


}
