package hibernate;

import hibernate.entities.Customer;
import hibernate.utility.DBConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLOutput;

public class CustomerService {

    private Session session;

    public CustomerService() {
        session = DBConfig.getSessionFactory().openSession();
    }
    public void safeCustomer(Customer customer) {
        Transaction transaction = null;
        try {
            Session session = DBConfig.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            customer.setName("LVPARTS SIA");
            customer.setAddress("Office address");
            customer.setRegNumber(123456);
            customer.setPhone("+37126159734");
            customer.setMail("aigars@lvparts.lv");
            customer.setWebPage("lvparts.lv");
            session.save(customer);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Can't save customer");
        }
    }

    public void createCustomer() {
        Transaction transaction = null;
        try {
            Session session = DBConfig.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Customer customer = new Customer();
//            safeCustomer(customer);
            session.save(customer);
            transaction.commit();
        } catch (Exception e){
            System.out.println("Can't create customer");
        }
    }

    public static Customer customerById(int byId) {
        Session session = DBConfig.getSessionFactory().openSession();
        Customer customer = (Customer) session.get(Customer.class, byId);
        session.close();
        return  customer;
    }


}
