package repository;

import model.Customer;
import model.Trouble;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerRepository {
    public static final String dataCustomer = "D:\\New folder\\Packing_Manager\\src\\data\\customers.txt";

    public static ArrayList readFile(String fileName){
        ArrayList <Customer> customers = new ArrayList<>();
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] words=data.split(",");

                Customer customer = new Customer();
                customer.setId(Integer.parseInt(words[0]));
                String word = words[1];
                if (!(word.isEmpty()) && !word.equalsIgnoreCase("null"))
                    customer.setName(word);

                word = words[2];
                if (!(word.isEmpty()) && !word.equalsIgnoreCase("null"))
                    customer.setPhoneNumber(word);

                customers.add(customer);
            }
            myReader.close();
            return customers;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        //System.out.print("\nNo customers yet");
        return new ArrayList<>();
    }

    public static void writeToFile(List<Customer> customers) {
        try {
            FileWriter writer = new FileWriter(dataCustomer);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (Customer customer : customers) {
                bufferedWriter.write(customer.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
