package repository;

import model.GrossProfit;
import model.Ticket;
import model.TicketStatus;
import model.TicketType;
import sevice.ProfitSevice;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static sevice.EnterData.StringToDate;

public class GrossProfitRepository {
    public static final String dataSendAndReceive = "D:\\New folder\\Packing_Manager\\src\\data\\statistics.txt";

    public static ArrayList readFile(String fileName) {
        ArrayList<GrossProfit> listSR = new ArrayList<>();
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] words = data.split(",");

                GrossProfit grossProfit = new GrossProfit();
                grossProfit.setID(Integer.parseInt(words[0]));
                String word = words[1];
                if (!(word.isEmpty()) && !word.equalsIgnoreCase("null"))
                    grossProfit.setID(Integer.parseInt(word));

                word = words[2];
                if (!(word.isEmpty()) && !word.equalsIgnoreCase("null"))
                    grossProfit.setType(TicketType.from(Integer.parseInt(word)));

                word = words[3];
                if (!(word.isEmpty()) && !word.equalsIgnoreCase("null"))
                    grossProfit.setStatus(TicketStatus.from(Integer.parseInt(word)));

                word = words[4];
                if (!(word.isEmpty()) && !word.equalsIgnoreCase("null"))
                    grossProfit.setStartDate(StringToDate(word));

                word = words[5];
                if (!(word.isEmpty()) && !word.equalsIgnoreCase("null"))
                    grossProfit.setEndDate(StringToDate(word));

                word = words[6];
                if (!(word.isEmpty()) && !word.equalsIgnoreCase("null"))
                    grossProfit.setCustomerID(Integer.parseInt(word));

                word = words[7];
                if (!(word.isEmpty()) && !word.equalsIgnoreCase("null"))
                    grossProfit.setPrice(Double.parseDouble(word));

                listSR.add(grossProfit);
            }
            myReader.close();
            return listSR;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static void writeToFile(List<GrossProfit> listSR) {
        try {
            FileWriter writer = new FileWriter(dataSendAndReceive);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (GrossProfit grossProfit : listSR) {
                bufferedWriter.write(grossProfit.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void insertToFile(Ticket ticket) {
        GrossProfit grossProfit = new GrossProfit(ticket);
        grossProfit.setID(ProfitSevice.getNewID());
        ProfitSevice.grossProfits = GrossProfitRepository.readFile(dataSendAndReceive);
        try {
            FileWriter writer = new FileWriter(dataSendAndReceive, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(grossProfit.toString());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
