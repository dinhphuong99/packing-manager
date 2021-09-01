package repository;
import model.Trouble;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TroubleRepository {
    public static final String dataTrouble = "D:\\New folder\\Packing_Manager\\src\\data\\troubles.txt";

    public static ArrayList readFile(String fileName){
        ArrayList <Trouble> troubles = new ArrayList<>();
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] words=data.split(",");

                Trouble trouble = new Trouble();
                trouble.setId(Integer.parseInt(words[0]));
                String word = words[1];
                if (!(word.isEmpty()) && !word.equalsIgnoreCase("null"))
                    trouble.setIdTicket(Integer.parseInt(word));

                word = words[2];
                if (!(word.isEmpty()) && !word.equalsIgnoreCase("null"))
                    trouble.setDescription(word);

                word = words[3];
                if (!(word.isEmpty()) && !word.equalsIgnoreCase("null"))
                    trouble.setIntoMoney(Double.parseDouble(word));

                word = words[4];
                if (!(word.isEmpty()) && !word.equalsIgnoreCase("null"))
                    trouble.setSolutions(word);

                troubles.add(trouble);
            }
            myReader.close();
            return troubles;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static void writeToFile(List<Trouble> troubles) {
        try {
            FileWriter writer = new FileWriter(dataTrouble);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (Trouble trouble : troubles) {
                bufferedWriter.write(trouble.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
