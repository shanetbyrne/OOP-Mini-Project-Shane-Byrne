import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//reserve
//go to customerForm
//including the validation if requirements are meet for Next Panel
class reserveNextButton implements ActionListener {
    private final RentalView rentalView;

    public reserveNextButton(RentalView rentalView) {
        this.rentalView = rentalView;
    }

    public void actionPerformed(ActionEvent event) {
        CardLayout cL = (CardLayout) rentalView.pane.getLayout();

        if (event.getActionCommand().equals("NextToCustomer")) {

            String currentMonth, pickUpMonth, returnMonth, birthMonth;
            int currentDate, currentYear, pickUpDate, pickUpYear, returnDate,
                    returnYear, birthDate, birthYear;

            currentMonth = (String) rentalView.cMCB.getSelectedItem();
            currentDate = (int) rentalView.cDCB.getSelectedItem();
            currentYear = (int) rentalView.cYCB.getSelectedItem();

            pickUpMonth = (String) rentalView.pUMCB.getSelectedItem();
            pickUpDate = (int) rentalView.pUDCB.getSelectedItem();
            pickUpYear = (int) rentalView.pUYCB.getSelectedItem();

            returnMonth = (String) rentalView.rMCB.getSelectedItem();
            returnDate = (int) rentalView.rDCB.getSelectedItem();
            returnYear = (int) rentalView.rYCB.getSelectedItem();

            birthMonth = (String) rentalView.bMCB.getSelectedItem();
            birthDate = (int) rentalView.bDCB.getSelectedItem();
            birthYear = (int) rentalView.bYCB.getSelectedItem(); //saving dates for transaction, validation for date and age, will prompt to javaDoc.WarningReserve

            rentalView.aTrans.setTransaction(rentalView.aCustomer, rentalView.aCar, currentMonth, currentDate, currentYear, pickUpMonth,
                    pickUpDate, pickUpYear, returnMonth, returnDate, returnYear,
                    birthMonth, birthDate, birthYear);
            rentalView.showAgeL.setText(rentalView.aTrans.toStringAge()); // show the text of age from class

            if (!rentalView.aTrans.toStringDateChecker().equals("TRUE")) { //check if valid or not for pick date and return date
                rentalView.dateChecker.setForeground(Color.RED);
                rentalView.dateChecker.setText("Invalid!");
            } else {
                rentalView.dateChecker.setForeground(Color.GREEN);
                rentalView.dateChecker.setText("Valid");
            }

            if (!rentalView.aTrans.toStringAgeChecker().equals("TRUE")) { // for age validation
                rentalView.ageChecker.setForeground(Color.RED);
                rentalView.ageChecker.setText("Invalid!");
            } else {
                rentalView.ageChecker.setForeground(Color.GREEN);
                rentalView.ageChecker.setText("Valid");
            }

            if (rentalView.aTrans.toStringDateChecker().equals("TRUE") && rentalView.aTrans.toStringAgeChecker().equals("TRUE")) { //checker to proceed next panel
                cL.show(rentalView.pane, "customerForm");
            } else { //pop up window for warning to customer
                if (rentalView.openWarningReserve == null) {
                    rentalView.openWarningReserve = new WarningReserve();
                    ImageIcon warningReserveImage = new ImageIcon(" D:/Shane's Car Rental/images/warning_top_icon.GIF");
                    rentalView.openWarningReserve.setIconImage(warningReserveImage.getImage());
                    rentalView.openWarningReserve.setTitle("WARNING !!");
                    rentalView.openWarningReserve.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    rentalView.openWarningReserve.setSize(300, 150);
                    rentalView.openWarningReserve.setVisible(true);
                    rentalView.openWarningReserve.setResizable(false);
                } else {
                    rentalView.openWarningReserve.setVisible(!rentalView.openWarningReserve.isVisible());
                }
            }
        }
    }
}
