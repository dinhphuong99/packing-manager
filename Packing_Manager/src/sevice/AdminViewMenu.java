package sevice;

import model.GrossProfit;
import model.Staff;

import java.util.Date;
import java.util.Objects;

import static java.lang.System.exit;
import static sevice.ProfitSevice.grossProfits;
import static sevice.StaffService.listStaff;

public class AdminViewMenu {
    public static void MenuAdmin() {
        int choice;
        while (true) {
            System.out.println("Menu");
            System.out.println("1. View the list staff");
            System.out.println("2. Add a staff");
            System.out.println("3. Edit staff");
            System.out.println("4. Delete a staff");
            System.out.println("5. Search staff");
            System.out.println("6. View stats");
            System.out.println("0. Exit");
            System.out.print("\nEnter your choice: ");
            choice = EnterData.enterInteger();
            if (choice == 0)
                exit(0);

            switch (choice) {
                case 1 -> viewListStaff();
                case 2 -> addAStaff();
                case 3 -> editStaff();
                case 4 -> deleteStaff();
                case 5 -> searchStaff();
                case 6 -> viewStas();
                default -> System.out.println("No choice");
            }
        }
    }

    //return String.format("%20s%30s%15s%20s%20s%15s%10f",
//    private String IDNumber;
//    private String name;
//    private String phoneNumber;
//    private Position position;
//    private String userName;
//    private String password;
//    private double salary;
    public static void viewListStaff() {
        System.out.println("List staff:");
        System.out.println("IDNumber       Name                  " +
                "Phone Number       Position      UserName       Password         Salary");
        for (Staff staff : listStaff) {
            System.out.println(staff.printfToConsoleAdmin());
        }
    }

    public static void addAStaff() {
        System.out.println("Add a staff");
        StaffService.addStaff();
    }

    public static void editStaff() {
        System.out.println("Edit information of a staff");
        int choice;
        while (true) {
            System.out.print("\nEnter 0 to exit");
            int ex = EnterData.enterInteger();
            if (ex == 0)
                break;
            System.out.print("\nEnter staff's ID number");
            String id = EnterData.enterIDNumber();

            if (StaffService.checkIdNumber(id)) {
                System.out.println("1. Edit all information of an staff");
                System.out.println("2. Edit an staff's name");
                System.out.println("3. Edit an staff's phone number");
                System.out.println("4. Edit an staff's position");
                System.out.println("5. Edit an staff's user name");
                System.out.println("6. Edit an staff's password");
                System.out.println("7. Edit an staff's salary");
                System.out.println("0. Exit");
                System.out.print("\nEnter your choice: ");
                choice = EnterData.enterInteger();
                switch (choice) {
                    case 1 -> {
                        System.out.println("All information");
                        System.out.println("IDNumber       Name                  " +
                                "Phone Number       Position      UserName       Password         Salary");
                        Objects.requireNonNull(StaffService.searchStaff(id)).printfToConsoleAdmin();
                        System.out.println("Edit all information of an staff");
                        StaffService.editAllInforStaff(id);
                    }
                    case 2 -> {
                        System.out.println("All information");
                        System.out.println("IDNumber       Name                  " +
                                "Phone Number       Position      UserName       Password         Salary");
                        Objects.requireNonNull(StaffService.searchStaff(id)).printfToConsoleAdmin();
                        System.out.println("Edit an staff's name");
                        StaffService.editNameStaff(Objects.requireNonNull(StaffService.searchStaff(id)));
                    }
                    case 3 -> {
                        System.out.println("All information");
                        System.out.println("IDNumber       Name                  " +
                                "Phone Number       Position      UserName       Password         Salary");
                        Objects.requireNonNull(StaffService.searchStaff(id)).printfToConsoleAdmin();
                        System.out.println("Edit an staff's phone number");
                        StaffService.editPhoneNumberStaff(Objects.requireNonNull(StaffService.searchStaff(id)));
                    }
                    case 4 -> {
                        System.out.println("All information");
                        System.out.println("IDNumber       Name                  " +
                                "Phone Number       Position      UserName       Password         Salary");
                        Objects.requireNonNull(StaffService.searchStaff(id)).printfToConsoleAdmin();
                        System.out.println("Edit an staff's position");
                        StaffService.editPositonStaff(Objects.requireNonNull(StaffService.searchStaff(id)));
                    }
                    case 5 -> {
                        System.out.println("All information");
                        System.out.println("IDNumber       Name                  " +
                                "Phone Number       Position      UserName       Password         Salary");
                        Objects.requireNonNull(StaffService.searchStaff(id)).printfToConsoleAdmin();
                        System.out.println("Edit an staff's user name");
                        StaffService.editUserNameStaff(Objects.requireNonNull(StaffService.searchStaff(id)));
                    }
                    case 6 -> {
                        System.out.println("All information");
                        System.out.println("IDNumber       Name                  " +
                                "Phone Number       Position      UserName       Password         Salary");
                        Objects.requireNonNull(StaffService.searchStaff(id)).printfToConsoleAdmin();
                        System.out.println("Edit an staff's password");
                        StaffService.editPassWordStaff(Objects.requireNonNull(StaffService.searchStaff(id)));
                    }
                    case 7 -> {
                        System.out.println("All information");
                        System.out.println("IDNumber       Name                  " +
                                "Phone Number       Position      UserName       Password         Salary");
                        Objects.requireNonNull(StaffService.searchStaff(id)).printfToConsoleAdmin();
                        System.out.println("Edit an staff's salary");
                        StaffService.editSalaryStaff(Objects.requireNonNull(StaffService.searchStaff(id)));
                    }
                    default -> System.out.println("No choice");
                }
            } else {
                System.out.println("ID number does not available");
                break;
            }
        }
    }

