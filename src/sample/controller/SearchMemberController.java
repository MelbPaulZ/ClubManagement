package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import sample.presenter.SearchMemberPresenter;

/**
 * Created by Paul on 10/4/17.
 */
public class SearchMemberController extends BaseController<SearchMemberPresenter> {

    private SearchMemberPresenter presenter;
    private int searchKey;
    public final static int SEARCH_NAME = 100;
    public final static int SEARCH_EMAIL = 101;
    public final static int SEARCH_PHONE = 102;
    @FXML public TableView searchResult;
    @FXML public TextField memberName, email, phone;

    public SearchMemberController() {
        presenter = createPresenter();
    }

    @FXML private void initialize(){
        TableColumn firstNameCol = new TableColumn("Name");
        TableColumn emailCol = new TableColumn("Email");
        TableColumn phoneCol = new TableColumn("phone");
        searchResult.getColumns().addAll(firstNameCol, emailCol, phoneCol);
    }

    @Override
    public SearchMemberPresenter createPresenter() {
        return new SearchMemberPresenter();
    }

    @FXML public void toMainPage(){
        switchToPage("view/MainPage.fxml");
    }

    @FXML public void searchMember(){
        if (!memberName.getText().equals("")){
            searchKey = SEARCH_NAME;
            presenter.searchMember(memberName.getText(), SEARCH_NAME);
        }else if (!email.getText().equals("")){
            searchKey = SEARCH_EMAIL;
            presenter.searchMember(email.getText(), SEARCH_EMAIL);
        }else if (!phone.getText().equals("")){
            searchKey = SEARCH_PHONE;
            presenter.searchMember(phone.getText(), SEARCH_PHONE);
        }



    }


}
