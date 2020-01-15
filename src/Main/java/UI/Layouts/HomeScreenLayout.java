package UI.Layouts;

import UI.Display;
import UI.Elements.DropdownButtons;
import hibernate.entities.Customer;
import hibernate.services.CustomerService;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.List;

public class HomeScreenLayout extends Display {


    public static Scene homepage() {
        VBox mainLayout = new VBox();
        HBox screen = DropdownButtons.showMainButtons();
        Label label = new Label("Test text for VBox!");
        mainLayout.getChildren().addAll(screen, label);

        return new Scene(mainLayout, Display.WIDTH, Display.HEIGHT);
    }

}
