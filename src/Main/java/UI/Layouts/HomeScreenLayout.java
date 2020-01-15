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

    private static int width = 900;
    private static int height = 600;


    public static Scene homepage() {
        VBox mainLayout = new VBox();
        HBox screen = DropdownButtons.showMainButtons();
        Label label = new Label("Test text for VBox!");
        mainLayout.getChildren().addAll(screen, label);
        return new Scene(mainLayout, width, height);
    }

    public static Scene customerList() {
        CustomerService customerService = new CustomerService();
        List<Customer> allCustomers = customerService.getAllCustomers();
        VBox mainLayout = new VBox();
        HBox screen = DropdownButtons.showMainButtons();
        TableView customerTableView = new TableView();

        TableColumn<Object, Object> columnId = new TableColumn<>("ID");
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Object, Object> columnName = new TableColumn<>("Name");
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Object, Object> columnAddress = new TableColumn<>("Address");
        columnAddress.setCellValueFactory(new PropertyValueFactory<>("address"));

        TableColumn<Object, Object> columnRegistrationNumber = new TableColumn<>("Registration Number");
        columnRegistrationNumber.setCellValueFactory(new PropertyValueFactory<>("regNumber"));

        TableColumn<Object, Object> columnPhone = new TableColumn<>("Phone");
        columnPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));

        TableColumn<Object, Object> columnEmail = new TableColumn<>("e-mail");
        columnEmail.setCellValueFactory(new PropertyValueFactory<>("mail"));

        TableColumn<Object, Object> columnWebPage = new TableColumn<>("Webpage");
        columnWebPage.setCellValueFactory(new PropertyValueFactory<>("webPage"));

        TableColumn<Object, Object> columnContactPerson = new TableColumn<>("Contact Person");
        columnContactPerson.setCellValueFactory(new PropertyValueFactory<>("contactPerson"));

        customerTableView.getColumns().addAll(columnId, columnName, columnAddress, columnRegistrationNumber, columnPhone, columnEmail, columnWebPage, columnContactPerson);

        customerTableView.getItems().addAll(allCustomers);

        mainLayout.getChildren().addAll(screen, customerTableView);
        return new Scene(mainLayout, width, height);
    }

}
