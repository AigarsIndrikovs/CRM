package UI.Layouts;

import UI.Display;
import UI.Elements.DropdownButtons;
import hibernate.entities.Event;
import hibernate.services.EventService;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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


        eventTableView.getColumns().addAll(columnId, columnCustomer, columnDate, columnContactPerson, columnEventDescription, columnEventResult);

         eventTableView.getItems().addAll(allEvents);

        mainLayout.getChildren().addAll(screen, eventTableView);
        return new Scene(mainLayout, Display.WIDTH, Display.HEIGHT);
    }


}



