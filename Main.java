public class Main {
    public static void printBonusDatesBetween(int fromYear, int toYear){
        if(fromYear>toYear){
            int tmp = fromYear;
            fromYear = toYear;
            toYear = tmp;
        }
        int actualYear = fromYear;
        while(actualYear<toYear){
            int actualYearLength = Integer.toString(actualYear).length();
            if(actualYearLength<=3){
                goTroughDates(actualYear);
            }
            else {
                if ((actualYear % ((actualYearLength - 3) * 10) >= 2 || actualYear % (actualYearLength - 2) * 10 >= 13)) {
                } else if ((actualYear / 10 * (actualYearLength - 2)) % 10 > 3) {
                } else {
                    goTroughDates(actualYear);
                }
            }
            actualYear++;
        }
    }
    public static void goTroughDates(int actualYear){
        int date = actualYear*10000+100+1;
        int days = 1;
        int monthCounter = 1;
        int numberOfDays;
        int numberOfDaysFebruary;
        if ((actualYear % 4 == 0 && actualYear % 100 != 0) || actualYear%400 == 0) {
            numberOfDays = 366;
            numberOfDaysFebruary = 29;
        }
        else{
            numberOfDays = 365;
            numberOfDaysFebruary = 28;
        }
        for (int i = 0; i < numberOfDays; i++) {
            String dateStr = Integer.toString(date);
            char[] dateArr = dateStr.toCharArray();
            if(dateArr[0]==dateArr[dateArr.length-1]){
                boolean reversed = false;
                for(int j = 1; j<=(dateArr.length-2)/2; j++){
                    if(dateArr[j] == dateArr[(dateArr.length-1)-j]){
                        reversed = true;
                    }
                    else{
                        reversed = false;
                        break;
                    }
                }
                if(reversed){
                    String dateToPrint = "";
                    for(int j = 0; j< dateArr.length-4; j++){
                        dateToPrint = dateToPrint+dateArr[j];
                    }
                    dateToPrint = dateToPrint+"-"+dateArr[dateArr.length-4]+dateArr[dateArr.length-3]+"-"+dateArr[dateArr.length-2]+dateArr[dateArr.length-1];

                    System.out.println(dateToPrint);
                }
            }
            switch (monthCounter) {
                case 1, 3, 5, 7, 8, 10:{
                    if(days%31==0){
                        monthCounter++;
                        date = date+100-30;
                        days = 1;
                    }
                    else {
                        date++;
                        days++;
                    }
                    break;
                }
                case 2:{
                    if(days%numberOfDaysFebruary==0){
                        monthCounter++;
                        date = date+100-numberOfDaysFebruary+1;
                        days=1;
                    }
                    else {
                        date++;
                        days++;
                    }
                    break;
                }case 4, 6, 9, 11:{
                    if(days%30==0){
                        monthCounter++;
                        date = date+100-29;
                        days=1;
                    }
                    else {
                        date++;
                        days++;
                    }
                    break;
                }
                case 12:{
                    if(days%31==0){

                    }
                    else {
                        date++;
                        days++;
                    }
                    break;
                }
            }
        }
    }
    public static void main(String[] args) {
        printBonusDatesBetween(2010, 2015);
    }
}