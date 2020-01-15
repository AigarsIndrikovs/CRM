package UI.Layouts;

import UI.Display;
import UI.Elements.CreateLayoutCustomLabel;
import UI.Elements.DropdownButtons;
import hibernate.entities.Customer;
import hibernate.services.CustomerService;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class CreateCustomerScreenLayout {


    private static TextField nameTextField;
    private static TextArea addressTextField;
    private static TextField regNumberTextField;
    private static TextField phoneNumberTextField;
    private static TextField emailTextField;
    private static TextField webpageTextField;
    private static TextField contactTextField;

    public static Scene CreateCustomerScreen(Customer customer) {

        final CustomerService customerService = new CustomerService();

        VBox mainLayout = new VBox();
        mainLayout.setPadding(new Insets(10, 10, 10, 10));
        HBox screen = DropdownButtons.showMainButtons();

        // Creating all the custom Labels
        CreateLayoutCustomLabel nameLabel = new CreateLayoutCustomLabel("Name:");
        CreateLayoutCustomLabel addressLabel = new CreateLayoutCustomLabel("Address:");
        CreateLayoutCustomLabel regNumberLabel = new CreateLayoutCustomLabel("Registration Number:");
        CreateLayoutCustomLabel phoneNumberLabel = new CreateLayoutCustomLabel("Phone Number:");
        CreateLayoutCustomLabel emailLabel = new CreateLayoutCustomLabel("E-mail:");
        CreateLayoutCustomLabel webPageLabel = new CreateLayoutCustomLabel("Webpage:");
        CreateLayoutCustomLabel contactLabel = new CreateLayoutCustomLabel("Contact Person:");

        //Creating all the text areas
        nameTextField = new TextField(customer.getName());
        addressTextField = new TextArea(customer.getAddress());
        addressTextField.setMaxHeight(80);
        regNumberTextField = new TextField(customer.getRegNumber());
        phoneNumberTextField = new TextField(customer.getPhone());
        emailTextField = new TextField(customer.getMail());
        webpageTextField = new TextField(customer.getWebPage());
        contactTextField = new TextField(customer.getContactPerson());

        //Creating gridpane, configuring it and adding elements
        GridPane createCustomerGridPane = new GridPane();
        createCustomerGridPane.setHgap(10);
        createCustomerGridPane.setVgap(10);
        createCustomerGridPane.setAlignment(Pos.TOP_CENTER);
        createCustomerGridPane.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        createCustomerGridPane.setPadding(new Insets(10, 10, 10, 10));


        createCustomerGridPane.add(nameLabel, 0, 0, 1, 1);
        createCustomerGridPane.add(nameTextField, 1, 0, 1, 1);

        createCustomerGridPane.add(addressLabel, 0, 1, 1, 1);
        createCustomerGridPane.add(addressTextField, 1, 1, 1, 1);

        createCustomerGridPane.add(regNumberLabel, 0, 2, 1, 1);
        createCustomerGridPane.add(regNumberTextField, 1, 2, 1, 1);

        createCustomerGridPane.add(phoneNumberLabel, 0, 3, 1, 1);
        createCustomerGridPane.add(phoneNumberTextField, 1, 3, 1, 1);

        createCustomerGridPane.add(emailLabel, 0, 4, 1, 1);
        createCustomerGridPane.add(emailTextField, 1, 4, 1, 1);

        createCustomerGridPane.add(webPageLabel, 0, 5, 1, 1);
        createCustomerGridPane.add(webpageTextField, 1, 5, 1, 1);

        createCustomerGridPane.add(contactLabel, 0, 6, 1, 1);
        createCustomerGridPane.add(contactTextField, 1, 6, 1, 1);

        // Safe Button config
        Button saveButton = new Button();
        saveButton.setText("SAFE");
        saveButton.setOnAction(event -> {customerService.updateCustomer(customer.getId());
            Display.showDisplay(CustomersScreenLayout.customerPage());
        });

        mainLayout.getChildren().addAll(screen, createCustomerGridPane, saveButton);
        return new Scene(mainLayout,Display.WIDTH, Display.HEIGHT);
    }

    public static TextField getNameTextField() {
        return nameTextField;
    }

    public static void setNameTextField(TextField nameTextField) {
        CreateCustomerScreenLayout.nameTextField = nameTextField;
    }

    public static TextArea getAddressTextField() {
        return addressTextField;
    }

    public static void setAddressTextField(TextArea addressTextField) {
        CreateCustomerScreenLayout.addressTextField = addressTextField;
    }

    public static TextField getRegNumberTextField() {
        return regNumberTextField;
    }

    public static void setRegNumberTextField(TextField regNumberTextField) {
        CreateCustomerScreenLayout.regNumberTextField = regNumberTextField;
    }

    public static TextField getPhoneNumberTextField() {
        return phoneNumberTextField;
    }

    public static void setPhoneNumberTextField(TextField phoneNumberTextField) {
        CreateCustomerScreenLayout.phoneNumberTextField = phoneNumberTextField;
    }

    public static TextField getEmailTextField() {
        return emailTextField;
    }

    public static void setEmailTextField(TextField emailTextField) {
        CreateCustomerScreenLayout.emailTextField = emailTextField;
    }

    public static TextField getWebpageTextField() {
        return webpageTextField;
    }

    public static void setWebpageTextField(TextField webpageTextField) {
        CreateCustomerScreenLayout.webpageTextField = webpageTextField;
    }

    public static TextField getContactTextField() {
        return contactTextField;
    }

    public static void setContactTextField(TextField contactTextField) {
        CreateCustomerScreenLayout.contactTextField = contactTextField;
    }

    public static void setFields() {

    }

}
