package hibernate.services;

import hibernate.entities.Customer;
import hibernate.utility.DBConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    public CustomerService() {
    }

    public void updateCustomer(int id) {
        Transaction transaction = null;
        try {
            Session session = DBConfig.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Customer customer = getCustomerById(id);
            customer.setName("LVPARTS SIA");
            customer.setAddress("Office address");
            customer.setRegNumber(123456);
            customer.setPhone("+37126159734");
            customer.setMail("sales@lvparts.lv");
            customer.setWebPage("lvparts.lv");
            customer.setContactPerson("Aigars Indrikovs");
            session.update(customer);
            transaction.commit();
            session.close();
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
            session.save(customer);
            transaction.commit();
            session.close();
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Can't create customer");
        }
    }

    public Customer getCustomerById(int byId) {
        Session session = DBConfig.getSessionFactory().openSession();
        Customer customer = session.get(Customer.class, byId);
        session.close();
        return  customer;
    }

    public List<Customer> getAllCustomers() {
        List<Customer> allCustomers;
        Session session = DBConfig.getSessionFactory().openSession();
        allCustomers = session.createQuery("from Customer", Customer.class).getResultList();
        session.close();
        return allCustomers;
    }

    public void deleteCustomerById(int id) {
        Transaction transaction = null;
        try {
            Session session = DBConfig.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Customer customer = getCustomerById(id);
            session.delete(customer);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Can't delete customer");
        }
    }

}
