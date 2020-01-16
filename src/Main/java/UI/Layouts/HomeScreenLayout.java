package UI.Layouts;

import UI.Display;
import UI.Elements.CreateLayoutCustomLabel;
import UI.Elements.DropdownButtons;
import UI.Elements.HomeScreenInfoLabel;
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
import javafx.scene.text.Font;

import java.util.List;

public class HomeScreenLayout extends Display {


    public static Scene homepage() {
        VBox mainLayout = new VBox();
        mainLayout.setPadding(new Insets(0, 10, 10, 10));
        HBox screen = DropdownButtons.showMainButtons();
        GridPane homScreenLogoPane = new GridPane();
        homScreenLogoPane.setPadding(new Insets(10, 10, 10, 10));
        homScreenLogoPane.setAlignment(Pos.CENTER);

        Image companyLogo = new Image("https://logodix.com/logo/237441.png");
        homScreenLogoPane.getChildren().addAll(new ImageView(companyLogo));

        CreateLayoutCustomLabel customerCount = new CreateLayoutCustomLabel("Customer count: ");
        customerCount.setFont(Font.font(50));
        CreateLayoutCustomLabel eventCount = new CreateLayoutCustomLabel("Event count: ");
        eventCount.setFont(Font.font(50));
        CreateLayoutCustomLabel activeTasks = new CreateLayoutCustomLabel("Active tasks: ");
        activeTasks.setFont(Font.font(50));
        CreateLayoutCustomLabel finishedTasks = new CreateLayoutCustomLabel("Finished tasks: ");
        finishedTasks.setFont(Font.font(50));

        HomeScreenInfoLabel customerCountInfo = new HomeScreenInfoLabel("sdffsdfsdfsdf");
        HomeScreenInfoLabel eventCountInfo = new HomeScreenInfoLabel("sdffsdfsdffd");
        HomeScreenInfoLabel activeTasksInfo = new HomeScreenInfoLabel("wefwefwef");
        HomeScreenInfoLabel finishedTasksInfo = new HomeScreenInfoLabel("234324");

        GridPane homeScreenInfoGrid = new GridPane();
        homeScreenInfoGrid.setPadding(new Insets(10, 10, 10, 10));
        homeScreenInfoGrid.setAlignment(Pos.TOP_CENTER);
        homeScreenInfoGrid.add(customerCount, 0, 0, 1, 1);
        homeScreenInfoGrid.add(customerCountInfo, 1, 0, 1, 1);
        homeScreenInfoGrid.add(eventCount, 0, 1, 1, 1);
        homeScreenInfoGrid.add(eventCountInfo, 1, 1, 1, 1);
        homeScreenInfoGrid.add(activeTasks, 0, 2, 1, 1);
        homeScreenInfoGrid.add(activeTasksInfo, 1, 2, 1, 1);
        homeScreenInfoGrid.add(finishedTasks, 0, 3, 1, 1);
        homeScreenInfoGrid.add(finishedTasksInfo, 1, 3, 1, 1);


        mainLayout.getChildren().addAll(screen, homScreenLogoPane, homeScreenInfoGrid);

        return new Scene(mainLayout, Display.WIDTH, Display.HEIGHT);
    }

}
