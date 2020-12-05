import java.io.*;

public class Transaction {
    //c=current p=pick r=return b=birth//
    final static int MONTHS_DAYS = 30, MONTHS = 12; //lets assume that 30 days is one month for every month in this program
    private Customer aCustomer;
    private Car aCar;
    private int month = 0, days = 0;

    private String cMonth;
    private int cDate, cYear;

    private String pMonth;
    private int pDate, pYear;

    private String rMonth;
    private int rDate, rYear;

    private String bMonth;
    private int bDate;
    private int bYear;

    public Transaction() { //constructor
        aCustomer = new Customer();
        aCar = new Car();
        cMonth = "";
        cDate = 0;
        cYear = 0;
        pMonth = "";
        pDate = 0;
        pYear = 0;
        rMonth = "";
        rDate = 0;
        rYear = 0;
        bMonth = "";
        bDate = 0;
        bYear = 0;
    }

    public void setTransaction(Customer cU, Car cA, String m, int d, int y, String pM, int pD, int pY, String rM, int rD, int rY, String bM, int bD, int bY) { //constructor
        aCustomer = cU;
        aCar = cA;
        cMonth = m;
        cDate = d;
        cYear = y;
        pMonth = pM;
        pDate = pD;
        pYear = pY;
        rMonth = rM;
        rDate = rD;
        rYear = rY;
        bMonth = bM;
        bDate = bD;
        bYear = bY;
    }

    public String getCurrentMonth() {
        return cMonth;
    }

    public int getCurrentDate() {
        return cDate;
    }

    public int getCurrentYear() {
        return cYear;
    }

    //getting the value of current month//
    public int getCurrentMonthValue() {
        switch (getCurrentMonth()) {
            case "Jan":
                month = 1;
                break;
            case "Feb":
                month = 2;
                break;
            case "Mar":
                month = 3;
                break;
            case "Apr":
                month = 4;
                break;
            case "May":
                month = 5;
                break;
            case "Jun":
                month = 6;
                break;
            case "Jul":
                month = 7;
                break;
            case "Aug":
                month = 8;
                break;
            case "Sep":
                month = 9;
                break;
            case "Oct":
                month = 10;
                break;
            case "Nov":
                month = 11;
                break;
            case "Dec":
                month = 12;
                break;
        }

        return month;
    }

    public String getPickMonth() {
        return pMonth;
    }

    public int getPickDate() {
        return pDate;
    }

    public int getPickYear() {
        return pYear;
    }

    //getting the value of pick up month//
    public int getPickMonthValue() {
        switch (getPickMonth()) {
            case "Jan":
                month = 1;
                break;
            case "Feb":
                month = 2;
                break;
            case "Mar":
                month = 3;
                break;
            case "Apr":
                month = 4;
                break;
            case "May":
                month = 5;
                break;
            case "Jun":
                month = 6;
                break;
            case "Jul":
                month = 7;
                break;
            case "Aug":
                month = 8;
                break;
            case "Sep":
                month = 9;
                break;
            case "Oct":
                month = 10;
                break;
            case "Nov":
                month = 11;
                break;
            case "Dec":
                month = 12;
                break;
        }

        return month;
    }

    public String getReturnMonth() {
        return rMonth;
    }

    public int getReturnDate() {
        return rDate;
    }

    public int getReturnYear() {
        return rYear;
    }

    //getting the value of return month//
    public int getReturnMonthValue() {
        switch (getReturnMonth()) {
            case "Jan":
                month = 1;
                break;
            case "Feb":
                month = 2;
                break;
            case "Mar":
                month = 3;
                break;
            case "Apr":
                month = 4;
                break;
            case "May":
                month = 5;
                break;
            case "Jun":
                month = 6;
                break;
            case "Jul":
                month = 7;
                break;
            case "Aug":
                month = 8;
                break;
            case "Sep":
                month = 9;
                break;
            case "Oct":
                month = 10;
                break;
            case "Nov":
                month = 11;
                break;
            case "Dec":
                month = 12;
                break;
        }

        return month;
    }

    public String getBirthMonth() {
        return bMonth;
    }

    public int getBirthDate() {
        return bDate;
    }

    public int getBirthYear() {
        return bYear;
    }

    // //getting the value of birth month//
    public int getBirthMonthValue() {
        switch (getBirthMonth()) {
            case "Jan":
                month = 1;
                break;
            case "Feb":
                month = 2;
                break;
            case "Mar":
                month = 3;
                break;
            case "Apr":
                month = 4;
                break;
            case "May":
                month = 5;
                break;
            case "Jun":
                month = 6;
                break;
            case "Jul":
                month = 7;
                break;
            case "Aug":
                month = 8;
                break;
            case "Sep":
                month = 9;
                break;
            case "Oct":
                month = 10;
                break;
            case "Nov":
                month = 11;
                break;
            case "Dec":
                month = 12;
                break;
        }

        return month;
    }

    //getting the age//
    public int getAge() {

        int age = 0;
        if ((getCurrentYear() > getBirthYear()) && (getCurrentMonthValue() == getBirthMonthValue())) {
            if (getCurrentDate() == getBirthDate())
                age = getCurrentYear() - getBirthYear();

            else if (getCurrentDate() < getBirthDate())
                age = getCurrentYear() - getBirthYear();

            else if (getCurrentDate() > getBirthDate())
                age = (getCurrentYear() - 1) - getBirthYear();
        } else if ((getCurrentYear() > getBirthYear()) && (getCurrentMonthValue() > getBirthMonthValue()))
            age = getCurrentYear() - getBirthYear();

        else if ((getCurrentYear() > getBirthYear()) && (getCurrentMonthValue() < getBirthMonthValue()))
            age = (getCurrentYear() - 1) - getBirthYear();

        return age;
    }

