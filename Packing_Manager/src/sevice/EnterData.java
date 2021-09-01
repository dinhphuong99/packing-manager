package sevice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EnterData {
    public static final int TOTAL_PACKING_SPACES = 15;
    public static int enterInteger(){
        int choice;
        Scanner scanner = new Scanner(System.in);
        try {
            choice = scanner.nextInt();
        }catch (Exception e){
            System.out.println("The input value must be an integer!");
            choice = enterInteger();
        }
        return choice;
    }

    public static long enterLong(){
        long choice;
        Scanner scanner = new Scanner(System.in);
        try {
            choice = scanner.nextLong();
        }catch (Exception e){
            System.out.println("The input invalid!");
            choice = enterInteger();
        }
        return choice;
    }

    public static float enterFloat(){
        float choice;
        Scanner scanner = new Scanner(System.in);
        try {
            choice = scanner.nextFloat();
        }catch (Exception e){
            System.out.println("The input value must be a real number!");
            choice = enterFloat();
        }
        return choice;
    }

    public static double enterDouble(){
        double choice;
        Scanner scanner = new Scanner(System.in);
        try {
            choice = scanner.nextDouble();
        }catch (Exception e){
            System.out.println("The input value must be a real number!");
            choice = enterDouble();
        }
        return choice;
    }

    public static int enterIDTicket(){
        int idTemp = enterInteger();

        while (idTemp <= 0) {
            System.out.print("\nEnter number > 0");
        }
        return idTemp;
    }

    public static String enterPhoneNumber(){
        String phoneNumber = null;
        Matcher matcher = null;
        do {
            phoneNumber = (new Scanner(System.in)).nextLine();
            Pattern pattern = Pattern.compile("^[0][1-9]{2}[ ][0-9]{3}[ ][0-9]{4}$");
            matcher = pattern.matcher(phoneNumber);
        }while (!matcher.find());

        return phoneNumber;
    }

    public static String enterName(){
        String name = null;
        Matcher matcher = null;
        do {
            name = (new Scanner(System.in)).nextLine();
            Pattern pattern = Pattern.compile("^[A-Z]{1}[a-z]+([ ][A-Z]{1}[a-z]+)+$");
            matcher = pattern.matcher(name);
        }while (!matcher.find());

        return name;
    }

    public static Date StringToDate(String s){

        Date result = null;
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            result  = dateFormat.parse(s);
        }

        catch(ParseException e){
            e.printStackTrace();

        }
        return result ;
    }

    public static float hourDiff(Date startTime, Date endTime){
        long milisecond = endTime.getTime() - startTime.getTime();
        long a = 1000*60*60;
        return (milisecond / a);
    }

    public static boolean dayCheck(){
        LocalDateTime dateTime = LocalDateTime.now();
        int hourNow = dateTime.getHour();
        return hourNow >= 6 && hourNow <= 18;
    }

    public static Date plusDay(Date startTime, int addDay){
        Calendar c = Calendar.getInstance();
        try{
            c.setTime(startTime);
        }catch(Exception e){
            e.printStackTrace();
        }

        c.add(Calendar.DAY_OF_MONTH, addDay);
        //String newDate = sdf.format(c.getTime());
        Date date = c.getTime();

        return date;
    }

    public static String enterIDNumber(){
        String name = null;
        Matcher matcher = null;
        do {
            name = (new Scanner(System.in)).nextLine();
            Pattern pattern = Pattern.compile("^[0-9]+$");
            matcher = pattern.matcher(name);
        }while (!matcher.find());

        return name;
    }

    public static String enterUserName(){
        String name = null;
        Matcher matcher = null;
        do {
            name = (new Scanner(System.in)).nextLine();
            Pattern pattern = Pattern.compile("^[a-zA-Z][a-zA-Z0-9]{5,29}+$");
            matcher = pattern.matcher(name);
        }while (!matcher.find());

        return name;
    }

    public static String enterPassWord(){
        String name = null;
        Matcher matcher = null;
        do {
            name = (new Scanner(System.in)).nextLine();
            Pattern pattern = Pattern.compile("^[a-zA-Z0-9][a-zA-Z0-9@#$%]{5,29}$");
            matcher = pattern.matcher(name);
        }while (!matcher.find());

        return name;
    }

    public static double enterSalary(){
        double salary = enterDouble();
        while (!(salary > 0)) {
            System.out.print("\n Enter salary > 0: ");
            salary = enterDouble();
        }
        return salary;
    }

    public static Date enterDateWithString(){
        Date date;
        Scanner scanner = new Scanner(System.in);
        try {
            date = StringToDate(scanner.nextLine());
        }catch (Exception e){
            System.out.println("Enter malformed string yyyy-MM-dd HH:mm:ss");
            date = enterDateWithString();
        }
        return date;
    }


}