    public static void deleteStaff() {
        System.out.println("Delete a staff");
        System.out.print("\nEnter staff's ID number");
        String id = EnterData.enterIDNumber();
        System.out.println("All information");
        System.out.println("IDNumber       Name                  " +
                "Phone Number       Position      UserName       Password         Salary");
        Objects.requireNonNull(StaffService.searchStaff(id)).printfToConsoleAdmin();
        if (StaffService.checkIdNumber(id))
            StaffService.deleteStaff(id);
        else
            System.out.println("ID number does not available");
    }

    public static void searchStaff() {
        System.out.println("Search a staff");
        System.out.print("\nEnter staff's ID number");
        String id = EnterData.enterIDNumber();
        System.out.println("All information");
        System.out.println("IDNumber       Name                  " +
                "Phone Number       Position      UserName       Password         Salary");
        Objects.requireNonNull(StaffService.searchStaff(id)).printfToConsoleAdmin();
    }

    public static void viewStas() {
        System.out.println("View statistic");
        System.out.println("1. See all stats");
        System.out.println("2. Gross profit in 30 days");
        System.out.println("3. Net profit in 30 days");
        System.out.println("4. Delete old information");
        System.out.println("0. Exit");
        int choice;
        //"%5d%5d%20s%15s%25s%25s%5d%5f
        Date date;
        while (true) {
            choice = EnterData.enterInteger();

            if (choice == 0)
                break;

            switch (choice) {
                case 1 -> {
                    System.out.println("See all stats");
                    System.out.println("ID    ID Ticket   Ticket Type     " +
                            "Status     Start Day              End Day            IDCustomer   Price");
                    for (GrossProfit gross : grossProfits) {
                        System.out.println(gross.printToConsole());
                    }
                }
                case 2 -> {
                    System.out.println("Gross profit in 30 days");
                    System.out.print("\nEnter string date ex: 2021-12-25 12:30:35");
                    date = EnterData.enterDateWithString();
                    System.out.println(ProfitSevice.grossProfitin30Days(date));
                }
                case 3 -> {
                    System.out.println("Net profit in 30 days");
                    System.out.print("\nEnter string date ex: 2021-12-25 12:30:35");
                    date = EnterData.enterDateWithString();
                    System.out.println(ProfitSevice.grossProfitin30Days(date));
                }
                case 4 -> {
                    System.out.println("Delete old information");
                    System.out.print("\nEnter string date ex: 2021-12-25 12:30:35");
                    date = EnterData.enterDateWithString();
                    ProfitSevice.deleteInforBefore(date);
                }
                default -> System.out.println("No choice");
            }
        }
    }
}
