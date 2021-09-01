package sevice;

import model.*;
import repository.GrossProfitRepository;
import repository.TicketRepository;

//import static repository.GrossProfitRepository.*;
import static repository.TicketRepository.*;
import static sevice.EnterData.StringToDate;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TicketSevice {
    public static List <Ticket>listTicket = TicketRepository.readFile(dataTicket);

    public static void giveSinglePass(){
        for (Ticket ticket : listTicket) {
            if (ticket.getStatus() == TicketStatus.AVAILABLE) {
                ticket.setStatus(TicketStatus.UNAVAILABLE);
                ticket.setType(TicketType.SinglePass);
                Date startDate = new Date();
                ticket.setStartDate(startDate);
                double price = FareSevice.getFare(0);
                if (EnterData.dayCheck())
                    ticket.setPrice(price);
                else
                    ticket.setPrice(price*1.5);
                GrossProfitRepository.insertToFile(ticket);
                TicketRepository.writeToFile(listTicket);
                break;
            }
        }
    }

    public static void getSinglePass(int id){
        for (Ticket ticket : listTicket) {
            if (ticket.getId()==id) {
                ticket.setStatus(TicketStatus.AVAILABLE);
                ticket.setType(TicketType.SinglePass);
                Date startDate = new Date();
                ticket.setStartDate(startDate);
                ticket.setPrice(0);
                TicketRepository.writeToFile(listTicket);
                return;
            }
        }
        System.out.println("ID does not exist");
    }

    public static TicketType checkTypeTicket(int id){
        for (Ticket ticket : listTicket) {
            if (ticket.getId()==id) {
                return ticket.getType();
            }
        }
        System.out.println("ID does not exist");
        return null;
    }

    public static void SignUpForAMonthlyTicket(int idCustomer){
        Ticket ticket = getTicketsAvailable();
        if (ticket != null) {
            ticket.setStatus(TicketStatus.UNAVAILABLE);
            ticket.setType(TicketType.Monthly);
            Date startDate = new Date();
            ticket.setStartDate(startDate);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);
            calendar.add(Calendar.DATE, 30);
            Date expiredDate = calendar.getTime();
            ticket.setEndDate(expiredDate);
            ticket.setCustomerID(idCustomer);
            ticket.setPrice(FareSevice.getFare(1));
            TicketRepository.writeToFile(listTicket);
            GrossProfitRepository.insertToFile(ticket);
            //StatisticRepository.writeToFileStatistic(listTicket);
        } else {
            System.out.println("No more tickets available");
        }
    }

    public static Ticket getTicketsAvailable() {
        for (Ticket t : listTicket) {
            if (t.getStatus() == TicketStatus.AVAILABLE)
                return t;
        }
        return null;
    }

    public static void withdrawMonthlyTicket() {
        Date currentDate = new Date();
        for (Ticket ticket : listTicket) {
            if (ticket.getType() == TicketType.Monthly
                    && ticket.getStatus() == TicketStatus.UNAVAILABLE
                    && ticket.getEndDate().before(currentDate)) {
                ticket.setStatus(TicketStatus.AVAILABLE);
                ticket.setType(TicketType.SinglePass);
                ticket.setEndDate(StringToDate(null));
                ticket.setStartDate(StringToDate(null));
                ticket.setCustomerID(0);
                ticket.setPrice(0);
            }
        }
        TicketRepository.writeToFile(listTicket);
    }

    public static void revokeSinglePass() {
        Date currentDate = new Date();
        for (Ticket ticket : listTicket) {
            if (ticket.getType() == TicketType.SinglePass
                    && ticket.getStatus() == TicketStatus.UNAVAILABLE
                    && EnterData.hourDiff(ticket.getEndDate(), currentDate) >= 7.5) {
                ticket.setStatus(TicketStatus.AVAILABLE);
                ticket.setType(TicketType.SinglePass);
                ticket.setEndDate(StringToDate(null));
                ticket.setStartDate(StringToDate(null));
                ticket.setPrice(0);
            }
        }
        TicketRepository.writeToFile(listTicket);
    }

    public static void revokeSinglePass(int id) {
        Date currentDate = new Date();
        for (Ticket ticket : listTicket) {
            if (ticket.getId() != id || ticket.getType() != TicketType.SinglePass
                    || ticket.getStatus() != TicketStatus.UNAVAILABLE
                    || !(EnterData.hourDiff(ticket.getEndDate(), currentDate) >= 7.5)) {
                continue;
            }
            ticket.setStatus(TicketStatus.AVAILABLE);
            ticket.setType(TicketType.SinglePass);
            ticket.setEndDate(StringToDate(null));
            ticket.setStartDate(StringToDate(null));
            ticket.setPrice(0);
            break;
        }
        TicketRepository.writeToFile(listTicket);
    }

    public static List<Ticket> checkOverdueParking(){
        Date currentDate = new Date();
        List<Ticket> expiredTicketList = null;
        for (Ticket ticket : listTicket) {
            if (ticket.getStatus() == TicketStatus.UNAVAILABLE
                    && (EnterData.hourDiff(ticket.getEndDate(), currentDate) >= 6
                    ||ticket.getEndDate().before(currentDate))) {
                expiredTicketList.add(ticket);
            }
        }
        return expiredTicketList;
    }

    public static Ticket searchMonthyTicket(int idCustomer){
        for (Ticket ticket: listTicket) {
            if (ticket.getCustomerID() == idCustomer)
                return ticket;
        }
        return null;
    }

    public static boolean checkIDTicket(int id){
        for (Ticket ticket: listTicket) {
            if (ticket.getId() == id)
                return true;
        }
        return false;
    }

//    public static String printToConsole(Ticket ticket){
//        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        return String.format("%5d%20s%15s%25s%25s%5d%5f",
//                ticket.getId(),(ticket.getType()!=null?String.valueOf(ticket.getType().getValue()):" " ),
//                ticket.getStatus(),
//                (ticket.getStartDate()!=null?formatter.format(ticket.getStartDate()): " "),
//                (ticket.getEndDate()!=null?formatter.format(ticket.getEndDate()): " "),
//                ticket.getCustomerID(), ticket.getPrice());
//    }

    public static void main(String[] args) {
//
        System.out.println("Thông tin từ file: ");
        for (Ticket t : listTicket) {
            System.out.println(t.toString());
        }

        TicketSevice.giveSinglePass();
        TicketSevice.SignUpForAMonthlyTicket(1);
        TicketSevice.SignUpForAMonthlyTicket(2);
        TicketSevice.SignUpForAMonthlyTicket(3);
        TicketSevice.giveSinglePass();
        TicketSevice.withdrawMonthlyTicket();
        System.out.println("Sau khi thay đổi: ");
        for (Ticket t : listTicket) {
            System.out.println(t.printToConsole());
        }
    }
}