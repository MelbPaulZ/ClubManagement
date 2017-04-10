package sample.presenter;

import sample.managers.DBManager;
import sample.bean.User;
import sample.controller.LoginController;

/**
 * Created by Paul on 9/4/17.
 */
public class LoginPresenter extends BasePresenter {
    private DBManager dbManager;
    private LoginController loginController;

    public LoginPresenter(LoginController loginController) {
        dbManager = DBManager.getInstance();
        this.loginController = loginController;
    }

    public void signIn(String username, String password){
        User user = dbManager.login(username, password);
        if (user==null){
            loginController.loginFailure();
        }else{
            loginController.loginSuccess();
        }
    }
}
