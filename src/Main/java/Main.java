import hibernate.CustomerService;
import hibernate.entities.Customer;

import java.util.ArrayList;

public class Main  { //extends Application

//    @Override
//    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        primaryStage.setTitle("CRM");
//        primaryStage.setScene(new Scene(root, 300, 275));
//        primaryStage.show();
//    }


    public static void main(String[] args) {

        CustomerService customerService = new CustomerService();
//        customerService.createCustomer();

        Customer customer = customerService.customerById(1);
        System.out.println(customer.toString());

    }
}
