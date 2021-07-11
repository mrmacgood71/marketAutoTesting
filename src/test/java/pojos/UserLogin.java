package pojos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class UserLogin {
    private String login;
    private String password;

    public UserLogin(String login, String password) {
    }
}
