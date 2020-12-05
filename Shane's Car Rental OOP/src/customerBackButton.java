import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**go back to reserveForm**/
class customerBackButton implements ActionListener {
    private final RentalView rentalView;

    public customerBackButton(RentalView rentalView) {
        this.rentalView = rentalView;
    }

    public void actionPerformed(ActionEvent event) {
        CardLayout cL = (CardLayout) rentalView.pane.getLayout();

        if (event.getActionCommand().equals("backToReserve")) {
            cL.show(rentalView.pane, "reserveForm");
        }
    }
}
