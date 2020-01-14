package UI.Layouts;

import UI.Elements.DropdownButtons;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class HomeScreenLayout {

    public static Scene homepage(int width, int height) {
        VBox mainLayout = new VBox();
        HBox screen = DropdownButtons.showMainButtons();
        Label label = new Label("Test text for VBox!");
        mainLayout.getChildren().addAll(screen, label);
        return new Scene(mainLayout, width, height);
    }

}
