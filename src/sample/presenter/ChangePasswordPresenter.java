package sample.presenter;

import sample.controller.ChangePasswordController;
import sample.managers.DBManager;
import sample.managers.UserManager;

/**
 * Created by Paul on 11/4/17.
 */
public class ChangePasswordPresenter extends BasePresenter {
    private ChangePasswordController controller;
    private DBManager dbManager;
    public ChangePasswordPresenter(ChangePasswordController controller) {
        this.controller = controller;
        dbManager = DBManager.getInstance();
    }

    public boolean changePassword(String newPassword){
        String userId = UserManager.getInstance().getUser().getUserId();
        boolean rst = dbManager.changePassword(newPassword, userId);
        if (rst){ // update userManager info
            UserManager.getInstance().reloadUserInfoFromDB();
        }
        return rst;
    }
}
