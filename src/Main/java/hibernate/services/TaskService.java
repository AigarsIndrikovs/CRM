package hibernate.services;

import UI.Layouts.TaskScreenLayout;
import hibernate.entities.Customer;
import hibernate.entities.Task;
import hibernate.utility.DBConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TaskService {

    public void addTask() {
        Transaction transaction = null;
        try {
            Session session = DBConfig.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Task task = new Task();
            task.setTaskDescription(TaskScreenLayout.addTaskTextField.getText());
            task.setStatus(true);
            session.save(task);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Task getTaskById(int byId) {
        Session session = DBConfig.getSessionFactory().openSession();
        Task task = session.get(Task.class, byId);
        session.close();
        return task;
    }

    public List<Task> getSortedTask(boolean status) {
        List<Task> allTasks;
        List<Task> sortedList = new ArrayList<>();
        List<Task> reversedList = new ArrayList<>();
        Session session = DBConfig.getSessionFactory().openSession();
        allTasks = session.createQuery("from Task", Task.class).getResultList();
        session.close();
        for (int i = 0; i < allTasks.size(); i++) {
            if(allTasks.get(i).isStatus() == status) {
                sortedList.add(allTasks.get(i));
            }
        }
        for (int i = 0; i < sortedList.size(); i++) {
            reversedList.add(sortedList.get(sortedList.size()-(1+i)));
        }
        for (int i = 0; i < reversedList.size(); i++) {
            reversedList.get(i).setTaskNumber(String.valueOf(i + 1));
        }
        return reversedList;
    }

    public void deleteTaskById(int id) {
        Transaction transaction = null;
        try {
            Session session = DBConfig.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Task task = getTaskById(id);
            session.delete(task);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Can't delete task");
        }
    }

    public void changeStatus(int id, boolean status) {
        Transaction transaction = null;
        try {
            Session session = DBConfig.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Task task = getTaskById(id);
            task.setStatus(status);
            session.update(task);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addTaskForTest(String name) {
        Transaction transaction = null;
        try {
            Session session = DBConfig.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Task task = new Task();
            task.setTaskDescription(name);
            task.setStatus(true);
            session.save(task);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
