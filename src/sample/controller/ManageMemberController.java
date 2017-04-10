package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.bean.Member;
import sample.presenter.ManageMemberPresenter;

import java.util.List;

/**
 * Created by Paul on 10/4/17.
 */
public class ManageMemberController extends BaseController<ManageMemberPresenter> {

    private ManageMemberPresenter presenter;
    private int searchKey;
    public final static int SEARCH_NAME = 100;
    public final static int SEARCH_EMAIL = 101;
    public final static int SEARCH_PHONE = 102;
    @FXML public TableView<Member> searchResult;
    private TableColumn nameCol, emailCol, phoneCol;
    private ObservableList<Member> data = FXCollections.observableArrayList();
    @FXML public TextField memberName, email, phone;

    public ManageMemberController() {
        presenter = createPresenter();
    }

    @FXML private void initialize(){
        nameCol = new TableColumn("Name");
        nameCol.setMinWidth(100);
        emailCol = new TableColumn("Email");
        emailCol.setMinWidth(150);
        phoneCol = new TableColumn("phone");
        phoneCol.setMinWidth(200);
        nameCol.setCellValueFactory(new PropertyValueFactory<Member, String>("memberName"));
        emailCol.setCellValueFactory(new PropertyValueFactory<Member, String>("email"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<Member, String>("phone"));
        data = FXCollections.observableArrayList(presenter.getAllMembers());
        searchResult.setItems(data);
        searchResult.getColumns().addAll(nameCol, emailCol, phoneCol);

    }

    @Override
    public ManageMemberPresenter createPresenter() {
        return new ManageMemberPresenter(this);
    }

    @FXML public void toMainPage(){
        switchToPage("view/MainPage.fxml");
    }

    @FXML public void searchMember(){
        data.clear();
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

    @FXML public void viewAllMembers(){
        clearAllInputs();
        data = FXCollections.observableArrayList(presenter.getAllMembers());
        searchResult.setItems(data);
    }


    @FXML public void deleteMember(){
        Member member = searchResult.getSelectionModel().getSelectedItem();
        if (member == null){
            return ;
        }
        presenter.deleteMember(member);
    }

    public void setDisplayDataList(List<Member> memberList){
        data = FXCollections.observableArrayList(memberList);
        searchResult.setItems(data);
    }


    private void clearAllInputs(){
        memberName.clear();
        email.clear();
        phone.clear();
    }


}
