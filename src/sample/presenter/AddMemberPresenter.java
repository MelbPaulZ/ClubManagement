package sample.presenter;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import sample.bean.Member;
import sample.controller.AddMemberController;
import sample.managers.DBManager;

/**
 * Created by Paul on 10/4/17.
 */
public class AddMemberPresenter extends BasePresenter {
    private AddMemberController controller;
    private DBManager dbManager;
    public AddMemberPresenter(AddMemberController controller) {
        this.controller = controller;
        dbManager = DBManager.getInstance();
    }

    public void addMember(String memberName, String gender, String email, String phone){
        Member member = new Member();
        member.setMemberName(memberName);
        member.setGender(gender);
        member.setEmail(email);
        member.setPhone(phone);
        member.setMemberId("5");

        Alert alert;
        if (dbManager.insert(member)){
            alert = new Alert(Alert.AlertType.INFORMATION, "Success added new member",ButtonType.OK);
            alert.showAndWait();

            if (alert.getResult() == ButtonType.YES) {
                controller.cleanAllInputs();
            }
        }else{
            alert = new Alert(Alert.AlertType.ERROR, "Unable to add new member", ButtonType.OK);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES){
                controller.cleanAllInputs();
            }
        }
//        alert = new Alert(Alert.AlertType.ERROR, "Unable to add new member", ButtonType.OK);
//        alert.showAndWait();
//        if (alert.getResult() == ButtonType.YES){
//            controller.cleanAllInputs();
//        }


    }
}
