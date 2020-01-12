package hibernate.services;

import hibernate.entities.Customer;
import hibernate.entities.Event;
import hibernate.utility.DBConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class EventService {

    public EventService() {
    }

    public Event getEventById(int byId) {
        Session session = DBConfig.getSessionFactory().openSession();
        Event event = session.get(Event.class, byId);
        session.close();
        return  event;
    }

    public void createEvent() {
        Transaction transaction = null;
        try {
            Session session = DBConfig.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Event event = new Event();
            session.save(event);
            transaction.commit();
            session.close();
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Can't create event");
        }
    }

    public void updateEvent(int id, Customer customer) {
        Transaction transaction = null;
        try {
            Session session = DBConfig.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Event event = getEventById(id);
            event.setCustomer(customer);
            event.setDate("10.01.2020");
            event.setContactPerson("CEO and marketing manager");
            event.setEventDescription("Discussed pricing and marketing support. Customer need additional catalogues and leaflets");
            event.setEventResult("Agreed to start cooperation");
            session.update(event);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Can't update event");
        }
    }

    public List<Event> getAllEvents() {
        List<Event> allEvents;
        Session session = DBConfig.getSessionFactory().openSession();
        allEvents = session.createQuery("from Event", Event.class).getResultList();
        session.close();
        return allEvents;
    }

    public void deleteEventById(int id) {
        Transaction transaction = null;
        try {
            Session session = DBConfig.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Event event = getEventById(id);
            session.delete(event);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Can't delete event");
        }
    }

}
