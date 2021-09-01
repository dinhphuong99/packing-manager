package sevice;

import model.Position;
import model.Staff;

import java.util.Objects;
import java.util.Scanner;

import static java.lang.System.exit;

public class LogIn {
    public static Staff staff;
    public static void LoginStart(){
        System.out.print("\nEnter account name: ");
        String userName = (new Scanner(System.in).nextLine());
        System.out.print("\nEnter password: ");
        String password = (new Scanner(System.in).nextLine());
        staff = StaffService.loginUserNameAndPassWord(userName,password);

        if (staff == null)
        {
            System.out.println("Enter 0 to re-enter");
            int choice = EnterData.enterInteger();
            if (choice == 0)
                LoginStart();
            else
                exit(0);
        }else
            if (staff.getPosition() == Position.ADMIN)
                AdminViewMenu.MenuAdmin();
            else if (staff.getPosition() == Position.CAR_KEEPER)
                CarKeeperView.menuCarKeeper();
            else if (staff.getPosition() == Position.VALET)
                VeletViewMenu.menuVeletView();
    }
}
