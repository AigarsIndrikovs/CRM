package UI.Layouts;

import UI.Display;
import UI.Elements.ActionButtonTableCell;
import UI.Elements.DropdownButtons;
import hibernate.entities.Customer;
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

        TableColumn<Object, Object> columnId = new TableColumn<>("ID");
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Object, Object> columnCustomer = new TableColumn<>("Customer");
        columnCustomer.setCellValueFactory(new PropertyValueFactory<>("customerName"));

        TableColumn<Object, Object> columnDate = new TableColumn<>("Date");
        columnDate.setCellValueFactory(new PropertyValueFactory<>("date"));

        TableColumn<Object, Object> columnContactPerson = new TableColumn<>("Contact Person");
        columnContactPerson.setCellValueFactory(new PropertyValueFactory<>("contactPerson"));

        TableColumn<Object, Object> columnEventDescription = new TableColumn<>("Description");
        columnEventDescription.setMaxWidth(300);
        columnEventDescription.setCellValueFactory(new PropertyValueFactory<>("eventDescription"));

        TableColumn<Object, Object> columnEventResult = new TableColumn<>("Result");
        columnEventDescription.setMaxWidth(200);
        columnEventResult.setCellValueFactory(new PropertyValueFactory<>("eventResult"));

        TableColumn<Event, Button> editButton = new TableColumn<>("Edit");
        editButton.setCellFactory(ActionButtonTableCell.forTableColumn("Edit", (Event event) -> {
            event = eventService.getEventById(event.getId());
            Display.showDisplay(CreateEventScreenLayout.CreateEventScreen(event));
            return null;
        }));

        TableColumn<Event, Button> deleteButton = new TableColumn<>("Delete");
        deleteButton.setCellFactory(ActionButtonTableCell.forTableColumn("Delete", (Event event) -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Delete event?", ButtonType.YES, ButtonType.NO);
            alert.showAndWait();
            if(alert.getResult() == ButtonType.YES) {
                eventService.deleteEventById(event.getId());
                Display.showDisplay(EventScreenLayout.eventPage());
            } else if (alert.getResult() == ButtonType.NO) {
                Display.showDisplay(EventScreenLayout.eventPage());
            }
            return null;
        }));


        eventTableView.getColumns().addAll(columnId, columnCustomer, columnDate, columnContactPerson, columnEventDescription, columnEventResult, editButton, deleteButton);

         eventTableView.getItems().addAll(allEvents);

        mainLayout.getChildren().addAll(screen, eventTableView);
        return new Scene(mainLayout, Display.WIDTH, Display.HEIGHT);
    }


}



