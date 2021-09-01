package sevice;

import model.*;
import repository.FareRepository;
import repository.TicketRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static repository.FareRepository.dataFare;

public class FareSevice {
    public static List<Fare> listFare = FareRepository.readFile(dataFare);

    public static void editAll() {
        FareRepository.writeToFile(dataFare);
        for (Fare fare : listFare) {
            System.out.print("\nEnter fare type 0(single pass fare) 1(monthly fare): ");
            int type = EnterData.enterInteger();
            while (type != 0 && type != 1) {
                System.out.print("\nEnter 0 or 1 ");
                type = EnterData.enterInteger();
            }
            fare.setFareType(FareType.from(type));

            System.out.print("\nEnter price: ");
            double price = EnterData.enterDouble();
            while (price <= 0){
                System.out.print("\n Enter number >0 ");
                price = EnterData.enterDouble();
            }
            fare.setPrice(price);
            FareRepository.saveToFile((ArrayList<Fare>) listFare);
        }
    }

    public static void changePrice(FareType fareType) {
        for (Fare fare : listFare) {
            if (fareType == fare.getFareType()) {
                System.out.print("\nEnter price: ");
                double price = EnterData.enterDouble();
                fare.setPrice(price);
                FareRepository.saveToFile((ArrayList<Fare>) listFare);
                return;
            }
        }
        System.out.print("\nNot find fare type");
    }

    public static double getFare(int fareType) {
        for (Fare fare : listFare) {
            if (fareType == fare.getFareType().getValue()) {
                return fare.getPrice();
            }
        }
        return 0;
    }

//    public static void main(String[] args) {
//        //FareRepository.writeToFile(dataFare);
//        //FareSevice.editAllInfo();
//        for (Fare fare: listFare) {
//            System.out.println(getFare(1));
//        }
//    }
}
