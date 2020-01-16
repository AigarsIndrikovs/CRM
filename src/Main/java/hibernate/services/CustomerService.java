package hibernate.services;

import UI.Layouts.CreateCustomerScreenLayout;
import hibernate.entities.Customer;
import hibernate.utility.DBConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
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
            customer.setName(CreateCustomerScreenLayout.getNameTextField().getText());
            customer.setAddress(CreateCustomerScreenLayout.getAddressTextField().getText());
            customer.setRegNumber(CreateCustomerScreenLayout.getRegNumberTextField().getText());
            customer.setPhone(CreateCustomerScreenLayout.getPhoneNumberTextField().getText());
            customer.setMail(CreateCustomerScreenLayout.getEmailTextField().getText());
            customer.setWebPage(CreateCustomerScreenLayout.getWebpageTextField().getText());
            customer.setContactPerson(CreateCustomerScreenLayout.getContactTextField().getText());
            session.update(customer);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Can't save customer");
        }
    }

    public Customer createCustomer() {
        Customer customer = new Customer();
        Transaction transaction = null;
        try {
            Session session = DBConfig.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(customer);
            transaction.commit();
            session.close();
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Can't create customer");
        }
        return customer;
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
