package UI;

import UI.Layouts.CustomersScreenLayout;
import UI.Layouts.HomeScreenLayout;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DisplayedScene extends Application {

private static Stage UIStage;
//
    @Override
    public void start(Stage primaryStage) throws Exception{
        UIStage = primaryStage;
        UIStage.setScene(HomeScreenLayout.homepage(400,300));
        UIStage.setTitle("Home");
        UIStage.show();


    }

    public static Stage getUIStage() {
        return UIStage;
    }

    public static void setUIStage(Scene scene) {
        Stage newStage = new Stage();
        newStage.setScene(scene);
        newStage.setTitle("Home");
       UIStage = newStage;
    }

    public static void copyStage(Stage stage) {
        UIStage = stage;
    }
}
