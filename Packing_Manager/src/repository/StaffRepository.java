package repository;

import model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static sevice.EnterData.StringToDate;
import static sevice.EnterData.TOTAL_PACKING_SPACES;

public class StaffRepository {
    public static final String dataStaff = "D:\\New folder\\Packing_Manager\\src\\data\\staffs.txt";

    public static ArrayList readFile(String fileName){
        ArrayList <Staff> listStaff = new ArrayList<>();
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] words=data.split(",");

                Staff staff = new Staff();
                staff.setIDNumber(words[0]);
                String word = words[1];
                if (!(word.isEmpty()) && !word.equalsIgnoreCase("null"))
                    staff.setName(word);

                word = words[2];
                if (!(word.isEmpty()) && !word.equalsIgnoreCase("null"))
                    staff.setPhoneNumber(word);

                word = words[3];
                if (!(word.isEmpty()) && !word.equalsIgnoreCase("null"))
                    staff.setPosition(Position.from(Integer.parseInt(word)));

                word = words[4];
                if (!(word.isEmpty()) && !word.equalsIgnoreCase("null"))
                    staff.setUserName(word);

                word = words[5];
                if (!(word.isEmpty()) && !word.equalsIgnoreCase("null"))
                    staff.setPassword(word);
                word = words[6];
                if (!(word.isEmpty()) && !word.equalsIgnoreCase("null"))
                    staff.setSalary(Double.parseDouble(word));
                listStaff.add(staff);
            }
            myReader.close();
            return listStaff;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static void writeToFile(List<Staff> staffList) {
        try {
            FileWriter writer = new FileWriter(dataStaff);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (Staff staff : staffList) {
                bufferedWriter.write(staff.toString());
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
}
