// Main.java — Students version
import java.io.*;
import java.util.*;

public class Main {
    static final int MONTHS = 12;
    static final int DAYS = 28;
    static final int COMMS = 5;
    static String[] commodities = {"Gold", "Oil", "Silver", "Wheat", "Copper"};
    static String[] months = {"January","February","March","April","May","June",
            "July","August","September","October","November","December"};

    static int [][][] profit =new int [MONTHS][DAYS][COMMS];
    // ======== REQUIRED METHOD LOAD DATA (Students fill this) ========
    public static void loadData() {
    }

    // ======== 10 REQUIRED METHODS (Students fill these) ========

    public static String mostProfitableCommodityInMonth(int month) {

        if (month < 0 || month >= MONTHS) {
            return "INVALID_MONTH";
        }
        int mostProfitVal = profit[month][0][0];
        int bestCommodity = 0;
        for (int c=0;c<COMMS;c++) {
            int sum = 0;
            for (int d=0;d<DAYS;d++){
                sum+=profit[month][d][c]; }
            if (sum>mostProfitVal){
                mostProfitVal=sum;
                bestCommodity = c; }
        }
        return commodities[bestCommodity] + " " + mostProfitVal ;
    }


    public static int totalProfitOnDay(int month, int day) {
        if (month<0 || month >= MONTHS){
            return -99999;}
        if (day<1 || day > DAYS){
            return -99999;}
        int d= day - 1;
        int totProfitsAllComms = 0;
        for (int c=0; c<COMMS;c++){
            totProfitsAllComms+= profit[month][d][c];
        }
        return totProfitsAllComms;
    }

    public static int commodityProfitInRange(String commodity, int from, int to) {
        int c = -1;

        // commodity index (exact match, case-sensitive)
        for (int i = 0; i < COMMS; i++) {
            if (commodities[i].equals(commodity)) {
                c = i;
                break;
            }
        }
        if (c == -1) return -99999;

        // range checks
        if (from < 1 || from > DAYS || to < 1 || to > DAYS || from > to) return -99999;

        int t = 0;
        for (int m = 0; m < MONTHS; m++) {
            for (int d = from - 1; d <= to - 1; d++) { // to included
                t += profit[m][d][c];
            }
        }

        return t;
    }

        // check all months
        for (int m = 0; m < MONTHS; m++) {
            for (int d = from - 1; d <= to - 1; d++) { // to included
                t += profit[m][d][c];
            } int c = -1;

            // commodity index (exact match, case-sensitive)
            for (int i = 0; i < COMMS; i++) {
                if (commodities[i].equals(commodity)) {
                    c = i;
                    break;
                }
            }
            if (c == -1) return -99999;

            // range checks
            if (from < 1 || from > DAYS || to < 1 || to > DAYS || from > to) return -99999;

            int t = 0;

            // check all months
            for (int m = 0; m < MONTHS; m++) {
                for (int d = from - 1; d <= to - 1; d++) { // to included
                    t += profit[m][d][c];
                } }

            return t;
        }
    }

    public static int bestDayOfMonth(int month) {
        if (month < 0 || month >= MONTHS) {
            return -1;
        }
        int bestDay = 1;
        int maxProfit = Integer.MIN_VALUE;
        for (int day = 1; day <= DAYS; day++) {
            int d = day - 1;
            int sum = 0;
            for (int c = 0; c < COMMS; c++) {
                sum += profit[month][d][c];
            }
            if (sum > maxProfit) {
                maxProfit = sum;
                bestDay = day;
            }
        }
        return bestDay;
    }
    public static String bestMonthForCommodity(String comm) {
        return "DUMMY";
    }

    public static int consecutiveLossDays(String comm) {
        return 1234;
    }

    public static int daysAboveThreshold(String comm, int threshold) {
        return 1234;
    }

    public static int biggestDailySwing(int month) {
        return 1234;
    }

    public static String compareTwoCommodities(String c1, String c2) {
        return "DUMMY is better by 1234";
    }

    public static String bestWeekOfMonth(int month) {
        return "DUMMY";
    }

    public static void main(String[] args) {
        loadData();
        System.out.println("Data loaded – ready for queries");
    }
}
