package utils;

import pojos.UserPojo;
import pojos.UserPojoFull;

public class UserPojoFullBuilder {
    private String id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;

    public UserPojoFullBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public UserPojoFullBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserPojoFullBuilder setFirstName(String firstName) {
        this.first_name = firstName;
        return this;
    }

    public UserPojoFullBuilder setLastName(String lastName) {
        this.last_name = lastName;
        return this;
    }

    public UserPojoFullBuilder setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public UserPojoFull build() {
        return new UserPojoFull(id, email,first_name, last_name, avatar);
    }
}
