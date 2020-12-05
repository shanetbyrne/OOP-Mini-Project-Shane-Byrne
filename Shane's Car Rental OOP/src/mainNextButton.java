import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**main (go to reserveForm)**/
class mainNextButton implements ActionListener {
    private final RentalView rentalView;

    public mainNextButton(RentalView rentalView) {
        this.rentalView = rentalView;
    }

    public void actionPerformed(ActionEvent event) {
        CardLayout cL = (CardLayout) rentalView.pane.getLayout();

        if (event.getActionCommand().equals("NextToReserve")) {
            cL.show(rentalView.pane, "reserveForm");
        }
    }
}
