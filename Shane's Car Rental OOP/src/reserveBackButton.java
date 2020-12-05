import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//-------------------------------------------------go back to welcomeForm
class reserveBackButton implements ActionListener {
    private final RentalView rentalView;

    public reserveBackButton(RentalView rentalView) {
        this.rentalView = rentalView;
    }

    public void actionPerformed(ActionEvent event) {
        CardLayout cL = (CardLayout) rentalView.pane.getLayout();

        if (event.getActionCommand().equals("Back To Welcome")) {
            cL.show(rentalView.pane, "welcomeForm");
        }
    }
}
