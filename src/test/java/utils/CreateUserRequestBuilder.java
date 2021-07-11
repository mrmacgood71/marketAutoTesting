package pojos;

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

    public CreateUserRequest build() {
        return new CreateUserRequest(name, job);
    }
}
