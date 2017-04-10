package sample.managers;

import sample.bean.User;

/**
 * Created by Paul on 9/4/17.
 */
public class UserManager {
    private static UserManager instance;
    private User user;

    private UserManager() {

    }

    public static UserManager getInstance() {
        if (instance == null){
            instance = new UserManager();
        }
        return instance;
    }


}
