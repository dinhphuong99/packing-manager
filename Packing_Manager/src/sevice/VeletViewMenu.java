package sevice;

import model.Customer;
import model.Fare;
import model.FareType;

import java.util.Date;
import java.util.Objects;

import static java.lang.System.exit;
import static sevice.CustomerSevice.customers;
import static sevice.FareSevice.listFare;

public class VeletViewMenu {
    public static void menuVeletView() {
        int choice;
        while (true) {
            System.out.println("Menu");
            System.out.println("1. Customer");
            System.out.println("2. Fare");
            System.out.println("3. Ticket");
            System.out.println("4. Trouble");
            System.out.println("0. Exit");
            System.out.print("\nEnter your choice: ");
            choice = EnterData.enterInteger();
            if (choice == 0)
                exit(0);
            switch (choice){
                case 1:
                    System.out.println("Customer");
                    customerMethod();
                    break;
                case 2:
                    System.out.println("Fare");
                    fareMethod();
                    break;
                case 3:
                    System.out.println("Ticket");
                    ticketMethod();
                    break;
                case 4:
                    System.out.println("Trouble");
                    troubleMethod();
                    break;
            }
        }
    }

    public static void customerMethod() {
        int choice;
        while (true) {
            System.out.println("Menu");
            System.out.println("1. View list customer");
            System.out.println("2. Add a customer");
            System.out.println("3. Edit customer information");
            System.out.println("4. Delete customer");
            System.out.println("5. Search a customer");
            System.out.println("6. Sign up for a monthly ticket");
            System.out.println("0. Exit");
            System.out.print("\nEnter your choice: ");
            choice = EnterData.enterInteger();
            if (choice == 0)
                break;

            switch (choice) {
                case 1:
                    System.out.println("View list");
                    for (Customer customer: customers) {
                        customer.printToConsole();
                    }
                case 2:
                    System.out.println("Add a customer");
                    CustomerSevice.addCustomer();
                    break;
                case 3:
                    System.out.println("Edit customer information");
                    editCustomer();
                    break;
                case 4:
                    System.out.println("Delete customer");
                    deleteCustomer();
                    break;
                case 5:
                    System.out.println("Search customer");
                    System.out.print("Enter phone number ex:094 645 3624");
                    String str = EnterData.enterPhoneNumber();
                    Customer customer = CustomerSevice.searchCustomerWithPhoneNumber(str);
                    if (customer != null)
                        customer.printToConsole();
                case 6:
                    System.out.println("Sign up for a monthly ticket");
                    System.out.print("\nEnter id customer: ");
                    int id = EnterData.enterIDTicket();
                    Customer customer1 = CustomerSevice.searchCustomer(id);
                    if (CustomerSevice.checkIDCustomer(id)){
                        assert customer1 != null;
                        customer1.printToConsole();
                        System.out.println("0(OK) 1(Exit)");
                        int c = EnterData.enterInteger();
                        if (c==0)
                            TicketSevice.SignUpForAMonthlyTicket(id);
                    }
                    break;
                default:
                    System.out.println("No choice");
            }
        }
    }

    public static void editCustomer() {
        int choice;
        System.out.println("Edit information of a customer");
        while (true) {
            System.out.print("\nEnter 0 to exit");
            int ex = EnterData.enterInteger();
            if (ex == 0)
                break;
            System.out.print("\nEnter id customer");
            int id = EnterData.enterIDTicket();

            if (CustomerSevice.checkIDCustomer(id)) {
                System.out.println("Menu");
                System.out.println("1. Delete a customer");
                System.out.println("2. Edit customer name");
                System.out.println("3. Edit customer phone number");
                System.out.println("0. Exit");
                System.out.print("\nEnter your choice: ");
                choice = EnterData.enterInteger();
                if (choice == 0)
                    break;

                switch (choice) {
                    case 1:
                        System.out.println("Edit all information of an customer");
                        CustomerSevice.editAllInfoCustomer(id);
                        break;
                    case 2:
                        System.out.println("Edit customer name");
                        CustomerSevice.editCustomerName(Objects.requireNonNull(CustomerSevice.searchCustomer(id)));
                        break;
                    case 3:
                        System.out.println("Edit customer phone number");
                        CustomerSevice.editPhoneNumber(Objects.requireNonNull(CustomerSevice.searchCustomer(id)));
                    default:
                        System.out.println("No choice");
                }
            } else {
                System.out.println("ID number does not available");
                break;
            }
        }
    }

