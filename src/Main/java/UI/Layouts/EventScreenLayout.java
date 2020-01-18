package UI.Layouts;

import UI.Display;
import UI.Elements.ActionButtonTableCell;
import UI.Elements.DropdownButtons;
import hibernate.entities.Event;
import hibernate.services.EventService;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.List;

public class EventScreenLayout {


    public static Scene eventPage() {
        EventService eventService = new EventService();
        List<Event> allEvents = eventService.getAllEvents();
        VBox mainLayout = new VBox();
        mainLayout.setPadding(new Insets(0, 10, 10, 10));
        HBox screen = DropdownButtons.showMainButtons();
        TableView eventTableView = new TableView();
        eventTableView.setPadding(new Insets(10, 10, 10, 10));

        //Adding all columns to TableView + adding buttons with on Click functions.
        TableColumn<Object, Object> columnId = new TableColumn<>("ID");
        columnId.setCellValueFactory(new PropertyValueFactory<>("eventNumber"));
        TableColumn<Object, Object> columnCustomer = new TableColumn<>("Customer");
        columnCustomer.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        TableColumn<Object, Object> columnDate = new TableColumn<>("Date");
        columnDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        TableColumn<Object, Object> columnContactPerson = new TableColumn<>("Contact Person");
        columnContactPerson.setCellValueFactory(new PropertyValueFactory<>("contactPerson"));
        TableColumn<Object, Object> columnEventDescription = new TableColumn<>("Description");
        columnEventDescription.setCellValueFactory(new PropertyValueFactory<>("eventDescription"));
        TableColumn<Object, Object> columnEventResult = new TableColumn<>("Result");
        columnEventResult.setCellValueFactory(new PropertyValueFactory<>("eventResult"));

        //Adding EDIT button to table and setting OnAction event
        TableColumn<Event, Button> editButton = new TableColumn<>("Edit");
        editButton.setCellFactory(ActionButtonTableCell.forTableColumn("Edit", (Event event) -> {
            event = eventService.getEventById(event.getId());
            Display.showDisplay(CreateEventScreenLayout.CreateEventScreen(event));
            return null;
        }));

        //Adding EDIT button to table and setting OnAction event
        TableColumn<Event, Button> deleteButton = new TableColumn<>("Delete");
        deleteButton.setCellFactory(ActionButtonTableCell.forTableColumn("Delete", (Event event) -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Delete event?", ButtonType.YES, ButtonType.NO);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                eventService.deleteEventById(event.getId());
                Display.showDisplay(EventScreenLayout.eventPage());
            } else if (alert.getResult() == ButtonType.NO) {
                Display.showDisplay(EventScreenLayout.eventPage());
            }
            return null;
        }));

        //Setting columnSizes for event Table
        columnId.setPrefWidth(40);
        columnCustomer.setPrefWidth(110);
        columnDate.setPrefWidth(80);
        columnContactPerson.setPrefWidth(160);
        columnEventResult.setPrefWidth(250);
        editButton.setPrefWidth(80);
        deleteButton.setPrefWidth(80);
        columnEventDescription.prefWidthProperty().bind(
                eventTableView.widthProperty()
                        .subtract(columnId.widthProperty())
                        .subtract(columnCustomer.widthProperty())
                        .subtract(columnDate.widthProperty())
                        .subtract(columnContactPerson.widthProperty())
                        .subtract(columnEventResult.widthProperty())
                        .subtract(editButton.widthProperty())
                        .subtract(deleteButton.widthProperty())
                        .subtract(20) //Border values
        );

        //Setting size of TableView of table
        eventTableView.prefHeightProperty().bind(
                mainLayout.heightProperty()
                        .subtract(20) //Border values
        );

        eventTableView.getColumns().addAll(columnId, columnCustomer, columnDate, columnContactPerson, columnEventDescription, columnEventResult, editButton, deleteButton);
        eventTableView.getItems().addAll(allEvents);
        mainLayout.getChildren().addAll(screen, eventTableView);
        return new Scene(mainLayout, Display.WIDTH, Display.HEIGHT);
    }


}



