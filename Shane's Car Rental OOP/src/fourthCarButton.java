import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class fourthCarButton implements ActionListener {
    private final RentalView rentalView;

    public fourthCarButton(RentalView rentalView) {
        this.rentalView = rentalView;
    }



    public void actionPerformed(ActionEvent event) {

        rentalView.carDetailsTA.setText("");
        rentalView.carDetailsTA.setText("Brand: Bentley\nPlate #: lmo009\nType: limousine\nModel: 2007\nColor: Black\nRental Price: P700.00\n\n-good for events, such as \nweddings and proms. \nIts not only for events but \ncan be used for touring too. \nThe luxurious look gives off \na good feeling to the \npassengers because of \nits comfortable outlook.");
        rentalView.carNextB.setActionCommand("Car4");
    }
}