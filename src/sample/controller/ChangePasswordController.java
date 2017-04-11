package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.managers.UserManager;
import sample.presenter.ChangePasswordPresenter;

/**
 * Created by Paul on 11/4/17.
 */
public class ChangePasswordController extends BaseController<ChangePasswordPresenter> {

    @FXML
    PasswordField oldPassword;

    @FXML PasswordField newPassword;

    @FXML PasswordField confirmPassword;

    private ChangePasswordPresenter presenter;


    public ChangePasswordController() {
        presenter = createPresenter();
    }

    @FXML public void toMainPage(){
        switchToPage("view/MainPage.fxml");
    }

    @FXML public void changePassword(){
        if (!oldPassword.getText().equals(UserManager.getInstance().getUser().getPassword())){
            showAlert("Old Password not correct, please try again!");
            return;
        }else if (!newPassword.getText().equals(confirmPassword.getText())){
            showAlert("Two passwords are not same, please try again!");
            return;
        }

        boolean rst = presenter.changePassword(newPassword.getText());
        if (rst){
            showAlert(Alert.AlertType.CONFIRMATION,"Change password successfully");
        }else{
            showAlert("Change password failure, please try again");
        }

    }


    @Override
    public ChangePasswordPresenter createPresenter() {
        return new ChangePasswordPresenter(this);
    }


}
