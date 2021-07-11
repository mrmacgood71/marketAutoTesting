package utils;

import pojos.UserRequest;

public class CreateUserRequestBuilder {
    private String name;
    private String job;

    public CreateUserRequestBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CreateUserRequestBuilder setJob(String job) {
        this.job = job;
        return this;
    }

    public UserRequest build() {
        return new UserRequest(name, job);
    }
}
