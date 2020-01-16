package UI.Layouts;

import UI.Display;
import UI.Elements.CustomLabel;
import UI.Elements.DropdownButtons;
import UI.Elements.HomeScreenInfoLabel;
import hibernate.services.Reports;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

public class HomeScreenLayout extends Display {


    public static Scene homepage() {
        VBox mainLayout = new VBox();
        mainLayout.setPadding(new Insets(0, 10, 10, 10));
        HBox screen = DropdownButtons.showMainButtons();
        GridPane homScreenLogoPane = new GridPane();
        homScreenLogoPane.setPadding(new Insets(50, 10, 10, 10));
        homScreenLogoPane.setAlignment(Pos.CENTER);

        Image companyLogo = new Image("https://logodix.com/logo/237441.png");
        homScreenLogoPane.getChildren().addAll(new ImageView(companyLogo));

        CustomLabel customerCount = new CustomLabel("Customer count: ");
        customerCount.setFont(Font.font(50));
        CustomLabel eventCount = new CustomLabel("Event count: ");
        eventCount.setFont(Font.font(50));
        CustomLabel activeTasks = new CustomLabel("Active tasks: ");
        activeTasks.setFont(Font.font(50));
        CustomLabel finishedTasks = new CustomLabel("Finished tasks: ");
        finishedTasks.setFont(Font.font(50));

        HomeScreenInfoLabel customerCountInfo = new HomeScreenInfoLabel("sasd");
        HomeScreenInfoLabel eventCountInfo = new HomeScreenInfoLabel("sdffsdfsdffd");
        HomeScreenInfoLabel activeTasksInfo = new HomeScreenInfoLabel("wefwefwef");
        HomeScreenInfoLabel finishedTasksInfo = new HomeScreenInfoLabel("234324");

        GridPane homeScreenInfoGrid = new GridPane();
        homeScreenInfoGrid.setPadding(new Insets(100, 10, 10, 10));
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
