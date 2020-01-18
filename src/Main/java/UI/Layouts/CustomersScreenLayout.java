package UI.Layouts;

import UI.Display;
import UI.Elements.ActionButtonTableCell;
import UI.Elements.DropdownButtons;
import hibernate.entities.Customer;
import hibernate.services.CustomerService;
import javafx.geometry.Insets;
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
        mainLayout.setPadding(new Insets(0, 10, 10, 10));
        HBox screen = DropdownButtons.showMainButtons();
        TableView customerTableView = new TableView();
        customerTableView.setPadding(new Insets(10, 10, 10, 10));

        //Adding all columns to TableView
        TableColumn<Object, Object> columnId = new TableColumn<>("Nr.");
        columnId.setCellValueFactory(new PropertyValueFactory<>("numberInList"));
        TableColumn<Object, Object> columnName = new TableColumn<>("Name");
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Object, Object> columnAddress = new TableColumn<>("Address");
        columnAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        TableColumn<Object, Object> columnRegistrationNumber = new TableColumn<>("Reg. Number");
        columnRegistrationNumber.setCellValueFactory(new PropertyValueFactory<>("regNumber"));
        TableColumn<Object, Object> columnPhone = new TableColumn<>("Phone");
        columnPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        TableColumn<Object, Object> columnEmail = new TableColumn<>("e-mail");
        columnEmail.setCellValueFactory(new PropertyValueFactory<>("mail"));
        TableColumn<Object, Object> columnWebPage = new TableColumn<>("Webpage");
        columnWebPage.setCellValueFactory(new PropertyValueFactory<>("webPage"));
        TableColumn<Object, Object> columnContactPerson = new TableColumn<>("Contact Person");
        columnContactPerson.setCellValueFactory(new PropertyValueFactory<>("contactPerson"));

        //Adding EDIT button to tableview and setting OnAction event
        TableColumn<Customer, Button> editButton = new TableColumn<>("Edit");
        editButton.setCellFactory(ActionButtonTableCell.forTableColumn("Edit", (Customer customer) -> {
            customer = customerService.getCustomerById(customer.getId());
            Display.showDisplay(CreateCustomerScreenLayout.CreateCustomerScreen(customer));
            return null;
        }));

        //Adding DELETE button to tableview and setting OnAction event
        TableColumn<Customer, Button> deleteButton = new TableColumn<>("Delete");
        deleteButton.setCellFactory(ActionButtonTableCell.forTableColumn("Delete", (Customer customer) -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Delete customer?", ButtonType.YES, ButtonType.NO);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                customerService.deleteCustomerById(customer.getId());
                Display.showDisplay(CustomersScreenLayout.customerPage());
            } else if (alert.getResult() == ButtonType.NO) {
                Display.showDisplay(CustomersScreenLayout.customerPage());
            }
            return null;
        }));

        //Setting columnSizes for customer Table
        columnId.setPrefWidth(40);
        columnName.setPrefWidth(110);
        columnRegistrationNumber.setPrefWidth(110);
        columnPhone.setPrefWidth(120);
        columnEmail.setPrefWidth(130);
        columnWebPage.setPrefWidth(110);
        columnContactPerson.setPrefWidth(130);
        editButton.setPrefWidth(80);
        deleteButton.setPrefWidth(80);
        columnAddress.prefWidthProperty().bind(
                customerTableView.widthProperty()
                        .subtract(columnName.widthProperty())
                        .subtract(columnRegistrationNumber.widthProperty())
                        .subtract(columnPhone.widthProperty())
                        .subtract(columnEmail.widthProperty())
                        .subtract(columnWebPage.widthProperty())
                        .subtract(columnContactPerson.widthProperty())
                        .subtract(columnId.widthProperty())
                        .subtract(editButton.widthProperty())
                        .subtract(deleteButton.widthProperty())
                        .subtract(20) //Border values
        );

        //Setting size of TableView for table
        customerTableView.prefHeightProperty().bind(
                mainLayout.heightProperty()
                        .subtract(20) //Border values
        );


        customerTableView.getColumns().addAll(columnId, columnName, columnAddress, columnRegistrationNumber, columnPhone, columnEmail, columnWebPage, columnContactPerson, editButton, deleteButton);
        customerTableView.getItems().addAll(allCustomers);
        mainLayout.getChildren().addAll(screen, customerTableView);
        return new Scene(mainLayout, Display.WIDTH, Display.HEIGHT);
    }


}
