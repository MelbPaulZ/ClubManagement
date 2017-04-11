package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import sample.presenter.ChangePasswordPresenter;
import sample.presenter.ChangeProfilePresenter;

/**
 * Created by Paul on 11/4/17.
 */
public class ChangeProfileController extends BaseController<ChangeProfilePresenter> {

    @FXML
    TextField newUserName;

    private ChangeProfilePresenter presenter;

    public ChangeProfileController() {
        presenter = createPresenter();
    }


    @FXML public void changeProfile(){
        boolean rst = presenter.changeProfile(newUserName.getText());
        if (rst){
            showAlert(Alert.AlertType.CONFIRMATION,"Update profile successfully");
        }else{
            showAlert("update profile failure");
        }
    }

    @FXML public void toMainPage(){
        switchToPage("view/MainPage.fxml");
    }

    @Override
    public ChangeProfilePresenter createPresenter() {
        return new ChangeProfilePresenter();
    }
}
