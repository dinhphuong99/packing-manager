package sevice;

import model.Trouble;
import repository.TroubleRepository;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static repository.TroubleRepository.dataTrouble;

public class TroubleSevice {
    public static List<Trouble> listTrouble = TroubleRepository.readFile(dataTrouble);

    public static int getNewID() {
        int IDNewAdd = -1;
        if (listTrouble.size() == 0)
            IDNewAdd = 0;
        else {
            for (int i = 0; IDNewAdd == -1; i++) {
                for (Trouble value : listTrouble) {
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

    public static void addReport() {
        Trouble trouble = new Trouble();
        trouble.setId(getNewID());
        System.out.print("\nEnter ID Ticket: ");
        int addIDTicket = EnterData.enterIDTicket();
        trouble.setIdTicket(addIDTicket);
        System.out.print("\nEnter description: ");
        String description = (new Scanner(System.in)).nextLine();
        trouble.setDescription(description);
        System.out.print("\nEnter the amount: ");
        double intoMoney = EnterData.enterDouble();
        trouble.setIntoMoney(intoMoney);
        System.out.print("\nEnter solution: ");
        String solution = (new Scanner(System.in)).nextLine();
        trouble.setSolutions(solution);
        listTrouble.add(trouble);
        System.out.print("\nEnter date: ");
        Date date = EnterData.enterDateWithString();
        trouble.setDate(date);
        TroubleRepository.writeToFile(listTrouble);
    }

    public static void editReportAll(int id) {
        for (Trouble trouble : listTrouble) {
            if (trouble.getId() != id) {
                continue;
            }
            System.out.print("\nEnter new ID Ticket: ");
            int addIDTicket = EnterData.enterIDTicket();
            trouble.setIdTicket(addIDTicket);
            System.out.print("\nEnter new description: ");
            String description = (new Scanner(System.in)).nextLine();
            trouble.setDescription(description);
            System.out.print("\nEnter new amount: ");
            double intoMoney = EnterData.enterDouble();
            trouble.setIntoMoney(intoMoney);
            System.out.print("\nEnter new solution: ");
            String solution = (new Scanner(System.in)).nextLine();
            trouble.setSolutions(solution);
            System.out.print("\nEnter new date: ");
            Date date = EnterData.enterDateWithString();
            trouble.setDate(date);
            TroubleRepository.writeToFile(listTrouble);
            return;
        }
        System.out.print("\n ID does not exist");
    }

    public static void editIntoMoneyReport(Trouble trouble) {
        System.out.print("\nEnter new amount: ");
        double intoMoney = EnterData.enterDouble();
        trouble.setIntoMoney(intoMoney);
        TroubleRepository.writeToFile(listTrouble);
    }

    public static void editIDTicketReport(Trouble trouble) {
        System.out.print("\nEnter new ID Ticket: ");
        int addIDTicket = EnterData.enterIDTicket();
        trouble.setIdTicket(addIDTicket);
        TroubleRepository.writeToFile(listTrouble);
    }

    public static void editDateReport(Trouble trouble) {
        System.out.print("\nEnter new date: ");
        Date date = EnterData.enterDateWithString();
        trouble.setDate(date);
        TroubleRepository.writeToFile(listTrouble);
    }

    public static void editSolutionReport(Trouble trouble) {
        System.out.print("\nEnter new solution: ");
        String solution = (new Scanner(System.in)).nextLine();
        trouble.setSolutions(solution);
        TroubleRepository.writeToFile(listTrouble);
    }

    public static void editDescriptionReport(Trouble trouble) {
        System.out.print("\nEnter new description: ");
        String description = (new Scanner(System.in)).nextLine();
        trouble.setDescription(description);
        TroubleRepository.writeToFile(listTrouble);
    }

    public static void deleteReport(int id) {
//        listTrouble.removeIf(trouble -> trouble.getId() == id);
        for (Trouble trouble : listTrouble) {
            if (trouble.getId() == id) {
                listTrouble.remove(trouble);
                TroubleRepository.writeToFile(listTrouble);
                System.out.print("\nDelete successfully");
                return;
            }
        }
        System.out.print("\n ID does not exist");
    }

    public static Trouble searchReportWithIDTicket(int idTicket) {
        for (Trouble trouble : listTrouble) {
            if (trouble.getIdTicket() == idTicket) {
                return trouble;
            }
        }
        System.out.print("\n ID does not exist");
        return null;
    }

    public static Trouble searchReport(int id) {
        for (Trouble trouble : listTrouble) {
            if (trouble.getId() == id) {
                return trouble;
            }
        }
        System.out.print("\n ID does not exist");
        return null;
    }

    public static boolean checkIDReport(int id) {
        for (Trouble trouble : listTrouble) {
            if (trouble.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkIDTicket(int idTicket) {
        for (Trouble trouble : listTrouble) {
            if (trouble.getIdTicket() == idTicket) {
                return true;
            }
        }
        return false;
    }

    public static void deleteTroubleBeforeDate(Date startTime) {
        Date endDate = EnterData.plusDay(startTime, 30);
        for (Trouble trouble : listTrouble) {
            if (0 <= startTime.compareTo(trouble.getDate())) {
                listTrouble.remove(trouble);
            }
            TroubleRepository.writeToFile(listTrouble);
        }
    }

    public static void troubleStatisticsFor30Days(Date startTime) {
        Date endDate = EnterData.plusDay(startTime, 30);
        for (Trouble trouble : listTrouble) {
            if (startTime.compareTo(trouble.getDate()) <= 0 && 0 <= endDate.compareTo(trouble.getDate())) {
                System.out.print("\n" + trouble.printToConsole());
            }
        }
    }

    public static double theTotalAmountFor30Days(Date startTime) {
        double sum = 0;
        Date endDate = EnterData.plusDay(startTime, 30);
        for (Trouble trouble : listTrouble) {
            if (startTime.compareTo(trouble.getDate()) <= 0 && 0 <= endDate.compareTo(trouble.getDate())) {
                sum += trouble.getIntoMoney();
            }
        }
        return sum;
    }
}
