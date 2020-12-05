import com.sun.deploy.panel.JSmartTextArea;
import javafx.scene.control.Labeled;
import javafx.scene.text.Text;

import java.awt.*;
import javax.swing.*;

public class RentalView extends JFrame{

    public Transaction aTrans = new Transaction(); //access my class Transaction as global declaration
    public Customer aCustomer = new Customer(); //access class Customer as global declaration
    public Car aCar = new Car(); //access class car as global declaration
    public Labeled carDetailsTA;
    public AbstractButton carNextB;
    public JSmartTextArea ageChecker, dateChecker, foreNameChecker, surNameChecker, genderChecker, statusChecker, addressChecker, contactChecker;
    public Labeled showAgeL, receiptA;
    public ComboBoxModel<Object> bYCB, bDCB, bMCB, rYCB, rDCB, rMCB, pUYCB, pUDCB, pUMCB, cYCB, cDCB, cMCB;
    public Text foreNameTF, surNameTF, genderTF, statusTF, addressTF, contactTF;



    WarningReserve openWarningReserve; /**another class to access warning window**/
    WarningCustomer openWarningCustomer;
    WarningCar openWarningCar;

    Container pane = getContentPane();

    public RentalView() {
        /*First Panel "Welcome" (mainP)
        setting PANEL and LABELS for Welcome section**/
        pane.setLayout(new CardLayout());
        JPanel mainP = new JPanel(null);
        mainP.setBackground(Color.WHITE);

        ImageIcon titleImage = new ImageIcon("D:/Shane's Car Rental/images/logo1.GIF");
        /*welcome**/
        JLabel titleL = new JLabel(titleImage);
        titleL.setBounds(30, 40, 310, 300);
        mainP.add(titleL);

        /*inside the panel of mainP**/
        JLabel dateL = new JLabel("DATE TODAY"); //date today label
        dateL.setFont(new Font("Serif", Font.BOLD, 23));
        dateL.setForeground(Color.RED);
        dateL.setBounds(360, 210, 150, 25);
        mainP.add(dateL);

        /*COMBO BOX for current date**/
        String[] currentMonthCB = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        JComboBox<String> cMCB = new JComboBox<>(currentMonthCB);
        cMCB.setBounds(360, 240, 60, 25);
        mainP.add(cMCB);

        Integer[] currentDateCB = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
        JComboBox<Integer> cDCB = new JComboBox<>(currentDateCB);
        cDCB.setBounds(425, 240, 60, 25);
        mainP.add(cDCB);

        Integer[] currentYearCB = {2013, 2014, 2015, 2016, 2017, 2018, 2019, 2020};
        JComboBox<Integer> cYCB = new JComboBox<>(currentYearCB);
        cYCB.setBounds(490, 240, 60, 25);
        mainP.add(cYCB);

        /*BUTTONS to go reserve section**/
        ImageIcon mainNextImage = new ImageIcon(" D:/Shane's Car Rental/images/next.GIF");
        JButton mainNextB = new JButton(mainNextImage);
        mainNextB.setBackground(Color.WHITE);
        mainNextB.addActionListener(new mainNextButton(this));
        mainNextB.setBounds(460, 300, 100, 50);
        mainNextB.setRolloverEnabled(true);
        mainNextB.setRolloverIcon(mainNextImage);
        mainNextB.setPressedIcon(mainNextImage);
        mainNextB.setActionCommand("NextToReserve");
        mainP.add(mainNextB);
        pane.add(mainP, "welcomeForm");

        /*Panel "reserve" (reserveP)
        LABELS for reservation date.**/
        JPanel reserveP = new JPanel(null);
        reserveP.setBackground(Color.WHITE);

        /*date reservation**/
        JLabel dayL = new JLabel("Reserve javaDoc.Rental Day(s):");
        dayL.setFont(new Font("Verdana", Font.PLAIN, 18));
        dayL.setForeground(Color.BLACK);
        dayL.setBounds(50, 1, 250, 100);
        reserveP.add(dayL);

        JLabel pickupDateL = new JLabel("Pick-up Date:");
        pickupDateL.setFont(new Font("Serif", Font.BOLD, 15));
        pickupDateL.setForeground(Color.BLUE);
        pickupDateL.setBounds(50, 40, 100, 100);
        reserveP.add(pickupDateL);

        JLabel returnDateL = new JLabel("Return Date:");
        returnDateL.setFont(new Font("Serif", Font.BOLD, 15));
        returnDateL.setForeground(Color.BLUE);
        returnDateL.setBounds(50, 80, 100, 100);
        reserveP.add(returnDateL);

        //inside the panel of reserveP
        JLabel birthDateL = new JLabel("Birth Date:");
        birthDateL.setFont(new Font("Serif", Font.BOLD, 15));
        birthDateL.setForeground(Color.BLUE);
        birthDateL.setBounds(60, 150, 100, 100);
        reserveP.add(birthDateL);

        //CHECK BOX for pickup date, return date, birth date
        //Pick up date section
        String[] pickUpMonthCB = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        JComboBox<String> pUMCB = new JComboBox<>(pickUpMonthCB);
        pUMCB.setBounds(150, 80, 60, 25);
        reserveP.add(pUMCB);

        Integer[] pickUpDateCB = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
        JComboBox<Integer> pUDCB = new JComboBox<>(pickUpDateCB);
        pUDCB.setBounds(215, 80, 60, 25);
        reserveP.add(pUDCB);

        Integer[] pickUpYearCB = {2013, 2014, 2015, 2016, 2017, 2018, 2019, 2020};
        JComboBox<Integer> pUYCB = new JComboBox<>(pickUpYearCB);
        pUYCB.setBounds(280, 80, 60, 25);
        reserveP.add(pUYCB);

        /*return date section**/
        String[] returnMonthCB = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        JComboBox<String> rMCB = new JComboBox<>(returnMonthCB);
        rMCB.setBounds(150, 120, 60, 25);
        reserveP.add(rMCB);

        Integer[] returnDateCB = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
        JComboBox<Integer> rDCB = new JComboBox<>(returnDateCB);
        rDCB.setBounds(215, 120, 60, 25);
        reserveP.add(rDCB);

        Integer[] returnYearCB = {2013, 2014, 2015, 2016, 2017, 2018, 2019, 2020};
        JComboBox<Integer> rYCB = new JComboBox<>(returnYearCB);
        rYCB.setBounds(280, 120, 60, 25);
        reserveP.add(rYCB);

        /*birth date section**/
        String[] birthMonthCB = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        JComboBox<String> bMCB = new JComboBox<>(birthMonthCB);
        bMCB.setBounds(150, 190, 60, 25);
        reserveP.add(bMCB);

        Integer[] birthDateCB = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
        JComboBox<Integer> bDCB = new JComboBox<>(birthDateCB);
        bDCB.setBounds(215, 190, 60, 25);
        reserveP.add(bDCB);

        Integer[] birthYearCB = {1970, 1971, 1972, 1973, 1974, 1975, 1976, 1977, 1978, 1979, 1980,
                1981, 1982, 1983, 1984, 1985, 1986, 1987, 1988, 1989, 1990,
                1991, 1992, 1993, 1994, 1995, 1996, 1997, 1998, 1999, 2000,
                2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010,
                2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018, 2019, 2020};
        JComboBox<Integer> bYCB = new JComboBox<>(birthYearCB);
        bYCB.setBounds(280, 190, 60, 25);
        reserveP.add(bYCB);

        /*Date Checker**/
        JLabel dateChecker = new JLabel("");
        dateChecker.setFont(new Font("Serif", Font.BOLD, 15));
        dateChecker.setBounds(350, 83, 100, 100);
        reserveP.add(dateChecker);

        JLabel ageChecker = new JLabel("");
        ageChecker.setFont(new Font("Serif", Font.BOLD, 15));
        ageChecker.setBounds(350, 153, 100, 100);
        reserveP.add(ageChecker);

        /*BUTTONS
        to go customer section**/
        ImageIcon dateNextImage = new ImageIcon(" D:/Shane's Car Rental/images/customer.GIF");
        JButton reserveNextB = new JButton(dateNextImage);
        reserveNextB.setBackground(Color.WHITE);
        reserveNextB.addActionListener(new reserveNextButton(this));
        reserveNextB.setBounds(460, 300, 100, 50);
        reserveNextB.setActionCommand("NextToCustomer");
        reserveP.add(reserveNextB);

        /*Go back welcome section**/

        ImageIcon dateBackImage = new ImageIcon("Shane's javaDoc.Car javaDoc.Rental/images/back.GIF");
        JButton reserveBackB = new JButton(dateBackImage);
        reserveBackB.setBackground(Color.WHITE);
        reserveBackB.setBounds(330, 300, 100, 50);
        reserveBackB.addActionListener(new reserveBackButton(this));
        reserveBackB.setActionCommand("Back To Welcome");
        reserveP.add(reserveBackB);
        pane.add(reserveP, "reserveForm");


        /*third Panel "customer" (customerP)
        LABELS for customer details**/
        JPanel customerP = new JPanel(null);
        customerP.setBackground(Color.WHITE);

        /*customer info**/
        JLabel customerL = new JLabel("javaDoc.Customer's Data");
        customerL.setFont(new Font("Verdana", Font.PLAIN, 18));
        customerL.setForeground(Color.BLACK);
        customerL.setBounds(50, 10, 250, 30);
        customerP.add(customerL);

        JLabel foreNameL = new JLabel("Forename:");
        foreNameL.setFont(new Font("Serif", Font.BOLD, 15));
        foreNameL.setForeground(Color.BLUE);
        foreNameL.setBounds(50, 60, 250, 30);
        customerP.add(foreNameL);

        JLabel surNameL = new JLabel("Surname:");
        surNameL.setFont(new Font("Serif", Font.BOLD, 15));
        surNameL.setForeground(Color.BLUE);
        surNameL.setBounds(50, 95, 250, 30);
        customerP.add(surNameL);

        JLabel genderL = new JLabel("Gender:");
        genderL.setFont(new Font("Serif", Font.BOLD, 15));
        genderL.setForeground(Color.BLUE);
        genderL.setBounds(50, 130, 250, 30);
        customerP.add(genderL);

        JLabel statusL = new JLabel("Status:");
        statusL.setFont(new Font("Serif", Font.BOLD, 15));
        statusL.setForeground(Color.BLUE);
        statusL.setBounds(50, 165, 250, 30);
        customerP.add(statusL);

        JLabel addressL = new JLabel("Address:");
        addressL.setFont(new Font("Serif", Font.BOLD, 15));
        addressL.setForeground(Color.BLUE);
        addressL.setBounds(50, 200, 250, 30);
        customerP.add(addressL);

        JLabel contactL = new JLabel("Contact:");
        contactL.setFont(new Font("Serif", Font.BOLD, 15));
        contactL.setForeground(Color.BLUE);
        contactL.setBounds(50, 235, 250, 30);
        customerP.add(contactL);

        JLabel ageL = new JLabel("Age:");
        ageL.setFont(new Font("Serif", Font.BOLD, 15));
        ageL.setForeground(Color.BLUE);
        ageL.setBounds(50, 270, 250, 30);
        customerP.add(ageL);

        /*inside the panel of customerP**/
        JLabel showAgeL = new JLabel("");
        showAgeL.setFont(new Font("Serif", Font.PLAIN, 15));
        showAgeL.setHorizontalAlignment(JTextField.CENTER);
        showAgeL.setForeground(Color.BLUE);
        showAgeL.setBounds(145, 270, 60, 30);
        customerP.add(showAgeL);

        /*TEXT FIELD for customer details and get data from keyboard section**/
        JTextField foreNameTF = new JTextField("Type First Name Here"); // set as 10 ha
        foreNameTF.setHorizontalAlignment(JTextField.CENTER);
        foreNameTF.setForeground(Color.GRAY);
        foreNameTF.setBounds(150, 60, 250, 30);
        customerP.add(foreNameTF);

        JTextField surNameTF = new JTextField("Type Last Name Here"); // kani pud
        surNameTF.setHorizontalAlignment(JTextField.CENTER);
        surNameTF.setForeground(Color.GRAY);
        surNameTF.setBounds(150, 95, 250, 30);
        customerP.add(surNameTF);

        JTextField genderTF = new JTextField("M/F");
        genderTF.setHorizontalAlignment(JTextField.CENTER);
        genderTF.setForeground(Color.GRAY);
        genderTF.setBounds(150, 130, 50, 30);
        customerP.add(genderTF);

        JTextField statusTF = new JTextField("S/Ma");
        statusTF.setHorizontalAlignment(JTextField.CENTER);
        statusTF.setForeground(Color.GRAY);
        statusTF.setBounds(150, 165, 50, 30);
        customerP.add(statusTF);

        JTextField addressTF = new JTextField("Type Complete Address Here");
        addressTF.setHorizontalAlignment(JTextField.CENTER);
        addressTF.setForeground(Color.GRAY);
        addressTF.setBounds(150, 200, 250, 30);
        customerP.add(addressTF);

        JTextField contactTF = new JTextField("Type Contact Number Here");
        contactTF.setHorizontalAlignment(JTextField.CENTER);
        contactTF.setForeground(Color.GRAY);
        contactTF.setBounds(150, 235, 250, 30);
        customerP.add(contactTF);

        /*Customer checker**/

        JLabel foreNameChecker = new JLabel("");
        foreNameChecker.setFont(new Font("Serif", Font.BOLD, 15));
        foreNameChecker.setBounds(410, 25, 100, 100);
        customerP.add(foreNameChecker);

        JLabel surNameChecker = new JLabel("");
        surNameChecker.setFont(new Font("Serif", Font.BOLD, 15));
        surNameChecker.setBounds(410, 60, 100, 100);
        customerP.add(surNameChecker);

        JLabel genderChecker = new JLabel("");
        genderChecker.setFont(new Font("Serif", Font.BOLD, 15));
        genderChecker.setBounds(210, 95, 100, 100);
        customerP.add(genderChecker);

        JLabel statusChecker = new JLabel("");
        statusChecker.setFont(new Font("Serif", Font.BOLD, 15));
        statusChecker.setBounds(210, 130, 100, 100);
        customerP.add(statusChecker);

        JLabel addressChecker = new JLabel("");
        addressChecker.setFont(new Font("Serif", Font.BOLD, 15));
        addressChecker.setBounds(410, 165, 100, 100);
        customerP.add(addressChecker);

        JLabel contactChecker = new JLabel("");
        contactChecker.setFont(new Font("Serif", Font.BOLD, 15));
        contactChecker.setBounds(410, 200, 100, 100);
        customerP.add(contactChecker);

        /*BUTTONS for customer**/
        /*to go pick a car section**/
        ImageIcon customerNextImage = new ImageIcon("Shane's javaDoc.Car javaDoc.Rental/images/car.GIF");
        JButton customerNextB = new JButton(customerNextImage);
        customerNextB.setBackground(Color.WHITE);
        customerNextB.setBounds(460, 300, 100, 50);
        customerNextB.setRolloverEnabled(true);
        customerNextB.setRolloverIcon(customerNextImage);
        customerNextB.setPressedIcon(customerNextImage);
        customerNextB.addActionListener(new customerNextButton(this));
        customerNextB.setActionCommand("NextToPickCar");
        customerP.add(customerNextB);

        /*to go back reserve section**/
        new ImageIcon("Shane's javaDoc.Car javaDoc.Rental/images/Arrow-Right-icon.GIF");
        ImageIcon customerBackImage = new ImageIcon("Shane's javaDoc.Car javaDoc.Rental/images/customer_back.GIF");
        JButton customerBackB = new JButton(customerBackImage);
        customerBackB.setBackground(Color.WHITE);
        customerBackB.setBounds(330, 300, 100, 50);
        customerBackB.setRolloverEnabled(true);
        customerBackB.setRolloverIcon(customerBackImage);
        customerBackB.setPressedIcon(customerBackImage);
        customerBackB.addActionListener(new customerBackButton(this));
        customerBackB.setActionCommand("backToReserve");
        customerP.add(customerBackB);
        pane.add(customerP, "customerForm");

        /*fourth Panel "pick a car" (carP)
        LABELS for pick a car**/
        JPanel carP = new JPanel(null);
        carP.setBackground(Color.WHITE);

        /*pick a car**/
        //inside the panel of carP
        JLabel carL = new JLabel("javaDoc.Car Detail's");
        carL.setFont(new Font("Verdana", Font.PLAIN, 18));
        carL.setForeground(Color.BLACK);
        carL.setBounds(435, 4, 140, 30);
        carP.add(carL);

        /*BUTTONS for pick a car
        Pick javaDoc.Car Button
        first car button**/
        ImageIcon firstCarImage = new ImageIcon("Shane's javaDoc.Car javaDoc.Rental/images/van.GIF");
        JButton firstCarB = new JButton(firstCarImage);
        firstCarB.setBackground(Color.WHITE);
        firstCarB.addActionListener(new firstCarButton(this));
        firstCarB.setRolloverEnabled(true);
        firstCarB.setRolloverIcon(firstCarImage);
        firstCarB.setPressedIcon(firstCarImage);
        firstCarB.setBounds(10, 10, 190, 130);
        carP.add(firstCarB);

        /*second car button**/
        ImageIcon secondCarImage = new ImageIcon("Shane's javaDoc.Car javaDoc.Rental/images/pickup.GIF");
        JButton secondCarB = new JButton(secondCarImage);
        secondCarB.setBackground(Color.WHITE);
        secondCarB.addActionListener(new secondCarButton(this));
        secondCarB.setRolloverEnabled(true);
        secondCarB.setRolloverIcon(secondCarImage);
        secondCarB.setPressedIcon(secondCarImage);
        secondCarB.setBounds(210, 10, 190, 130);
        carP.add(secondCarB);

        /*third car button**/
        ImageIcon thirdCarImage = new ImageIcon("Shane's javaDoc.Car javaDoc.Rental/images/jeepney.GIF");
        JButton thirdCarB = new JButton(thirdCarImage);
        thirdCarB.setBackground(Color.WHITE);
        thirdCarB.addActionListener(new thirdCarButton(this));
        thirdCarB.setRolloverEnabled(true);
        thirdCarB.setRolloverIcon(thirdCarImage);
        thirdCarB.setPressedIcon(thirdCarImage);
        thirdCarB.setBounds(10, 150, 190, 130);
        carP.add(thirdCarB);

        /*fourth car button**/
        ImageIcon fourthCarImage = new ImageIcon("Shane's javaDoc.Car javaDoc.Rental/images/limousine.GIF");
        JButton fourthCarB = new JButton(fourthCarImage);
        fourthCarB.setBackground(Color.WHITE);
        fourthCarB.addActionListener(new fourthCarButton(this));
        fourthCarB.setRolloverEnabled(true);
        fourthCarB.setRolloverIcon(fourthCarImage);
        fourthCarB.setPressedIcon(fourthCarImage);
        fourthCarB.setBounds(210, 150, 190, 130);
        carP.add(fourthCarB);

        /*to go receipt section (Final step)**/
        ImageIcon carNextImage = new ImageIcon("Shane's javaDoc.Car javaDoc.Rental/images/submit.GIF");
        JButton carNextB = new JButton(carNextImage);
        carNextB.setBackground(Color.WHITE);
        carNextB.setBounds(460, 300, 100, 50);
        carNextB.addActionListener(new finalStepButton(this));
        carNextB.setRolloverEnabled(true);
        carNextB.setRolloverIcon(carNextImage);
        carNextB.setPressedIcon(carNextImage);
        carP.add(carNextB);

        /*to go back customer section**/
        ImageIcon carBackImage = new ImageIcon("Shane's javaDoc.Car javaDoc.Rental/images/car_back.GIF");
        JButton carBackB = new JButton(carBackImage);
        carBackB.setBackground(Color.WHITE);
        carBackB.addActionListener(new carBackButton(this));
        carBackB.setBounds(330, 300, 100, 50);
        carBackB.setRolloverEnabled(true);
        carBackB.setRolloverIcon(carBackImage);
        carBackB.setPressedIcon(carBackImage);
        carBackB.setActionCommand("BackToCustomer");
        carP.add(carBackB);

        /*TEXT AREA for pick a car putting details for car when we click buttons over top**/
        JTextArea carDetailsTA = new JTextArea(6, 25);
        carDetailsTA.setText("Toyota | 2009 | pick-up | 250\nhonda | 2541 | pick-up | 900");
        carDetailsTA.setAutoscrolls(true);
        carDetailsTA.setEditable(false);
        carDetailsTA.setBounds(420, 40, 150, 240);
        carP.add(carDetailsTA);
        pane.add(carP, "pickCarForm");

        /*last panel "receipt" (finalP)**/
        //panels for CardLayout
        JPanel finalP = new JPanel(null);

        /*receipt**/
        JTextArea receiptA = new JTextArea(2000, 2000);
        receiptA.setFont(new Font("Serif", Font.PLAIN, 15));
        receiptA.setForeground(Color.BLUE);
        receiptA.setEditable(false);
        receiptA.setBounds(80, 30, 400, 800); //
        finalP.add(receiptA);
        pane.add(finalP, "Receipt");

    }

}