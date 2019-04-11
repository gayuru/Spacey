package Model.Users;

import java.util.ArrayList;

public abstract class User {
    private String userId;
    private String userName;


    public User(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }
}
