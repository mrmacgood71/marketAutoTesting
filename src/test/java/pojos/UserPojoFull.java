package pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserPojoFull {
    private String id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;


    public UserPojoFull (String id, String email, String first_name, String last_name, String avatar) {
    }
}
