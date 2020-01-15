package UI.Layouts;

import UI.Elements.CreateLayoutCustomLabel;
import UI.Elements.DropdownButtons;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class CreateCustomerScreenLayout {

    public static Scene CreateCustomerScreen(int width, int height) {

        VBox mainLayout = new VBox();
        mainLayout.setPadding(new Insets(10, 10, 10, 10));
        HBox screen = DropdownButtons.showMainButtons();

        // Creating all the custom Labels
        CreateLayoutCustomLabel nameLabel = new CreateLayoutCustomLabel("Name:");
        CreateLayoutCustomLabel addressLabel = new CreateLayoutCustomLabel("Address:");
        CreateLayoutCustomLabel regNumberLabel = new CreateLayoutCustomLabel("Registration Number:");
        CreateLayoutCustomLabel phoneNumberLabel = new CreateLayoutCustomLabel("Phone Number:");
        CreateLayoutCustomLabel emailLabel = new CreateLayoutCustomLabel("E-mail:");
        CreateLayoutCustomLabel webpageLabel = new CreateLayoutCustomLabel("Webpage:");
        CreateLayoutCustomLabel contactLabel = new CreateLayoutCustomLabel("Contacts:");

        //Creating all the text areas
        TextField nameTextField = new TextField();
        TextArea addressTextField = new TextArea();
        addressTextField.setMaxHeight(80);
        TextField regNumberTextField = new TextField();
        TextField phoneNumberTextField = new TextField();
        TextField emailTextField = new TextField();
        TextField webpageTextField = new TextField();
        TextField contactTextField = new TextField();

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

        createCustomerGridPane.add(webpageLabel, 0, 5, 1, 1);
        createCustomerGridPane.add(webpageTextField, 1, 5, 1, 1);

        createCustomerGridPane.add(contactLabel, 0, 6, 1, 1);
        createCustomerGridPane.add(contactTextField, 1, 6, 1, 1);

        mainLayout.getChildren().addAll(screen, createCustomerGridPane);
        return new Scene(mainLayout, width, height);
    }
}
