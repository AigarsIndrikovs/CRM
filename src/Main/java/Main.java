
import UI.Display;
import UI.Layouts.*;
import hibernate.utility.DBConfig;
import javafx.application.Application;
import javafx.stage.Stage;
import org.hibernate.Session;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) {
        Display.showDisplay(HomeScreenLayout.homepage());
    }


    public static void main(String[] args) {
        Session session = DBConfig.getSessionFactory().openSession();
        launch(args);
    }


}
