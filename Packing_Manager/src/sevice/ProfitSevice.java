package sevice;

import model.GrossProfit;
import model.Trouble;
import repository.GrossProfitRepository;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static repository.GrossProfitRepository.dataSendAndReceive;

public class ProfitSevice {
    public static List<GrossProfit> grossProfits = GrossProfitRepository.readFile(dataSendAndReceive);

    public static int getNewID(){
        List<GrossProfit> grossProfitList = GrossProfitRepository.readFile(dataSendAndReceive);
        int IDNewAdd = -1;
        if (grossProfitList.size() == 0)
            IDNewAdd = 1;
        else {
            for (int i = 2; IDNewAdd == -1; i++) {
                for (GrossProfit value : grossProfitList) {
                    if (i != value.getID()) {
                        IDNewAdd = i;
                    }

                    if (i == value.getID()) {
                        IDNewAdd = -1;
                        break;
                    }
                }
            }
        }
        return IDNewAdd;
    }
    public static double grossProfitin30Days (Date startTime){
        double sum = 0;
        Date endDate = EnterData.plusDay(startTime,30);
        for (GrossProfit sar: grossProfits) {
            if (startTime.compareTo(sar.getStartDate()) <= 0 && 0 <= endDate.compareTo(sar.getStartDate())){
                sum += sar.getPrice();
            }
        }
        return sum;
    }

    public static double netProfitIn30Days(Date startTime){
        return grossProfitin30Days(startTime) + TroubleSevice.theTotalAmountFor30Days(startTime) - StaffService.sumSalaryIn30Days();
    }

    public static void deleteInforBefore (Date startTime){
        Date endDate = EnterData.plusDay(startTime,30);
        for (GrossProfit sar: grossProfits) {
            if (0 <= startTime.compareTo(sar.getStartDate())){
                grossProfits.remove(sar);
            }
            GrossProfitRepository.writeToFile(grossProfits);
        }
    }

    public static void main(String[] args) {
        Date date = EnterData.StringToDate("2021-08-20 07:28:12");
        System.out.println(grossProfitin30Days(date));
        deleteInforBefore(date);
        System.out.println(netProfitIn30Days(date));
    }
}
