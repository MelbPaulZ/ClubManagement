package sample.controller;

import javafx.fxml.FXML;
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
        presenter.addMember(membername.getText(), gender.getText(), email.getText(), phone.getText());
    }

    @Override
    public AddMemberPresenter createPresenter() {
        return new AddMemberPresenter(this);
    }
}
