package UI.Layouts;

import UI.Elements.DropdownButtons;
import hibernate.entities.Event;
import hibernate.services.EventService;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.List;

public class EventScreenLayout {


    Scene eventPageScene;

    public Scene getEventPageScene() {
        return eventPageScene;
    }

    public void setEventPageScene(Scene eventPageScene) {
        this.eventPageScene = eventPage(600, 600);
    }

    public static Scene eventPage(int width, int height) {
        EventService eventService = new EventService();
        List<Event> allEvents = eventService.getAllEvents();
        VBox mainLayout = new VBox();
        HBox screen = DropdownButtons.showMainButtons();
        TableView eventTableview = new TableView();

        TableColumn<Object, Object> columnId = new TableColumn<>("ID");
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Object, Object> columnCustomer = new TableColumn<>("Customer");
        columnCustomer.setCellValueFactory(new PropertyValueFactory<>("customer"));

        TableColumn<Object, Object> columnDate = new TableColumn<>("Date");
        columnDate.setCellValueFactory(new PropertyValueFactory<>("date"));

        TableColumn<Object, Object> columnContactPerson = new TableColumn<>("Contact Person");
        columnContactPerson.setCellValueFactory(new PropertyValueFactory<>("contactPerson"));

        TableColumn<Object, Object> columnEventDescription = new TableColumn<>("Description");
        columnEventDescription.setCellValueFactory(new PropertyValueFactory<>("eventDescription"));

        TableColumn<Object, Object> columnEventResult = new TableColumn<>("Result");
        columnEventResult.setCellValueFactory(new PropertyValueFactory<>("eventResult"));


        eventTableview.getColumns().addAll(columnId, columnCustomer, columnDate, columnContactPerson, columnEventDescription, columnEventResult);

        // customerTableView.getItems().addAll(allCustomers);

        mainLayout.getChildren().addAll(screen, eventTableview);
        return new Scene(mainLayout, width, height);
    }


}



