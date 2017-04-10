package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.presenter.BasePresenter;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Paul on 10/4/17.
 */
public class SearchMemberController extends BaseController<BasePresenter> {


    @FXML public TableView searchResult;

    @FXML private void initialize(){
        TableColumn firstNameCol = new TableColumn("Name");
        TableColumn emailCol = new TableColumn("Email");
        TableColumn phoneCol = new TableColumn("phone");
        searchResult.getColumns().addAll(firstNameCol, emailCol, phoneCol);
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @FXML public void toMainPage(){
        switchToPage("view/MainPage.fxml");
    }


}
