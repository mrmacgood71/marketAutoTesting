package utils;

import pojos.UserRequest;

public class UserRequestGenerator {

    public static UserRequest getDefaultUser() {
        return new CreateUserRequestBuilder()
                .setName("name")
                .setJob("job")
                .build();
    }

    public static UserRequest getDefaultUser(String name, String job) {
        return new CreateUserRequestBuilder()
                .setName(name)
                .setJob(job)
                .build();
    }
}
