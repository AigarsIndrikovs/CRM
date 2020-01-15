
import UI.Display;
import UI.Layouts.*;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) {
        Display.showDisplay(HomeScreenLayout.homepage());
    }


    public static void main(String[] args) {
        launch(args);
    }


}
