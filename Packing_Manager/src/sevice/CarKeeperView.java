package sevice;

import model.Staff;
import model.TicketType;

import java.util.Objects;

import static java.lang.System.exit;
import static sevice.StaffService.listStaff;
import static sevice.LogIn.staff;

public class CarKeeperView {
    public static void menuCarKeeper() {
        int choice;
        while (true) {
            System.out.println("Menu");
            System.out.println("1. Give ticket");
            System.out.println("2. Get ticket");
            System.out.println("3. View staff");
            System.out.println("4. Edit staff");
            System.out.println("0. Exit");
            System.out.print("\nEnter your choice: ");
            choice = EnterData.enterInteger();

            if (choice == 0)
                exit(0);

            switch (choice) {
                case 1 -> giveTicket();
                case 2 -> getTicket();
                case 3 -> viewStaff();
                case 4 -> editStaff();
                default -> System.out.println("No choice");
            }
        }
    }

    public static void giveTicket() {
        System.out.println("Give ticket");
        TicketSevice.giveSinglePass();
    }

    public static void getTicket() {
        System.out.println("Get ticket");
        System.out.print("\nEnter Id");
        int id = EnterData.enterIDTicket();
        if (TicketType.SinglePass == TicketSevice.checkTypeTicket(id))
            TicketSevice.getSinglePass(id);
    }

    public static void viewStaff() {
        System.out.println("List staff:");
        System.out.println("Name                  Phone Number       Position         Salary");
        for (Staff staff : listStaff) {
            System.out.println(staff.printfToConsoleStaff());
        }
    }

    public static void editStaff() {
        System.out.println("Edit information of a staff");
        int choice;
        while (true) {
            System.out.print("\nEnter 0 to exit");
            int ex = EnterData.enterInteger();
            if (ex == 0)
                break;

            System.out.println("1. Edit an staff's name");
            System.out.println("2. Edit an staff's phone number");
            System.out.println("3. Edit an staff's user name");
            System.out.println("4. Edit an staff's password");
            System.out.println("0. Exit");
            System.out.print("\nEnter your choice: ");
            choice = EnterData.enterInteger();
            switch (choice) {
                case 1 -> {
                    System.out.println("All information");
                    System.out.println("IDNumber       Name                  " +
                            "Phone Number       Position      UserName       Password         Salary");
                    Objects.requireNonNull(staff).printfToConsoleAdmin();
                    System.out.println("Edit an staff's name");
                    StaffService.editNameStaff(Objects.requireNonNull(staff));
                }
                case 2 -> {
                    System.out.println("All information");
                    System.out.println("IDNumber       Name                  " +
                            "Phone Number       Position      UserName       Password         Salary");
                    Objects.requireNonNull(staff).printfToConsoleAdmin();
                    System.out.println("Edit an staff's phone number");
                    StaffService.editPhoneNumberStaff(Objects.requireNonNull(staff));
                }
                case 3 -> {
                    System.out.println("All information");
                    System.out.println("IDNumber       Name                  " +
                            "Phone Number       Position      UserName       Password         Salary");
                    Objects.requireNonNull(staff).printfToConsoleAdmin();
                    System.out.println("Edit an staff's user name");
                    StaffService.editUserNameStaff(Objects.requireNonNull(staff));
                }
                case 4 -> {
                    System.out.println("All information");
                    System.out.println("IDNumber       Name                  " +
                            "Phone Number       Position      UserName       Password         Salary");
                    Objects.requireNonNull(staff).printfToConsoleAdmin();
                    System.out.println("Edit an staff's password");
                    StaffService.editPassWordStaff(Objects.requireNonNull(staff));
                }
                default -> System.out.println("No choice");
            }
        }
    }


}