    //for getting How many days javaDoc.Car has been rented//
    public int getDays() {

        int totalMonth, totalYear;

        if ((getPickYear() == getReturnYear()) && (getPickMonthValue() == getReturnMonthValue())) {
            if (getPickDate() == getReturnDate())
                days = 0;
            else if (getPickDate() < getReturnDate())
                days = getReturnDate() - getPickDate();
        } else if ((getPickYear() == getReturnYear()) && (getPickMonthValue() < getReturnMonthValue())) {
            if (getPickDate() == getReturnDate()) {
                totalMonth = getReturnMonthValue() - getPickMonthValue();
                days = totalMonth * MONTHS_DAYS;
            } else if (getPickDate() < getReturnDate()) {
                totalMonth = getReturnMonthValue() - getPickMonthValue();
                days = (totalMonth * MONTHS_DAYS) + (getReturnDate() - getPickDate());
            }
        } else if (getPickYear() < getReturnYear()) {
            if (getPickMonthValue() == getReturnMonthValue()) {
                totalYear = getReturnYear() - getPickYear();
                days = ((totalYear * MONTHS) * MONTHS_DAYS) + (getReturnDate() - getPickDate());
            } else if (getPickMonthValue() < getReturnMonthValue()) {
                totalMonth = getReturnMonthValue() - getPickMonthValue();
                days = ((totalMonth + MONTHS) * MONTHS_DAYS) + (getReturnDate() - getPickDate());
            } else if (getPickMonthValue() > getReturnMonthValue()) {
                totalMonth = MONTHS - (getPickMonthValue() - getReturnMonthValue());
                days = (totalMonth * 30) + (getReturnDate() - getPickDate());
            }
        }

        return days;
    }

    //to get the total javaDoc.Rental price//
    public double getRentalPrice() {

        return getDays() * aCar.getCPrice();
    }

    //change to String for checking the date//
    public String toStringDateChecker() {
        String outpot = "";

        if ((getPickMonthValue() > getReturnMonthValue()) && (getPickYear() == getReturnYear()))
            outpot += "FALSE";

        if ((getPickMonthValue() == getReturnMonthValue()) && (getPickDate() > getReturnDate()) && (getPickYear() == getReturnYear()))
            outpot += "FALSE";

        if (getPickYear() > getReturnYear())
            outpot += "FALSE";

        else
            outpot += "TRUE";

        return outpot;
    }

    //change to String for checking the age of customer//
    public String toStringAgeChecker() {
        String outfut = "";

        if (getAge() >= 20)
            outfut += "TRUE";

        else if (getAge() < 20)
            outfut += "FALSE";

        return outfut;
    }

    //(int)age to (String)age to print in GUI//
    public String toStringAge() {
        String output = "";
        output += String.format("%d", getAge());
        return output;
    }

    //Status and Gender checking , "mr/mrs"//
    public String toStringMrMrs() {
        String outfowt = "";

        if (aCustomer.getGender().equals("M") || aCustomer.getGender().equals("m"))
            outfowt += "Mr.";

        else if ((aCustomer.getStatus().equals("S") || aCustomer.getStatus().equals("s")) && aCustomer.getGender().equals("F") || aCustomer.getGender().equals("f"))
            outfowt += "Ms.";

        else if ((aCustomer.getStatus().equals("Ma") || aCustomer.getStatus().equals("ma")) && aCustomer.getGender().equals("F") || aCustomer.getGender().equals("f"))
            outfowt += "Mrs.";

        return outfowt;
    }

    //show all for customer//
    public String toStringReceipt() {
        String outMe = "";

        //outMe += String.format(toStringMrMrs() + aCustomer.getFullName());
        outMe += "               	             Shane's Car Rental\n";
        outMe += "                              Owned & Operated By:\n";
        outMe += "                                      Shane Byrne\n";
        outMe += "                             RENTAL TRANSACTION\n";
        outMe += "-----------------------------------------------------------------------------------------------------\n";
        outMe += String.format("Car                                                        %s\n", aCar.getC());
        outMe += String.format("Rental Days                                                %d\n", getDays());
        outMe += String.format("Rental Price                                               %.2f\n", aCar.getCPrice());
        outMe += "                                                           --------------\n";
        outMe += String.format("Total Payment                                              %.2f\n", getRentalPrice());
        outMe += toStringMrMrs() + aCustomer.getFullName();
        return outMe;
    }

    //save all data to .txt file for the Owner//
    public void saveToFile() throws IOException {

        PrintWriter outFile = new PrintWriter(new FileOutputStream("Transactions_Inventory.txt", true));
        outFile.println("Current Date: " + getCurrentMonth() + " " + getCurrentDate() + ", " + getCurrentYear());
        outFile.println(" ");
        outFile.println("Pick up Date: " + getPickMonth() + " " + getPickDate() + ", " + getPickYear());
        outFile.println("Return Date: " + getReturnMonth() + " " + getReturnDate() + ", " + getReturnYear() + " = Days: " + getDays());
        outFile.println("Full Name: " + aCustomer.getFullName());
        outFile.println("Age: " + getAge());
        outFile.println("Address: " + aCustomer.getAddress());
        outFile.println("Contact: " + aCustomer.getContact());
        outFile.println("javaDoc.Car: " + aCar.getC());
        outFile.printf("Total Rent Price: %.2f", +getRentalPrice());
        outFile.println(" ");
        outFile.println("--------------------------------------------------");
        outFile.close();
    }
}
