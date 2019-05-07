package Model.Users;

import java.io.Serializable;

public abstract class User implements Serializable {
    private String userId;
    private String userName;


    public User(String userId,String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }


    @Override
    public String toString() {
        return String.format("User ID: %s \n Name: %s ", this.getUserId(),this.getUserName());
    }
}
