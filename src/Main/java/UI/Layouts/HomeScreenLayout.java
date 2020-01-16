package UI.Layouts;

import UI.Display;
import UI.Elements.DropdownButtons;
import hibernate.entities.Customer;
import hibernate.services.CustomerService;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.List;

public class HomeScreenLayout extends Display {


    public static Scene homepage() {
        VBox mainLayout = new VBox();
        mainLayout.setPadding(new Insets(0, 10, 10, 10));
        HBox screen = DropdownButtons.showMainButtons();
        GridPane homeScreenPane = new GridPane();
        homeScreenPane.setPadding(new Insets(10, 10, 10, 10));
        homeScreenPane.setAlignment(Pos.CENTER);

        Image companyLogo = new Image("https://logodix.com/logo/237441.png");

        homeScreenPane.getChildren().addAll(new ImageView(companyLogo));
        mainLayout.getChildren().addAll(screen, homeScreenPane);

        return new Scene(mainLayout, Display.WIDTH, Display.HEIGHT);
    }

}