    public static void deleteCustomer() {
        int choice;
        System.out.println("Delete customer");
        while (true) {

            System.out.println("1. Delete a customer ");
            System.out.println("2. Delete customers who do not register for monthly tickets");
            System.out.println("0. Exit");
            System.out.print("\nEnter your choice: ");
            choice = EnterData.enterInteger();
            if (choice == 0)
                break;

            switch (choice) {
                case 1 -> {
                    System.out.println("Delete a customer");
                    System.out.print("\nEnter id customer");
                    int id = EnterData.enterIDTicket();
                    if (CustomerSevice.checkIDCustomer(id))
                        CustomerSevice.editAllInfoCustomer(id);
                    else
                        System.out.print("\n ID does not exist");
                }
                case 2 -> {
                    System.out.println("Delete customers who do not register for monthly tickets");
                    CustomerSevice.deleteAllCustomersNotRegister();
                }
                default -> System.out.println("No choice");
            }
        }
    }

    public static void fareMethod(){
        int choice;
        while (true) {
            System.out.println("Menu");
            System.out.println("1. View list fare");
            System.out.println("2. Edit All");
            System.out.println("3. Change fare");
            System.out.println("0. Exit");
            System.out.print("\nEnter your choice: ");
            choice = EnterData.enterInteger();
            if (choice == 0)
                break;

            switch (choice) {
                case 1:
                    System.out.println("View list");
                    for (Fare fare: listFare) {
                        fare.printToConsole();
                    }
                case 2:
                    System.out.println("Edit All");
                    FareSevice.editAll();
                    break;
                case 3:
                    System.out.println("Change fare");
                    System.out.print("\nEnter fare type 0(single pass fare) 1(monthly fare): ");
                    int type = EnterData.enterInteger();
                    while (type != 0 && type != 1) {
                        System.out.print("\nEnter 0 or 1 ");
                        type = EnterData.enterInteger();
                    }

                    FareType fareType = FareType.from(type);
                    FareSevice.changePrice(fareType);
                    editCustomer();
                    break;
                default:
                    System.out.println("No choice");
            }
        }
    }

    public static void ticketMethod(){
        int choice;
        while (true) {
            System.out.println("Menu");
            System.out.println("1. View list ticket");
            System.out.println("2. Single Ticket withdrawal");
            System.out.println("3. Monthly Ticket withdrawal");
            System.out.println("0. Exit");
            System.out.print("\nEnter your choice: ");
            choice = EnterData.enterInteger();
            if (choice == 0)
                break;

            switch (choice) {
                case 1 -> {
                    System.out.println("View list");
                    for (Fare fare : listFare) {
                        fare.printToConsole();
                    }
                }
                case 2 -> {
                    System.out.println("Single Ticket withdrawal");
                    System.out.print("\n Enter ID ticket");
                    int id = EnterData.enterInteger();
                    if (TicketSevice.checkIDTicket(id))
                        TicketSevice.revokeSinglePass(id);
                    else
                        System.out.println("ID does not exist");
                }
                case 3 -> {
                    System.out.println("Revoke all expired monthly tickets");
                    TicketSevice.withdrawMonthlyTicket();
                    System.out.println("Successful recovery");
                }
                default -> System.out.println("No choice");
            }
        }
    }

    public static void troubleMethod(){
        while (true){
            System.out.println("1. View the list trouble");
            System.out.println("2. Add a trouble");
            System.out.println("3. Edit trouble");
            System.out.println("4. Delete a trouble");
            System.out.println("5. Search trouble");
            System.out.println("0. Exit");
            System.out.print("\nEnter your choice: ");
            int choice = EnterData.enterInteger();
            if (choice == 0)
                break;

            switch (choice){
                case 1:
                    System.out.println("View list");
                    for (Fare fare: listFare) {
                        fare.printToConsole();
                    }
                    break;
                case 2:
                    System.out.println("Add a trouble");
                    TroubleSevice.addReport();
                    break;
                case 3:
                    System.out.println("Edit a trouble");
                    editTrouble();
                    break;
                case 4:
                    System.out.println("Delete a trouble");
                case 5:
                    System.out.println("Search a trouble with ID ticket");
                    System.out.print("\nEnter ID ticket");
                    int idTicket = EnterData.enterIDTicket();
                    if(TroubleSevice.checkIDTicket(idTicket))
                        TroubleSevice.searchReportWithIDTicket(idTicket);
                    else
                        System.out.println("ID does not exist");
            }
        }
    }

