package UI.Layouts;


import UI.Display;
import UI.Elements.CustomButton;
import UI.Elements.CustomLabel;
import UI.Elements.DropdownButtons;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TaskScreenLayout {


    public static Scene taskPage() {
        // TaskService taskService = new TaskService();
        // List<Event> allTasks = eventService.getAllTasks();
        VBox mainLayout = new VBox();
        mainLayout.setPadding(new Insets(0, 10, 10, 10));
        HBox screen = DropdownButtons.showMainButtons();

        //ActiveTasks table
        TableView activeTasksTableView = new TableView();
        activeTasksTableView.setPadding(new Insets(10, 10, 10, 10));
        TableColumn<Object, Object> columnId = new TableColumn<>("ID");
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn<Object, Object> columnTasks = new TableColumn<>("Tasks");
        columnTasks.setCellValueFactory(new PropertyValueFactory<>("tasks"));
        activeTasksTableView.getColumns().addAll(columnId, columnTasks);

        //CompletedTasks Table
        TableView completedTasksTableView = new TableView();
        completedTasksTableView.setPadding(new Insets(10, 10, 10, 10));
        TableColumn<Object, Object> columnCompletedId = new TableColumn<>("ID");
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn<Object, Object> columnCompletedTasks = new TableColumn<>("Tasks");
        columnTasks.setCellValueFactory(new PropertyValueFactory<>("tasks"));
        completedTasksTableView.getColumns().addAll(columnCompletedId, columnCompletedTasks);
        // customerTableView.getItems().addAll(allCustomers);

        //Labels
        CustomLabel activeTasksLabel = new CustomLabel("Active tasks: ");
        CustomLabel completedTasksLabel = new CustomLabel("Completed tasks: ");

        //TextField
        TextField addTaskTextField = new TextField();
        addTaskTextField.setPrefWidth(800);

        //Buttons
        CustomButton addTaskButton = new CustomButton("Add");
        CustomButton completedTaskButton = new CustomButton("Completed");
        CustomButton deleteTaskButton = new CustomButton("Delete");
        CustomButton undoCompletedTaskButton = new CustomButton("Undo");
        CustomButton deleteCompletedTaskButton = new CustomButton("Delete");

        //VBox
        VBox taskScreenVBox = new VBox();
        taskScreenVBox.setPadding(new Insets(10, 10, 10, 10));
        HBox addTaskHBox = new HBox();
        addTaskHBox.getChildren().addAll(addTaskTextField, addTaskButton);
        taskScreenVBox.getChildren().addAll(addTaskHBox, activeTasksLabel, activeTasksTableView, completedTasksLabel, completedTasksTableView);


        mainLayout.getChildren().addAll(screen, taskScreenVBox);
        return new Scene(mainLayout, Display.WIDTH, Display.HEIGHT);
    }


}
