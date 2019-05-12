package Model.Users;

import java.io.Serializable;

public abstract class User implements Serializable {
    private String userId;
    private String userName;
    private String password;


    public User(String userId,String userName,String password) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return String.format("User ID: %s \n Name: %s ", this.getUserId(),this.getUserName());
    }
}
