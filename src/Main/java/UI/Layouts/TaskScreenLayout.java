package UI.Layouts;


import UI.Display;
import UI.Elements.DropdownButtons;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TaskScreenLayout {


    public static Scene taskPage() {
        // TaskService taskService = new TaskService();
        // List<Event> allTasks = eventService.getAllTasks();
        VBox mainLayout = new VBox();
        mainLayout.setPadding(new Insets(0, 10, 10, 10));
        HBox screen = DropdownButtons.showMainButtons();
        TableView taskTableview = new TableView();
        taskTableview.setPadding(new Insets(10, 10, 10, 10));

        TableColumn<Object, Object> columnId = new TableColumn<>("ID");
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Object, Object> columnTasks = new TableColumn<>("Tasks");
        columnTasks.setCellValueFactory(new PropertyValueFactory<>("tasks"));

        TableColumn<Object, Object> columnStatuss = new TableColumn<>("Statuss");
        columnStatuss.setCellValueFactory(new PropertyValueFactory<>("statuss"));


        taskTableview.getColumns().addAll(columnId, columnTasks, columnStatuss);

        // customerTableView.getItems().addAll(allCustomers);

        mainLayout.getChildren().addAll(screen, taskTableview);
        return new Scene(mainLayout, Display.WIDTH, Display.HEIGHT);
    }


}
