package UI.Layouts;


import UI.Display;
import UI.Elements.ActionButtonTableCell;
import UI.Elements.CustomButton;
import UI.Elements.CustomLabel;
import UI.Elements.DropdownButtons;
import hibernate.entities.Customer;
import hibernate.entities.Task;
import hibernate.services.TaskService;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import javax.xml.bind.annotation.XmlType;

public class TaskScreenLayout {

    public static TextField addTaskTextField;


    public static Scene taskPage() {
         TaskService taskService = new TaskService();
        VBox mainLayout = new VBox();
        mainLayout.setPadding(new Insets(0, 10, 10, 10));
        HBox screen = DropdownButtons.showMainButtons();

        //ActiveTasks table
        TableView activeTasksTableView = new TableView();
        activeTasksTableView.setPadding(new Insets(10, 10, 10, 10));
        TableColumn<Object, Object> columnId = new TableColumn<>("ID");
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn<Object, Object> columnTasks = new TableColumn<>("Tasks");
        columnTasks.setMinWidth(600);
        columnTasks.setCellValueFactory(new PropertyValueFactory<>("taskDescription"));

        TableColumn<Task, Button> doneButton = new TableColumn<>("");
        doneButton.setCellFactory(ActionButtonTableCell.forTableColumn("Done", (Task task) -> {
            taskService.changeStatus(task.getId(), false);
            Display.showDisplay(TaskScreenLayout.taskPage());
            return null;
        }));

        TableColumn<Task, Button> deleteActive = new TableColumn<>("");
        deleteActive.setCellFactory(ActionButtonTableCell.forTableColumn("Delete", (Task task) -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Delete task?", ButtonType.YES, ButtonType.NO);
            alert.showAndWait();
            if(alert.getResult() == ButtonType.YES) {
                taskService.deleteTaskById(task.getId());
                Display.showDisplay(TaskScreenLayout.taskPage());
            } else if (alert.getResult() == ButtonType.NO) {
                Display.showDisplay(TaskScreenLayout.taskPage());
            }
            return null;
        }));
        activeTasksTableView.getColumns().addAll(columnId, columnTasks, doneButton, deleteActive);
        activeTasksTableView.getItems().addAll(taskService.getSortedTask(true));

        //CompletedTasks Table
        TableView completedTasksTableView = new TableView();
        completedTasksTableView.setPadding(new Insets(10, 10, 10, 10));
        TableColumn<Object, Object> columnCompletedId = new TableColumn<>("ID");
        columnCompletedId.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn<Object, Object> columnCompletedTasks = new TableColumn<>("Tasks");
        columnCompletedTasks.setCellValueFactory(new PropertyValueFactory<>("taskDescription"));

        TableColumn<Task, Button> undoButton = new TableColumn<>("");
        undoButton.setCellFactory(ActionButtonTableCell.forTableColumn("Undo", (Task task) -> {
            taskService.changeStatus(task.getId(), true);
            Display.showDisplay(TaskScreenLayout.taskPage());
            return null;
        }));

        TableColumn<Task, Button> deletePasive = new TableColumn<>("");
        deletePasive.setCellFactory(ActionButtonTableCell.forTableColumn("Delete", (Task task) -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Delete task?", ButtonType.YES, ButtonType.NO);
            alert.showAndWait();
            if(alert.getResult() == ButtonType.YES) {
                taskService.deleteTaskById(task.getId());
                Display.showDisplay(TaskScreenLayout.taskPage());
            } else if (alert.getResult() == ButtonType.NO) {
                Display.showDisplay(TaskScreenLayout.taskPage());
            }
            return null;
        }));
        completedTasksTableView.getColumns().addAll(columnCompletedId, columnCompletedTasks, undoButton, deletePasive);
        completedTasksTableView.getItems().addAll(taskService.getSortedTask(false));

        //Labels
        CustomLabel activeTasksLabel = new CustomLabel("Active tasks: ");
        activeTasksLabel.setFont(Font.font(45));
        CustomLabel completedTasksLabel = new CustomLabel("Completed tasks: ");
        completedTasksLabel.setFont(Font.font(45));

        //TextField
        addTaskTextField = new TextField();
        addTaskTextField.setPrefWidth(800);

        //Buttons
        CustomButton addTaskButton = new CustomButton("Add");
        addTaskButton.setMinWidth(100);
        addTaskButton.setOnAction(event -> { taskService.addTask();
            Display.showDisplay(TaskScreenLayout.taskPage());
        });




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
