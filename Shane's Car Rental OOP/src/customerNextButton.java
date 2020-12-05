import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**customer
*go to pickCarForm
*including the validation if requirements are meet for Next Panel**/
class customerNextButton implements ActionListener {
    private final RentalView rentalView;

    public customerNextButton(RentalView rentalView) {
        this.rentalView = rentalView;
    }

    public void actionPerformed(ActionEvent event) {
        CardLayout cL = (CardLayout) rentalView.pane.getLayout();


        if (event.getActionCommand().equals("NextToPickCar")) {

            String foreName, surName, gender, status, address, contact;

            foreName = rentalView.foreNameTF.getText();
            surName = rentalView.surNameTF.getText();
            gender = rentalView.genderTF.getText();
            status = rentalView.statusTF.getText();
            address = rentalView.addressTF.getText();
            contact = rentalView.contactTF.getText();

            rentalView.aCustomer.setCustomer(foreName, surName, gender, status, address, contact);

            if (rentalView.aCustomer.getForeName().equals("Type Forename Here")) { // checker for firstname if empty , its invalid
                rentalView.foreNameChecker.setForeground(Color.RED);
                rentalView.foreNameChecker.setText("Invalid!");
            } else {
                rentalView.foreNameChecker.setForeground(Color.GREEN);
                rentalView.foreNameChecker.setText("Valid");
            }

            if (rentalView.aCustomer.getSurName().equals("Type Surname Here")) { //for last name
                rentalView.surNameChecker.setForeground(Color.RED);
                rentalView.surNameChecker.setText("Invalid!");
            } else {
                rentalView.surNameChecker.setForeground(Color.GREEN);
                rentalView.surNameChecker.setText("Valid");
            }

            if (rentalView.aCustomer.getGender().equals("M/F")) { //for gender
                rentalView.genderChecker.setForeground(Color.RED);
                rentalView.genderChecker.setText("Invalid!");
            } else {
                rentalView.genderChecker.setForeground(Color.GREEN);
                rentalView.genderChecker.setText("Valid");
            }

            if (rentalView.aCustomer.getStatus().equals("S/Ma")) { //for status
                rentalView.statusChecker.setForeground(Color.RED);
                rentalView.statusChecker.setText("Invalid!");
            } else {
                rentalView.statusChecker.setForeground(Color.GREEN);
                rentalView.statusChecker.setText("Valid");
            }

            if (rentalView.aCustomer.getAddress().equals("Type Complete Address Here")) { //for location
                rentalView.addressChecker.setForeground(Color.RED);
                rentalView.addressChecker.setText("Invalid!");
            } else {
                rentalView.addressChecker.setForeground(Color.GREEN);
                rentalView.addressChecker.setText("Valid");
            }

            if (rentalView.aCustomer.getContact().equals("Type Contact Number Here")) { //for contact
                rentalView.contactChecker.setForeground(Color.RED);
                rentalView.contactChecker.setText("Invalid!");
            } else {
                rentalView.contactChecker.setForeground(Color.GREEN);
                rentalView.contactChecker.setText("Valid");
            }

            if (!rentalView.aCustomer.getForeName().equals("Type Forename Here") && !rentalView.aCustomer.getSurName().equals("Type Last Name Here") && !rentalView.aCustomer.getGender().equals("M/F") && !rentalView.aCustomer.getStatus().equals("S/Ma") && !rentalView.aCustomer.getAddress().equals("Type Complete Address Here") && !rentalView.aCustomer.getContact().equals("Type Contact Number Here")) {
                rentalView.foreNameTF.setText("Type Forename Here"); //if all of the above is valid , proceed to javaDoc.Car Form
                rentalView.surNameTF.setText("Type Surname Here");
                rentalView.genderTF.setText("M/F");
                rentalView.statusTF.setText("S/Ma");
                rentalView.addressTF.setText("Type Complete Address Here");
                rentalView.contactTF.setText("Type Contact Number Here");
                cL.show(rentalView.pane, "pickCarForm");
            } else { //if invalid, pop out window for warning
                if (rentalView.openWarningCustomer == null) {
                    rentalView.openWarningCustomer = new WarningCustomer();
                    ImageIcon warningCustomerImage = new ImageIcon("D:/Shane's Car Rental/images/warning_top_icon.GIF");
                    rentalView.openWarningCustomer.setIconImage(warningCustomerImage.getImage());
                    rentalView.openWarningCustomer.setTitle("WARNING INVALID!!");
                    rentalView.openWarningCustomer.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    rentalView.openWarningCustomer.setSize(300, 150);
                    rentalView.openWarningCustomer.setVisible(true);
                    rentalView.openWarningCustomer.setResizable(false);
                } else {
                    rentalView.openWarningCustomer.setVisible(!rentalView.openWarningCustomer.isVisible());
                }
            }
        }
    }
}
