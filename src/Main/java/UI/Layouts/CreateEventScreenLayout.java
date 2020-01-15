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

public class CreateEventScreenLayout {

    public static Scene CreateEventScreen(int width, int height) {

        VBox mainLayout = new VBox();
        mainLayout.setPadding(new Insets(10, 10, 10, 10));
        HBox screen = DropdownButtons.showMainButtons();

        // Creating all the custom Labels
        CreateLayoutCustomLabel customerLabel = new CreateLayoutCustomLabel("Customer:");
        CreateLayoutCustomLabel dateLabel = new CreateLayoutCustomLabel("Date:");
        CreateLayoutCustomLabel contactPersonLabel = new CreateLayoutCustomLabel("Contact Person(s):");
        CreateLayoutCustomLabel descriptionLabel = new CreateLayoutCustomLabel("Description:");
        CreateLayoutCustomLabel restultLabel = new CreateLayoutCustomLabel("Result:");

        //Creating all the text areas
        TextField customerTextField = new TextField();
        TextField dateTextField = new TextField();
        TextArea contactPersonTextField = new TextArea();
        contactPersonTextField.setMaxHeight(40);
        TextArea descriptionTextField = new TextArea();
        descriptionTextField.setMaxHeight(80);
        TextArea resultTextField = new TextArea();
        resultTextField.setMaxHeight(40);


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

        createCustomerGridPane.add(restultLabel, 0, 4, 1, 1);
        createCustomerGridPane.add(resultTextField, 1, 4, 1, 1);

        mainLayout.getChildren().addAll(screen, createCustomerGridPane);
        return new Scene(mainLayout, width, height);
    }
}

