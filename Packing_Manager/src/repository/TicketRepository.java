package repository;

import model.Ticket;
import model.TicketStatus;
import model.TicketType;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static sevice.EnterData.StringToDate;
import static sevice.EnterData.TOTAL_PACKING_SPACES;

public class TicketRepository {
    public static final String dataTicket = "D:\\New folder\\Packing_Manager\\src\\data\\tickets.txt";

//    public static ArrayList<Ticket> getAll() {
//        try {
//            ArrayList<Ticket> tickets = new ArrayList<Ticket>();
//            File file = new File(dataTicket);
//            BufferedReader br = new BufferedReader(new FileReader(file));
//            String line;
//            while ((line = br.readLine()) != null) {
//                String[] words = line.split(",");
//                Ticket ticket = new Ticket();
//                ticket.setId(Integer.parseInt(words[0]));
//                String word = words[1];
//                if (!(word.isEmpty()) && !word.equalsIgnoreCase("null"))
//                    ticket.setType(TicketType.from(Integer.parseInt(word)));
//
//                word = words[2];
//                if (!(word.isEmpty()) && !word.equalsIgnoreCase("null"))
//                    ticket.setStatus(TicketStatus.from(Integer.parseInt(word)));
//
//                word = words[3];
//                if (!(word.isEmpty()) && !word.equalsIgnoreCase("null"))
//                    ticket.setStartDate(StringToDate(word));
//
//                word = words[4];
//                if (!(word.isEmpty()) && !word.equalsIgnoreCase("null"))
//                    ticket.setEndDate(StringToDate(word));
//
//                word = words[5];
//                if (!(word.isEmpty()) && !word.equalsIgnoreCase("null"))
//                    tickets.add(ticket);
//            }
//            br.close();
//            return tickets;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return new ArrayList<>();
//    }

    public static ArrayList readFile(String fileName){
        ArrayList <Ticket> listTicket = new ArrayList<>();
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] words=data.split(",");

                Ticket ticket = new Ticket();
                ticket.setId(Integer.parseInt(words[0]));
                String word = words[1];
                if (!(word.isEmpty()) && !word.equalsIgnoreCase("null"))
                    ticket.setType(TicketType.from(Integer.parseInt(word)));

                word = words[2];
                if (!(word.isEmpty()) && !word.equalsIgnoreCase("null"))
                    ticket.setStatus(TicketStatus.from(Integer.parseInt(word)));

                word = words[3];
                if (!(word.isEmpty()) && !word.equalsIgnoreCase("null"))
                    ticket.setStartDate(StringToDate(word));

                word = words[4];
                if (!(word.isEmpty()) && !word.equalsIgnoreCase("null"))
                    ticket.setEndDate(StringToDate(word));

                word = words[5];
                if (!(word.isEmpty()) && !word.equalsIgnoreCase("null"))
                    ticket.setCustomerID(Integer.parseInt(word));

                word = words[6];
                if (!(word.isEmpty()) && !word.equalsIgnoreCase("null"))
                    ticket.setPrice(Double.parseDouble(word));

                listTicket.add(ticket);
            }
            myReader.close();
            return listTicket;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static void writeToFile(List<Ticket> tickets) {
        try {
            FileWriter writer = new FileWriter(dataTicket);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (Ticket ticket : tickets) {
                bufferedWriter.write(ticket.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToFile1(String filePath) {
        try {
            FileWriter writer = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (int i = 1; i <= TOTAL_PACKING_SPACES; i++) {
                String str = "" + i + "" +
                        "," + "null" +
                        "," + 0 +
                        "," + "null" +
                        "," + "null" +
                        "," + 0 +
                        "," + 0 + "\n";
                bufferedWriter.write(str);
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TicketRepository.writeToFile1(dataTicket);
    }
}
