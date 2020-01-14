package UI.Elements;

import UI.DisplayedScene;
import UI.Layouts.CustomersScreenLayout;
import UI.Layouts.HomeScreenLayout;
import hibernate.services.CustomerService;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class DropdownButtons {

    public static Button customerListButton;
    public static Button createCustomer;
    private static Object Node;

    public static HBox showMainButtons() {

        HBox mainButtons = new HBox();
        final CustomerService customerService = new CustomerService();

        Menu menuDropdown = new Menu("Menu");

        CustomMenuButton menuHomeButton = new CustomMenuButton("Home");
        CustomMenuItem customMenuItem = new CustomMenuItem();
        customMenuItem.setContent(menuHomeButton);
        customMenuItem.setHideOnClick(false);
        menuDropdown.getItems().add(customMenuItem);

        customerListButton = new CustomMenuButton("Customers");
        CustomMenuItem customMenuItem2 = new CustomMenuItem();
        customMenuItem2.setContent(customerListButton);
        customMenuItem2.setHideOnClick(true);
        menuDropdown.getItems().add(customMenuItem2);
        customerListButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = new Stage();
                stage.setTitle("Customer list");
                stage.setScene(CustomersScreenLayout.customerPage(900, 600));
                System.out.println("Clicked");
                DisplayedScene.copyStage(stage);
            }
        });

        CustomMenuButton menuContactsButton = new CustomMenuButton("Contacts");
        CustomMenuItem customMenuItem3 = new CustomMenuItem();
        customMenuItem3.setContent(menuContactsButton);
        customMenuItem3.setHideOnClick(false);
        menuDropdown.getItems().add(customMenuItem3);

        CustomMenuButton menuEventsButton = new CustomMenuButton("Events");
        CustomMenuItem customMenuItem4 = new CustomMenuItem();
        customMenuItem4.setContent(menuEventsButton);
        customMenuItem4.setHideOnClick(false);
        menuDropdown.getItems().add(customMenuItem4);

        CustomMenuButton menuTasksButton = new CustomMenuButton("Tasks");
        CustomMenuItem customMenuItem5 = new CustomMenuItem();
        customMenuItem5.setContent(menuTasksButton);
        customMenuItem5.setHideOnClick(false);
        menuDropdown.getItems().add(customMenuItem5);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(menuDropdown);


        ////////

        Menu createDropdownMenu = new Menu("Create");

        createCustomer = new Button("Create customer");
        CustomMenuItem createMenuItem = new CustomMenuItem();
        createMenuItem.setContent(createCustomer);
        createMenuItem.setHideOnClick(true);
        createDropdownMenu.getItems().add(createMenuItem);


        CustomMenuButton createEventsButton = new CustomMenuButton("Events");
        CustomMenuItem createMenuItem2 = new CustomMenuItem();
        createMenuItem2.setContent(createEventsButton);
        createMenuItem2.setHideOnClick(false);
        createDropdownMenu.getItems().add(createMenuItem2);

        CustomMenuButton createTasksButton = new CustomMenuButton("Tasks");
        CustomMenuItem createMenuItem3 = new CustomMenuItem();
        createMenuItem3.setContent(createTasksButton);
        createMenuItem3.setHideOnClick(false);
        createDropdownMenu.getItems().add(createMenuItem3);

        MenuBar createBar = new MenuBar();
        createBar.getMenus().add(createDropdownMenu);

        mainButtons.getChildren().addAll(menuBar, createBar);

        return mainButtons;
    }


}
