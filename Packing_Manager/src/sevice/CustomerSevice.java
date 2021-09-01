package sevice;

import model.Customer;
import repository.CustomerRepository;
import repository.TicketRepository;
import java.util.List;

import static repository.CustomerRepository.dataCustomer;
import static sevice.TicketSevice.listTicket;

public class CustomerSevice {
    public static List<Customer> customers = TicketRepository.readFile(dataCustomer);

    public static int getNewID(){
        int IDNewAdd = -1;
        if (customers.size() == 0)
            IDNewAdd = 0;
        else {
            for (int i = 0; IDNewAdd == -1; i++) {
                for (Customer value : customers) {
                    if (i != value.getId()) {
                        IDNewAdd = i;
                    }

                    if (i == value.getId()) {
                        IDNewAdd = -1;
                        break;
                    }
                }
            }
        }
        return IDNewAdd;
    }

    public static void addCustomer(){
        Customer customer = new Customer();
        customer.setId(getNewID());
        System.out.print("\nEnter customer name ex: Le Thi Minh ");
        String name = EnterData.enterName();
        customer.setName(name);
        System.out.print("\nEnter phone number ex: 0135 068 9027 ");
        customers.add(customer);
        CustomerRepository.writeToFile(customers);
    }

    public static void editAllInfoCustomer(int id){
        for (Customer customer: customers) {
            if (customer.getId() != id) {
                continue;
            }
            System.out.print("\nEnter new customer name ex: Le Thi Minh ");
            String name = EnterData.enterName();
            customer.setName(name);
            System.out.print("\nEnter a new phone number ex: 0135 068 9025 ");
            String phoneNumber = EnterData.enterPhoneNumber();
            customer.setPhoneNumber(phoneNumber);
            CustomerRepository.writeToFile(customers);
            return;
        }
        System.out.print("\n ID does not exist");
    }

    public static void editCustomerName(Customer customer){
            System.out.print("\nEnter new customer name ex: Le Thi Minh ");
            String name = EnterData.enterName();
            customer.setName(name);
        CustomerRepository.writeToFile(customers);
    }

    public static void editPhoneNumber(Customer customer){
            System.out.print("\nEnter a new phone number ex: 0135 068 9022 ");
            String phoneNumber = EnterData.enterPhoneNumber();
            customer.setPhoneNumber(phoneNumber);
        CustomerRepository.writeToFile(customers);
    }

    public static void deleteCustomer(int id){
//        listTrouble.removeIf(trouble -> trouble.getId() == id);
        for (Customer customer: customers) {
            if (customer.getId() == id) {
                customers.remove(customer);
                CustomerRepository.writeToFile(customers);
                System.out.print("\nDelete successfully");
                return;
            }
        }
        System.out.print("\n ID does not exist");
    }

    public static Customer searchCustomerWithPhoneNumber(String phoneNumber){
        for (Customer customer: customers) {
            if (phoneNumber.equals(customer.getPhoneNumber())){
                return customer;
            }
        }
        System.out.print("\n ID does not exist");
        return null;
    }

    public static Customer searchCustomer(int id){
        for (Customer customer: customers) {
            if (id == customer.getId()){
                return customer;
            }
        }
        System.out.print("\n ID does not exist");
        return null;
    }

    public static boolean checkRegistration(Customer customer){
        return listTicket.stream().anyMatch(ticket -> ticket.getCustomerID() == customer.getId());
    }

    public static void deleteAllCustomersNotRegister(){
        customers.removeIf(customer -> !checkRegistration(customer));
        System.out.print("\nRemoved all unregistered customers");
    }

    public static boolean checkIDCustomer(int id){
        for (Customer customer: customers) {
            if (customer.getId() == id)
                return true;
        }
        return false;
    }
}