package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserPojo {
    private int id;
    private String email;

    public UserPojo(int id, String email) {
        this.id = id;
        this.email = email;
    }

}
