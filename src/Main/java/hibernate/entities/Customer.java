package hibernate.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "customers")

public class Customer implements Serializable {

    @Id
    @Column (name = "customerId")
    @GeneratedValue
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Address")
    private String address;

    @Column(name = "RegistrationNumber")
    private int regNumber;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "email")
    private String mail;

    @Column(name = "WebPage")
    private String webPage;

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(int regNumber) {
        this.regNumber = regNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getWebPage() {
        return webPage;
    }

    public void setWebPage(String webPage) {
        this.webPage = webPage;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", regNumber=" + regNumber +
                ", phone='" + phone + '\'' +
                ", mail='" + mail + '\'' +
                ", webPage='" + webPage + '\'' +
                '}';
    }
}
