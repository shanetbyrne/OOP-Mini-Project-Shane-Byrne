import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class secondCarButton implements ActionListener {
    private final RentalView rentalView;

    public secondCarButton(RentalView rentalView) {
        this.rentalView = rentalView;
    }

    public void actionPerformed(ActionEvent event) {

        rentalView.carDetailsTA.setText("");
        rentalView.carDetailsTA.setText("Brand: Toyota\nPlate #: xzq883\nType: Pick-up\nModel: HiAce\nColor: Dirty White\njavaDoc.Rental Price: P300.00\n\n-Often used for travelers \nsuch as adventure seekers. \nCan hold loads from its \nback open space. It's tires \nare good for long travels \nand bumpy roads.");
        rentalView.carNextB.setActionCommand("Car2");
    }
}
