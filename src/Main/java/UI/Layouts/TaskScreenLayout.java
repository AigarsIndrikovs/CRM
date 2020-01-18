package UI.Layouts;

import UI.Display;
import UI.Elements.ActionButtonTableCell;
import UI.Elements.CustomButton;
import UI.Elements.CustomLabel;
import UI.Elements.DropdownButtons;
import hibernate.entities.Task;
import hibernate.services.TaskService;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

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
        columnId.setCellValueFactory(new PropertyValueFactory<>("taskNumber"));
        TableColumn<Object, Object> columnTasks = new TableColumn<>("Tasks");
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
            if (alert.getResult() == ButtonType.YES) {
                taskService.deleteTaskById(task.getId());
                Display.showDisplay(TaskScreenLayout.taskPage());
            } else if (alert.getResult() == ButtonType.NO) {
                Display.showDisplay(TaskScreenLayout.taskPage());
            }
            return null;
        }));

        //Setting columnSizes for ActiveTasks Table
        columnId.setPrefWidth(40);
        doneButton.setPrefWidth(80);
        deleteActive.setPrefWidth(80);
        columnTasks.prefWidthProperty().bind(
                activeTasksTableView.widthProperty()
                        .subtract(columnId.widthProperty())
                        .subtract(doneButton.widthProperty())
                        .subtract(deleteActive.widthProperty())
                        .subtract(20) //Border values
        );

        activeTasksTableView.getColumns().addAll(columnId, columnTasks, doneButton, deleteActive);
        activeTasksTableView.getItems().addAll(taskService.getSortedTask(true));

        //CompletedTasks Table
        TableView completedTasksTableView = new TableView();
        completedTasksTableView.setPadding(new Insets(10, 10, 10, 10));
        TableColumn<Object, Object> columnCompletedId = new TableColumn<>("ID");
        columnCompletedId.setCellValueFactory(new PropertyValueFactory<>("taskNumber"));
        TableColumn<Object, Object> columnCompletedTasks = new TableColumn<>("Tasks");
        columnCompletedTasks.setCellValueFactory(new PropertyValueFactory<>("taskDescription"));

        TableColumn<Task, Button> undoCompletedTask = new TableColumn<>("");
        undoCompletedTask.setCellFactory(ActionButtonTableCell.forTableColumn("Undo", (Task task) -> {
            taskService.changeStatus(task.getId(), true);
            Display.showDisplay(TaskScreenLayout.taskPage());
            return null;
        }));

        TableColumn<Task, Button> deleteCompletedTask = new TableColumn<>("");
        deleteCompletedTask.setCellFactory(ActionButtonTableCell.forTableColumn("Delete", (Task task) -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Delete task?", ButtonType.YES, ButtonType.NO);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                taskService.deleteTaskById(task.getId());
                Display.showDisplay(TaskScreenLayout.taskPage());
            } else if (alert.getResult() == ButtonType.NO) {
                Display.showDisplay(TaskScreenLayout.taskPage());
            }
            return null;
        }));

        //Setting columnSizes for CompletedTasks Table
        columnCompletedId.setPrefWidth(40);
        undoCompletedTask.setPrefWidth(80);
        deleteCompletedTask.setPrefWidth(80);
        columnCompletedTasks.prefWidthProperty().bind(
                completedTasksTableView.widthProperty()
                        .subtract(columnId.widthProperty())
                        .subtract(doneButton.widthProperty())
                        .subtract(deleteActive.widthProperty())
                        .subtract(20) //Border values
        );

        completedTasksTableView.getColumns().addAll(columnCompletedId, columnCompletedTasks, undoCompletedTask, deleteCompletedTask);
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
        addTaskButton.setOnAction(event -> {
            taskService.addTask();
            Display.showDisplay(TaskScreenLayout.taskPage());
        });

        //VBox
        VBox taskScreenVBox = new VBox();
        taskScreenVBox.setPadding(new Insets(10, 10, 10, 10));
        HBox addTaskHBox = new HBox();
        addTaskHBox.getChildren().addAll(addTaskTextField, addTaskButton);

        //Setting size for ADD Task HBox
        addTaskButton.setPrefWidth(80);
        addTaskTextField.prefWidthProperty().bind(
                addTaskHBox.widthProperty()
                        .subtract(addTaskButton.widthProperty())
                        .subtract(20) //Border values
        );


        taskScreenVBox.getChildren().addAll(addTaskHBox, activeTasksLabel, activeTasksTableView, completedTasksLabel, completedTasksTableView);
        mainLayout.getChildren().addAll(screen, taskScreenVBox);
        return new Scene(mainLayout, Display.WIDTH, Display.HEIGHT);
    }


}
