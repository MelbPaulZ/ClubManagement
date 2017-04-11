package sample.presenter;

import sample.managers.DBManager;
import sample.managers.UserManager;

/**
 * Created by Paul on 11/4/17.
 */
public class ChangeProfilePresenter extends BasePresenter{
    private DBManager dbManager;
    public ChangeProfilePresenter() {
        dbManager = DBManager.getInstance();
    }

    public boolean changeProfile(String userName){
        String userId = UserManager.getInstance().getUser().getUserId();
        boolean rst =  dbManager.changeUserName(userName, userId);
        if (rst){
            UserManager.getInstance().reloadUserInfoFromDB();
        }
        return rst;
    }
}
