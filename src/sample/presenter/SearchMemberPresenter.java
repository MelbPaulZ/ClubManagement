package sample.presenter;

import sample.controller.SearchMemberController;
import sample.managers.DBManager;
import sample.util.SqlUtil;

/**
 * Created by Paul on 10/4/17.
 */
public class SearchMemberPresenter extends BasePresenter {

    private DBManager dbManager;
    public SearchMemberPresenter() {
        dbManager = DBManager.getInstance();
    }

    public void searchMember(String str, int searchField){
        String searchSql;
        switch (searchField){
            case SearchMemberController.SEARCH_NAME:
                searchSql = "select * from member where memberName like " + SqlUtil.addQuotationForString(str);
                break;
            case SearchMemberController.SEARCH_EMAIL:
                searchSql = "select * from member where email like " + SqlUtil.addQuotationForString(str);
                break;
            case SearchMemberController.SEARCH_PHONE:
                searchSql = "select * from member where phone like " + SqlUtil.addQuotationForString(str);
                break;
        }



    }
}
