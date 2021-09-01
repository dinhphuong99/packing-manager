package repository;

import model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static sevice.EnterData.StringToDate;

public class FareRepository {
    public static final String dataFare="D:\\New folder\\Packing_Manager\\src\\data\\fares.txt";

    public static void saveToFile( ArrayList<Fare> fares){
        try {
            FileWriter writer = new FileWriter(dataFare);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (Fare fare:fares) {
                bufferedWriter.write(fare.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToFile(String filePath){
        try {
            FileWriter writer = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (int i = 1; i <= 2; i++) {
                String str = "" + i + "" +
                        "," + "null" +
                        "," + "null" +"\n";
                bufferedWriter.write(str);
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Fare> readFile(String dataFare) {
        ArrayList <Fare> listFare = new ArrayList<>();
        try {
            File myObj = new File(dataFare);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] words=data.split(",");

                Fare fare = new Fare();
                fare.setID(Integer.parseInt(words[0]));
                String word = words[1];
                if (!(word.isEmpty()) && !word.equalsIgnoreCase("null"))
                    fare.setFareType(FareType.from(Integer.parseInt(word)));

                word = words[2];
                if (!(word.isEmpty()) && !word.equalsIgnoreCase("null"))
                    fare.setPrice(Float.parseFloat(word));

                listFare.add(fare);
            }
            myReader.close();
            return listFare;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
