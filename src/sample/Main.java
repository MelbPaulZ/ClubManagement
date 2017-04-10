package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.controller.MainController;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

//        FXMLLoader fxmlLoader = new FXMLLoader();
//        Parent root = fxmlLoader.load(getClass().getResource("LoginPage.fxml").openStream());
//        LoginController loginController = fxmlLoader.getController();
//        loginController.setStage(primaryStage);
//        Login login = new Login(loginController);
//
//        primaryStage.setTitle("Club Management System");
//        primaryStage.setScene(new Scene(root, 500, 500));
//        login.start();


        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root1 = fxmlLoader.load(getClass().getResource("view/MainPage.fxml").openStream());
        MainController mainController = fxmlLoader.getController();
        mainController.setStage(primaryStage);
        primaryStage.setScene(new Scene(root1, 500, 500));
        primaryStage.show();


//        FXMLLoader fxmlLoader = new FXMLLoader();
//        Parent root2 = fxmlLoader.load(getClass().getResource("AddMemberPage.fxml").openStream());
//        MainController mainController = fxmlLoader.getController();
//        mainController.setStage(primaryStage);
//        primaryStage.setScene(new Scene(root2, 500, 500));
//        primaryStage.show();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                primaryStage.setScene(new Scene(root1, 400, 400));
//                primaryStage.show();
//            }
//        }).start();

    }



    public static void main(String[] args) {
        launch(args);
    }
}
