package sevice;

import model.Position;
import model.Staff;
import repository.StaffRepository;

import java.util.List;

import static repository.StaffRepository.dataStaff;

public class StaffService {
    public static List<Staff> listStaff = StaffRepository.readFile(dataStaff);

    public static void addStaff() {
        Staff staff = new Staff();
        System.out.print("\n Enter ID number: ");
        String IDTemp = EnterData.enterIDNumber();
        staff.setIDNumber(IDTemp);
        System.out.print("\nEnter employee name ex: Le Thi Minh: ");
        String name = EnterData.enterName();
        staff.setName(name);
        System.out.print("\nEnter employee phone number ex: 038 068 9024: ");
        String phoneNumber = EnterData.enterPhoneNumber();
        staff.setPhoneNumber(phoneNumber);
        System.out.print("\nEnter position 0 (admin), 1 (car keeper), 2 (valet): ");
        int position = EnterData.enterInteger();
        while (true) {
            if (position == 0 || position == 1 || position == 2)
                break;
            System.out.print("\n Enter 0, 1 or 2: ");
            position = EnterData.enterInteger();
        }
        staff.setPosition(Position.from(position));

        System.out.print("\nEnter user name ex:eDisc13 ");
        String userName = EnterData.enterUserName();
        staff.setUserName(userName);

        System.out.print("\nEnter password ex:1Effs@#$%");
        String passWord = EnterData.enterPassWord();
        staff.setPassword(passWord);

        System.out.print("\nEnter salary:");
        double salary = EnterData.enterSalary();
        staff.setSalary(salary);
        listStaff.add(staff);
        StaffRepository.writeToFile(listStaff);
    }

    public static void editAllInforStaff(String idNumber) {
        for (Staff staff : listStaff) {
            if (staff.getIDNumber().equals(idNumber)) {
                System.out.print("\nRe-enter employee name ex: Le Thi Minh: ");
                String name = EnterData.enterName();
                staff.setName(name);
                System.out.print("\nRe-enter employee phone number ex: 038 068 9022: ");
                String phoneNumber = EnterData.enterPhoneNumber();
                staff.setPhoneNumber(phoneNumber);
                System.out.print("\nRe-enter position 0 (admin), 1 (car keeper), 2 (valet): ");
                int position = EnterData.enterInteger();
                while (position != 0 && position != 1 && position != 2) {
                    System.out.print("\n Re-enter 0, 1 or 2: ");
                    position = EnterData.enterInteger();
                }
                staff.setPosition(Position.from(position));

                System.out.print("\nRe-enter user name ex:eDisc13 ");
                String userName = EnterData.enterUserName();
                staff.setUserName(userName);

                System.out.print("\nRe-enter password ex:1Effs@#$%");
                String passWord = EnterData.enterPassWord();
                staff.setPassword(passWord);

                System.out.print("\nEnter salary:");
                double salary = EnterData.enterSalary();
                staff.setSalary(salary);
                listStaff.add(staff);
                StaffRepository.writeToFile(listStaff);
                return;
            }
        }
        System.out.print("\n ID does not exist");
    }

    public static void editSalaryStaff(Staff staff) {
        System.out.print("\nEnter salary:");
        double salary = EnterData.enterSalary();
        staff.setSalary(salary);
        StaffRepository.writeToFile(listStaff);
    }

    public static void editPositonStaff(Staff staff) {
        System.out.print("\nRe-enter position 0 (admin), 1 (car keeper), 2 (valet): ");
        int position = EnterData.enterInteger();
        while (position != 0 && position != 1 && position != 2) {
            System.out.print("\n Re-enter 0, 1 or 2: ");
            position = EnterData.enterInteger();
        }
        staff.setPosition(Position.from(position));
        StaffRepository.writeToFile(listStaff);
    }

    public static void editPassWordStaff(Staff staff) {
        System.out.print("\nRe-enter password ex:1Effs@#$%");
        String passWord = EnterData.enterPassWord();
        staff.setPassword(passWord);
        StaffRepository.writeToFile(listStaff);
    }

    public static void editUserNameStaff(Staff staff) {
        System.out.print("\nRe-enter user name ex:eDisc13 ");
        String userName = EnterData.enterUserName();
        staff.setUserName(userName);
        StaffRepository.writeToFile(listStaff);
    }

    public static void editPhoneNumberStaff(Staff staff) {
        System.out.print("\nRe-enter employee phone number ex: 037 068 9023: ");
        String phoneNumber = EnterData.enterPhoneNumber();
        staff.setPhoneNumber(phoneNumber);
        StaffRepository.writeToFile(listStaff);
    }

    public static void editNameStaff(Staff staff) {
        System.out.print("\nRe-enter employee name ex: Le Thi Minh: ");
        String name = EnterData.enterName();
        staff.setName(name);
        StaffRepository.writeToFile(listStaff);
    }

    public static void deleteStaff(String id) {
//        listTrouble.removeIf(trouble -> trouble.getId() == id);
        for (Staff staff : listStaff) {
            if (staff.getIDNumber().equals(id)) {
                listStaff.remove(staff);
                StaffRepository.writeToFile(listStaff);
                System.out.print("\nDelete successfully");
                return;
            }
        }
        System.out.print("\n ID does not exist");
    }

    public static Staff searchStaff(String id) {
        for (Staff staff : listStaff) {
            if (staff.getIDNumber().equals(id)) {
                return staff;
            }
        }
        System.out.print("\n ID does not exist");
        return null;
    }

    public static Staff searchStaffWithPhoneNumber(String phoneNumber) {
        for (Staff staff : listStaff) {
            if (staff.getPhoneNumber().equals(phoneNumber)) {
                return staff;
            }
        }
        System.out.print("\n ID does not exist");
        return null;
    }

    public static double sumSalaryIn30Days() {
        double sum = 0;
        for (Staff staff : listStaff) {
            sum += staff.getSalary();
        }
        return sum;
    }

    public static Staff loginUserNameAndPassWord(String userName, String passWord){
        for (Staff staff : listStaff) {
            if (staff.getUserName().equals(userName) && staff.getPassword().equals(passWord)) {
                return staff;
            }
        }
        System.out.print("\nUser account or password incorrect");
        return null;
    }

    public static boolean checkIdNumber(String id){
        for (Staff staff : listStaff) {
            if (staff.getIDNumber().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        addStaff();
//        addStaff();
//        addStaff();

        for (Staff staff: listStaff) {
            System.out.println(staff.printfToConsoleAdmin());
        }
    }
}
