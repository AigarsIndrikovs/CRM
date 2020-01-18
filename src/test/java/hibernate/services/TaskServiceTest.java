package hibernate.services;

import hibernate.entities.Task;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {

    private TaskService taskService = new TaskService();
    private List<Task> taskList = taskService.getSortedTask(true);


    @Test
    void addTask() {
        int taskCountBefore = taskList.size();
        taskService.addTaskForTest("JUnit test");
        taskList = taskService.getSortedTask(true);
        taskList.size();
        assertEquals(taskList.size(),taskCountBefore + 1 );
    }

    @Test
    void getTaskById() {
        Task task = taskService.getTaskById(12);
        assertEquals("New task", task.getTaskDescription());
    }

    @Test
    void getSortedTask() {
        List<Task> taskList = taskService.getSortedTask(true);
        assertTrue(taskList.size()>0);
    }

    @Test
    void deleteTaskById() {
        int taskCountBefore = taskList.size();
        taskService.deleteTaskById(taskList.get(taskList.size()-1).getId());
        taskList = taskService.getSortedTask(true);
        assertEquals(taskList.size(), taskCountBefore - 1);
    }

    @Test
    void changeStatus() {
        boolean statusBefore = taskList.get(0).isStatus();
        boolean statusAfter;
        if(statusBefore == true) {
            statusAfter = false;
        } else {
            statusAfter = false;
        }
        taskService.changeStatus(taskList.get(0).getId(), statusBefore);
        assertTrue(statusBefore != statusAfter);

    }
}