    public static void editTrouble(){
        while (true){
            System.out.println("1. Edit all information of a trouble");
            System.out.println("2. Edit ID ticket");
            System.out.println("3. Edit description");
            System.out.println("4. Edit date");
            System.out.println("5. Edit into money");
            System.out.println("6. Edit solution");
            System.out.println("0. Exit");
            System.out.print("\nEnter your choice: ");
            int choice = EnterData.enterInteger();
            if (choice == 0)
                break;
            int id;
            switch (choice) {
                case 1 -> {
                    System.out.println("Edit all information of a trouble");
                    System.out.print("\nEnter ID");
                    id = EnterData.enterIDTicket();
                    if (TroubleSevice.checkIDReport(id))
                        TroubleSevice.editReportAll(id);
                    else
                        System.out.println("ID does not exist");
                }
                case 2 -> {
                    System.out.println("Edit ID ticket");
                    System.out.print("\nEnter ID");
                    id = EnterData.enterIDTicket();
                    if (TroubleSevice.checkIDReport(id))
                        TroubleSevice.editIDTicketReport(Objects.requireNonNull(TroubleSevice.searchReport(id)));
                    else
                        System.out.println("ID does not exist");
                }
                case 3 -> {
                    System.out.println("Edit description");
                    System.out.print("\nEnter ID");
                    id = EnterData.enterIDTicket();
                    if (TroubleSevice.checkIDReport(id))
                        TroubleSevice.editDescriptionReport(Objects.requireNonNull(TroubleSevice.searchReport(id)));
                    else
                        System.out.println("ID does not exist");
                }
                case 4 -> {
                    System.out.println("Edit date");
                    System.out.print("\nEnter ID");
                    id = EnterData.enterIDTicket();
                    if (TroubleSevice.checkIDReport(id))
                        TroubleSevice.editDateReport(Objects.requireNonNull(TroubleSevice.searchReport(id)));
                    else
                        System.out.println("ID does not exist");
                }
                case 5 -> {
                    System.out.println("Edit into money");
                    System.out.print("\nEnter ID");
                    id = EnterData.enterIDTicket();
                    if (TroubleSevice.checkIDReport(id))
                        TroubleSevice.editIntoMoneyReport(Objects.requireNonNull(TroubleSevice.searchReport(id)));
                    else
                        System.out.println("ID does not exist");
                }
                case 6 -> {
                    System.out.println("Edit solution");
                    System.out.print("\nEnter ID");
                    id = EnterData.enterIDTicket();
                    if (TroubleSevice.checkIDReport(id))
                        TroubleSevice.editSolutionReport(Objects.requireNonNull(TroubleSevice.searchReport(id)));
                    else
                        System.out.println("ID does not exist");
                }
                default -> System.out.println("No choice");
            }
        }
    }

    public static void deleteTrouble(){
        while (true){
            System.out.println("1. Delete a trouble");
            System.out.println("2. Clear all troubles before date");
            System.out.println("0. Exit");
            System.out.print("\nEnter your choice: ");
            int choice = EnterData.enterInteger();
            if (choice == 0)
                break;
            int id;
            switch (choice) {
                case 1 -> {
                    System.out.println("Delete a trouble");
                    System.out.print("\nEnter ID");
                    id = EnterData.enterIDTicket();
                    if (TroubleSevice.checkIDReport(id))
                        TroubleSevice.deleteReport(id);
                    else
                        System.out.println("ID does not exist");
                }
                case 2 -> {
                    System.out.println("Clear all troubles before date");
                    System.out.print("\nEnter date");
                    Date date = EnterData.enterDateWithString();
                    TroubleSevice.deleteTroubleBeforeDate(date);
                }
                default -> System.out.println("No choice");
            }
        }
    }
}
