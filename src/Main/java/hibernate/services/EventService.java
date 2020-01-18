package hibernate.services;

import UI.Layouts.CreateEventScreenLayout;
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

    public Event createEvent() {
        Event event = new Event();
        Transaction transaction = null;
        try {
            Session session = DBConfig.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(event);
            transaction.commit();
            session.close();
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Can't create event");
        }
        return event;
    }

    public void updateEvent(int id) {
        Transaction transaction = null;
        try {
            Session session = DBConfig.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Event event = getEventById(id);
//            event.setCustomer(customer);
            event.setCustomerName(CreateEventScreenLayout.getCustomerTextField().getText());
            event.setDate(CreateEventScreenLayout.getDateTextField().getText());
            System.out.println(CreateEventScreenLayout.getDateTextField().getText());
            event.setContactPerson(CreateEventScreenLayout.getContactPersonTextField().getText());
            event.setEventDescription(CreateEventScreenLayout.getDescriptionTextField().getText());
            event.setEventResult(CreateEventScreenLayout.getResultTextField().getText());
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
        for (int i = 0; i < allEvents.size(); i++) {
            allEvents.get(i).setEventNumber(String.valueOf(i + 1));
        }
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
