package UI.Layouts;

import UI.Display;
import UI.Elements.CustomLabel;
import UI.Elements.DropdownButtons;
import hibernate.entities.Event;
import hibernate.services.EventService;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class CreateEventScreenLayout {

    private static TextField customerTextField;
    private static TextField dateTextField;
    private static TextArea contactPersonTextField;
    private static TextArea descriptionTextField;
    private static TextArea resultTextField;

    public static Scene CreateEventScreen( Event visitEvent) {

        final EventService eventService = new EventService();

        VBox mainLayout = new VBox();
        mainLayout.setPadding(new Insets(0, 10, 10, 10));
        HBox screen = DropdownButtons.showMainButtons();

        // Creating all the custom Labels
        CustomLabel customerLabel = new CustomLabel("Customer:");
        CustomLabel dateLabel = new CustomLabel("Date:");
        CustomLabel contactPersonLabel = new CustomLabel("Contact Person(s):");
        CustomLabel descriptionLabel = new CustomLabel("Description:");
        CustomLabel resultLabel = new CustomLabel("Result:");

        //Creating all the text areas
        customerTextField = new TextField(visitEvent.getCustomerName());
        dateTextField = new TextField(visitEvent.getDate());
        contactPersonTextField = new TextArea(visitEvent.getContactPerson());
        contactPersonTextField.setMaxHeight(40);
        descriptionTextField = new TextArea(visitEvent.getEventDescription());
        descriptionTextField.setMaxHeight(80);
        resultTextField = new TextArea(visitEvent.getEventResult());
        resultTextField.setMaxHeight(40);

        // Creating save button
        Button saveButton = new Button();
        saveButton.setText("SAVE");
        saveButton.setOnAction(event -> {
            eventService.updateEvent(visitEvent.getId());
            Display.showDisplay(EventScreenLayout.eventPage());
        });


        //Creating gridpane, configuring it and adding elements
        GridPane createCustomerGridPane = new GridPane();
        createCustomerGridPane.setHgap(10);
        createCustomerGridPane.setVgap(10);
        createCustomerGridPane.setAlignment(Pos.TOP_CENTER);
        createCustomerGridPane.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        createCustomerGridPane.setPadding(new Insets(10, 10, 10, 10));


        createCustomerGridPane.add(customerLabel, 0, 0, 1, 1);
        createCustomerGridPane.add(customerTextField, 1, 0, 1, 1);

        createCustomerGridPane.add(dateLabel, 0, 1, 1, 1);
        createCustomerGridPane.add(dateTextField, 1, 1, 1, 1);

        createCustomerGridPane.add(contactPersonLabel, 0, 2, 1, 1);
        createCustomerGridPane.add(contactPersonTextField, 1, 2, 1, 1);

        createCustomerGridPane.add(descriptionLabel, 0, 3, 1, 1);
        createCustomerGridPane.add(descriptionTextField, 1, 3, 1, 1);

        createCustomerGridPane.add(resultLabel, 0, 4, 1, 1);
        createCustomerGridPane.add(resultTextField, 1, 4, 1, 1);

        createCustomerGridPane.add(saveButton, 1,5,1,1);



        mainLayout.getChildren().addAll(screen, createCustomerGridPane);
        return new Scene(mainLayout, Display.WIDTH, Display.HEIGHT);
    }

    public static TextField getCustomerTextField() {
        return customerTextField;
    }

    public static void setCustomerTextField(TextField customerTextField) {
        CreateEventScreenLayout.customerTextField = customerTextField;
    }

    public static TextField getDateTextField() {
        return dateTextField;
    }

    public static void setDateTextField(TextField dateTextField) {
        CreateEventScreenLayout.dateTextField = dateTextField;
    }

    public static TextArea getContactPersonTextField() {
        return contactPersonTextField;
    }

    public static void setContactPersonTextField(TextArea contactPersonTextField) {
        CreateEventScreenLayout.contactPersonTextField = contactPersonTextField;
    }

    public static TextArea getDescriptionTextField() {
        return descriptionTextField;
    }

    public static void setDescriptionTextField(TextArea descriptionTextField) {
        CreateEventScreenLayout.descriptionTextField = descriptionTextField;
    }

    public static TextArea getResultTextField() {
        return resultTextField;
    }

    public static void setResultTextField(TextArea resultTextField) {
        CreateEventScreenLayout.resultTextField = resultTextField;
    }
}

