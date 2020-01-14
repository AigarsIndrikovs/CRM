
import UI.DisplayedScene;
import UI.Layouts.HomeScreenLayout;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends DisplayedScene {

    Stage window;

//    @Override
//    public void start(Stage primaryStage) throws Exception{
//        DisplayedScene.setUIStage(HomeScreenLayout.homepage(400,300));
//        window = DisplayedScene.getUIStage();
////        Scene scene = HomeScreenLayout.homepage(600,400);
//        window.setTitle("CRM");
////        primaryStage.setScene(scene);
//        window.show();
//
//
//    }


    public static void main(String[] args) {

        DisplayedScene.launch(args);
    }


}
