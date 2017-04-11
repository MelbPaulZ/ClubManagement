package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import sample.presenter.AddMemberPresenter;
import sample.presenter.MainPresenter;

/**
 * Created by Paul on 10/4/17.
 */
public class AddMemberController extends BaseController<AddMemberPresenter> {

    private AddMemberPresenter presenter;

    @FXML TextField membername;
    @FXML TextField gender;
    @FXML TextField email;
    @FXML TextField phone;

    public AddMemberController() {
        presenter = createPresenter();
    }

    @FXML
    public void toMainPage(){
        switchToPage("view/MainPage.fxml");
    }

    @FXML
    public void addMember(){
        boolean rst = presenter.addMember(membername.getText(), gender.getText(), email.getText(), phone.getText());
        if (rst){
            showAlert(Alert.AlertType.INFORMATION, "Success added new member");
        }else{
            showAlert(Alert.AlertType.ERROR, "Unable to add new member");
        }
    }


    @Override
    protected void showAlert(Alert.AlertType alertType, String msg) {
        Alert alert = new Alert(alertType, msg, ButtonType.OK);
        alert.showAndWait();
        if (alert.getResult() == ButtonType.OK){
            cleanAllInputs();
        }

    }

    @Override
    public AddMemberPresenter createPresenter() {
        return new AddMemberPresenter(this);
    }

    public void cleanAllInputs(){
        membername.clear();
        gender.clear();
        email.clear();
        phone.clear();
    }
}
