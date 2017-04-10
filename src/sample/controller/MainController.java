package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import sample.bean.User;
import sample.managers.UserManager;
import sample.presenter.BasePresenter;

/**
 * Created by Paul on 10/4/17.
 */
public class MainController extends BaseController{

    public MainController() {

    }

    @FXML Text greeting;

    @FXML private void initialize(){
        User user = UserManager.getInstance().getUser();
        String str = greeting.getText().concat(user.getUserName());
        greeting.setText(str);
    }

    @FXML public void toAddNewMemberPage(){
        switchToPage("view/AddMemberPage.fxml");
    }

    @FXML public void toSearchMemberPage(){
        switchToPage("view/ManageMemberPage.fxml");
    }


    @FXML public void toSettingPage(){

    }

    @FXML public void logout(){

    }



    @Override
    public BasePresenter createPresenter() {
        return null;
    }



}
