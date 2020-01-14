
import UI.Layouts.CustomersScreenLayout;
import UI.Layouts.HomeScreenLayout;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("src/Main/java/sample.fxml"));
        Scene scene = CustomersScreenLayout.customerPage(500, 300);
        primaryStage.setTitle("CRM");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {

        launch(args);
    }
}
