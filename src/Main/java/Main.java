import hibernate.entities.Customer;
import hibernate.entities.Event;
import hibernate.services.CustomerService;
import hibernate.services.EventService;
import javafx.application.Application;
import java.util.List;

public abstract class Main extends Application {

    /*
    public void start(Stage primaryStage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene = setupUI(500, 300);
        primaryStage.setTitle("Simple application");
        // primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    */
    public static void main(String[] args) {

        CustomerService customerService = new CustomerService();
        EventService eventService = new EventService();
        Customer costumer = customerService.getCustomerById(1);
//        customerService.safeCustomer(costumer);
//        System.out.println(costumer.toString());
//        customerService.createCustomer();
//        customerService.updateCustomer(15);
//        customerService.deleteCustomerById(16);
//        List allCustomers = customerService.getAllCustomers();
//        for (int i = 0; i < allCustomers.size(); i++) {
//            System.out.println(allCustomers.get(i).toString());
//        eventService.createEvent();
//        eventService.updateEvent(1, costumer);
//        Event event = eventService.getEventById(1);
//        System.out.println(event.toString());
//        }




    /*


*/
    }
}