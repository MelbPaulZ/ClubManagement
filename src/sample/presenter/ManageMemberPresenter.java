package sample.presenter;

import sample.bean.Member;
import sample.controller.ManageMemberController;
import sample.managers.DBManager;

import java.util.List;

/**
 * Created by Paul on 10/4/17.
 */
public class ManageMemberPresenter extends BasePresenter {

    private DBManager dbManager;
    private ManageMemberController controller;
    public ManageMemberPresenter(ManageMemberController controller) {
        dbManager = DBManager.getInstance();
        this.controller = controller;
    }

    public void searchMember(String str, int searchField){
        List<Member> memberList = null;
        switch (searchField){
            case ManageMemberController.SEARCH_NAME:
                memberList = dbManager.searchMemberByName(str);
                break;
            case ManageMemberController.SEARCH_EMAIL:
                memberList = dbManager.searchMemberByEmail(str);
                break;
            case ManageMemberController.SEARCH_PHONE:
                memberList = dbManager.searchMemberByPhone(str);
                break;
        }
        if (memberList!=null){
            controller.setDisplayDataList(memberList);
        }
    }

    public boolean deleteMember(Member member){
        return dbManager.delete(member);
    }

    public List<Member> getAllMembers(){
        return dbManager.getAllMembers();
    }
}
