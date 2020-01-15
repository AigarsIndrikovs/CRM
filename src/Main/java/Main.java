
import UI.Display;
import UI.Layouts.*;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) {
        Display.showDisplay(CreateEventScreenLayout.CreateEventScreen(900, 600));
    }


    public static void main(String[] args) {
        launch(args);
    }


}
