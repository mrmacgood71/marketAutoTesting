package pojos;

public class UserBuilder {
   private String email;
   private int id;

   public UserBuilder setEmail(String email) {
       this.email = email;
       return this;
   }

   public UserBuilder setId(int id) {
       this.id = id;
       return this;
   }

   public UserPojo build() {
       return new UserPojo(id, email);
   }


}
