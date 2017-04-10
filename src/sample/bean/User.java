package sample.bean;

import java.io.Serializable;

/**
 * Created by Paul on 9/4/17.
 */
public class User implements Serializable{
    private String userName;
    private String password;
    private String userId;

    public User() {
    }

    public User(String userName, String password, String userId) {
        this.userName = userName;
        this.password = password;
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
