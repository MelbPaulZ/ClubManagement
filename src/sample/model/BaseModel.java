package sample.model;

import sample.controller.BaseController;

/**
 * Created by Paul on 10/4/17.
 */
public class BaseModel<C extends BaseController> {
    protected C controller;
    public BaseModel(C controller) {
        this.controller = controller;
    }
}
