package pojos;

public class UserRequest {
    private String name;
    private String job;

    public UserRequest(){

    }

    public UserRequest(String name, String job) {
        this.name = name;
        this.job = job;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setJob(String job) {
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }
}
