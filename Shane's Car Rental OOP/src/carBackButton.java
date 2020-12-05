import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class carBackButton implements ActionListener { /**go back to customer form when it is clicked and performed**/
    private final RentalView rentalView;

    public carBackButton(RentalView rentalView) {
        this.rentalView = rentalView;
    }

    public void actionPerformed(ActionEvent event) {
        CardLayout cL = (CardLayout) rentalView.pane.getLayout();

        if (event.getActionCommand().equals("BackToCustomer")) {
            cL.show(rentalView.pane, "customerForm");
        }
    }
}
