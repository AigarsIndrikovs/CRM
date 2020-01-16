package UI.Elements;

import UI.Display;
import UI.Layouts.*;
import hibernate.entities.Customer;
import hibernate.entities.Event;
import hibernate.services.CustomerService;
import hibernate.services.EventService;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
        final EventService eventService = new EventService();

        Menu menuDropdown = new Menu("Menu");

        CustomMenuButton menuHomeButton = new CustomMenuButton("Home");
        CustomMenuItem customMenuItem = new CustomMenuItem();
        customMenuItem.setContent(menuHomeButton);
        customMenuItem.setHideOnClick(true);
        menuDropdown.getItems().add(customMenuItem);
        menuHomeButton.setOnAction(event -> Display.showDisplay(HomeScreenLayout.homepage()));

        CustomMenuButton customerListButton = new CustomMenuButton("Customers");
        CustomMenuItem customMenuItem2 = new CustomMenuItem();
        customMenuItem2.setContent(customerListButton);
        customMenuItem2.setHideOnClick(true);
        menuDropdown.getItems().add(customMenuItem2);
        customerListButton.setOnAction(event -> Display.showDisplay(CustomersScreenLayout.customerPage()));

        CustomMenuButton menuEventsButton = new CustomMenuButton("Events");
        CustomMenuItem customMenuItem4 = new CustomMenuItem();
        customMenuItem4.setContent(menuEventsButton);
        customMenuItem4.setHideOnClick(true);
        menuDropdown.getItems().add(customMenuItem4);
        menuEventsButton.setOnAction(event -> Display.showDisplay(EventScreenLayout.eventPage()));

        CustomMenuButton menuTasksButton = new CustomMenuButton("Tasks");
        CustomMenuItem customMenuItem5 = new CustomMenuItem();
        customMenuItem5.setContent(menuTasksButton);
        customMenuItem5.setHideOnClick(true);
        menuDropdown.getItems().add(customMenuItem5);
        menuTasksButton.setOnAction(event -> Display.showDisplay(TaskScreenLayout.taskPage()));

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(menuDropdown);


        ////////

        Menu createDropdownMenu = new Menu("Create");

        CustomMenuButton createCustomer = new CustomMenuButton("Create customer");
        CustomMenuItem createMenuItem = new CustomMenuItem();
        createMenuItem.setContent(createCustomer);
        createMenuItem.setHideOnClick(true);
        createDropdownMenu.getItems().add(createMenuItem);
        createCustomer.setOnAction(event -> {
            Customer customer = customerService.createCustomer();
            Display.showDisplay(CreateCustomerScreenLayout.CreateCustomerScreen(customer));
        });


        CustomMenuButton createEventsButton = new CustomMenuButton("Create event");
        CustomMenuItem createMenuItem2 = new CustomMenuItem();
        createMenuItem2.setContent(createEventsButton);
        createMenuItem2.setHideOnClick(true);
        createDropdownMenu.getItems().add(createMenuItem2);
        createEventsButton.setOnAction(event -> {
            Event visitEvent = eventService.createEvent();
            Display.showDisplay(CreateEventScreenLayout.CreateEventScreen(visitEvent));
        });

        MenuBar createBar = new MenuBar();
        createBar.getMenus().add(createDropdownMenu);

        mainButtons.getChildren().addAll(menuBar, createBar);

        return mainButtons;
    }


}
