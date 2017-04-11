package sample.managers;

import sample.bean.User;

/**
 * Created by Paul on 9/4/17.
 */
public class UserManager {
    private static UserManager instance;
    private User user;

    private UserManager() {
        mockData();
    }

    public static UserManager getInstance() {
        if (instance == null){
            instance = new UserManager();
        }
        return instance;
    }

    private void mockData(){
        user = new User("admin", "admin", "1");
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void reloadUserInfoFromDB(){
        DBManager dbManager = DBManager.getInstance();
        user = dbManager.getUser(user.getUserId());

    }
}
