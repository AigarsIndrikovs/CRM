package UI;

import UI.Layouts.CustomersScreenLayout;
import UI.Layouts.HomeScreenLayout;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Display {

  private static final Stage stage = new Stage();
  private static String title = "CRM system";

    public static void showDisplay(Scene scene) {
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }
}
