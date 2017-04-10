package sample.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sample.Main;
import sample.presenter.BasePresenter;

import java.io.IOException;

/**
 * Created by Paul on 9/4/17.
 */
public abstract class BaseController<P extends BasePresenter> {
    private Stage stage;

    public BaseController() {

    }

    public abstract P createPresenter();

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void switchToPage(String url){
        FXMLLoader loader = new FXMLLoader(Main.class.getResource(url));
        GridPane root = null;
        try {
            root = loader.load();
            ((BaseController)loader.getController()).setStage(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.getScene().setRoot(root);
        stage.show();
    }
}
