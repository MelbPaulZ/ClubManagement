package sample.model;

import sample.controller.LoginController;

/**
 * Created by Paul on 10/4/17.
 */
public class Login extends BaseModel<LoginController>{

    public Login(LoginController controller) {
        super(controller);
    }

    public void start(){
        controller.start();
    }
}
