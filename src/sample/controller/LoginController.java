package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.managers.DBManager;
import sample.managers.UserManager;
import sample.presenter.LoginPresenter;



public class LoginController extends BaseController<LoginPresenter>{
    private LoginPresenter loginPresenter;

    @FXML private TextField username;
    @FXML private PasswordField password;

    public LoginController() {
        loginPresenter = createPresenter();
    }

    @FXML
    public void initialize(){
        DBManager.getInstance();
    }

    @Override
    public LoginPresenter createPresenter() {
        return new LoginPresenter(this);
    }

    @FXML public void onClickSignin(ActionEvent actionEvent) {
        loginPresenter.signIn(username.getText(), password.getText());
    }

    @FXML public void onClickSignup(){
        loginPresenter.signUp(username.getText(), password.getText());
    }

    public void start(){
        getStage().show();
    }

    public void loginSuccess(){
        switchToPage("view/MainPage.fxml");
    }

    public void loginFailure(){
        showAlert("Login failure, please try again");
    }

    public void signupSuccess(){
        showAlert("Sign up success, please login");
    }

    public void signupFailure(){
        showAlert("Sign up failure, please try again");
    }

}
