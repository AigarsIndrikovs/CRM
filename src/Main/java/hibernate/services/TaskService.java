package hibernate.services;

import hibernate.entities.Task;
import hibernate.utility.DBConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TaskService {

    public void addTask() {
        Transaction transaction = null;
        try {
            Session session = DBConfig.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Task task = new Task();
            task.setTaskDescription("Text from APP");
            task.setStatus(true);
            session.save(task);
            transaction.commit();
            session.close();
    } catch (Exception e) {
        e.printStackTrace();
        }
    }


}
