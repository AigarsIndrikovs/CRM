package UI;

import UI.Layouts.CustomersScreenLayout;
import UI.Layouts.HomeScreenLayout;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Display {

  private static final Stage stage = new Stage();
  public static final int WIDTH = 1024;
  public static final int HEIGHT = 800;

    public static void showDisplay(Scene scene) {
        stage.setTitle("CRM");
        stage.setScene(scene);
        stage.show();
    }

}
