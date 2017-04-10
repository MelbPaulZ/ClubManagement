package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import sample.Main;
import sample.presenter.BasePresenter;
import sample.presenter.MainPresenter;

import java.io.IOException;
import java.net.URL;

/**
 * Created by Paul on 10/4/17.
 */
public class MainController extends BaseController{

    public MainController() {

    }


    @FXML Text greeting;

    @FXML public void toAddNewMemberPage(){
        switchToPage("view/AddMemberPage.fxml");
    }

    @FXML public void toSearchMemberPage(){

    }

    @FXML public void toViewAllMembersPage(){

    }

    @FXML public void toDeleteMemberPage(){

    }

    @FXML public void toSettingPage(){

    }

    @FXML public void logout(){

    }

    @FXML public void toMainPage(){
        switchToPage("view/MainPage.fxml");
    }


    @Override
    public BasePresenter createPresenter() {
        return null;
    }



}
