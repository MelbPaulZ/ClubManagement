package sample.presenter;

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
        boolean isSuccess = dbManager.insert(member);
        System.out.println(isSuccess);

    }
}
