package hibernate.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;


@Entity
@Table(name = "events")
public class Event implements Serializable {

    @Id
    @Column(name = "eventId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "Customer")
    private Customer customer;

    @Column(name = "CustomerName")
    private String customerName;

    @Column(name = "Date")
    private String date;

    @Column(name = "ContactPerson")
    private String contactPerson;

    @Column(name = "Description")
    private String eventDescription;

    @Column(name = "Result")
    private String eventResult;

    @Column(name = "eventNumber")
    private String eventNumber;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getDate() {
        return date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String string) {
        this.customerName = string;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventResult() {
        return eventResult;
    }

    public void setEventResult(String eventResult) {
        this.eventResult = eventResult;
    }

    public String getEventNumber() {
        return eventNumber;
    }

    public void setEventNumber(String eventNumber) {
        this.eventNumber = eventNumber;
    }
}
