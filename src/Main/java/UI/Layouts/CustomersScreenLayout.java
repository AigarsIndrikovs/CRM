package UI.Layouts;

import UI.Display;
import UI.Elements.ActionButtonTableCell;
import UI.Elements.DropdownButtons;
import hibernate.entities.Customer;
import hibernate.services.CustomerService;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.List;


public class CustomersScreenLayout {

    public static Scene customerPage() {
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

        TableColumn<Customer, Button> editButton = new TableColumn<>("Edit");
        editButton.setCellFactory(ActionButtonTableCell.forTableColumn("Edit", (Customer customer) -> {
            customer = customerService.getCustomerById(customer.getId());
            Display.showDisplay(CreateCustomerScreenLayout.CreateCustomerScreen(customer));
            return null;
        }));

        TableColumn<Customer, Button> deleteButton = new TableColumn<>("Delete");
        deleteButton.setCellFactory(ActionButtonTableCell.forTableColumn("Delete", (Customer customer) -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Delete customer?", ButtonType.YES, ButtonType.NO);
            alert.showAndWait();
            if(alert.getResult() == ButtonType.YES) {
                customerService.deleteCustomerById(customer.getId());
                Display.showDisplay(CustomersScreenLayout.customerPage());
            } else if (alert.getResult() == ButtonType.NO) {
                Display.showDisplay(CustomersScreenLayout.customerPage());
            }
            return null;
        }));

        customerTableView.getColumns().addAll(columnId, columnName, columnAddress, columnRegistrationNumber, columnPhone, columnEmail, columnWebPage, columnContactPerson, editButton, deleteButton);

        customerTableView.getItems().addAll(allCustomers);

        mainLayout.getChildren().addAll(screen, customerTableView);

        return new Scene(mainLayout, Display.WIDTH, Display.HEIGHT);
    }



}
