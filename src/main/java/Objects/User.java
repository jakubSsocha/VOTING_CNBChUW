package Objects;

public class User {

    private int user_id;
    private String user_username;
    private String user_email;
    private String user_password;
    private String status;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_username() {
        return user_username;
    }

    public void setUser_username(String user_username) {
        this.user_username = user_username;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User(String user_username, String user_email, String user_password, String status) {
        this.user_username = user_username;
        this.user_email = user_email;
        this.user_password = user_password;
        this.status = status;
    }

    public User(){
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_username='" + user_username + '\'' +
                ", user_email='" + user_email + '\'' +
                ", user_password='" + user_password + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
