package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.managers.DBManager;
import sample.presenter.LoginPresenter;



public class LoginController extends BaseController<LoginPresenter>{
    private LoginPresenter loginPresenter;

    @FXML private TextField username;
    @FXML private PasswordField password;

    public LoginController() {
        loginPresenter = createPresenter();
    }

    @Override
    public LoginPresenter createPresenter() {
        return new LoginPresenter(this);
    }

    @FXML public void onClickSignin(ActionEvent actionEvent) {
        loginPresenter.signIn(username.getText(), password.getText());
    }

    public void start(){
        getStage().show();
    }

    public void loginSuccess(){

    }

    public void loginFailure(){

    }
}
