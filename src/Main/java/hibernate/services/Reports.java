package hibernate.services;

public class Reports {

    public static String customerCount() {
        CustomerService customerService = new CustomerService();
        int zero = 0;
        return String.valueOf(zero + customerService.getAllCustomers().size());
    }

    public static String eventCount() {
        EventService eventService = new EventService();
        int zero = 0;
        return String.valueOf(zero + eventService.getAllEvents().size());
    }

    public static String activeTaskCount() {
        TaskService taskService = new TaskService();
        int zero = 0;
        return String.valueOf(zero + taskService.getSortedTask(true).size());
    }

    public static String inactiveTaskCount() {
        TaskService taskService = new TaskService();
        int zero = 0;
        return String.valueOf(zero + taskService.getSortedTask(false).size());
    }
}
