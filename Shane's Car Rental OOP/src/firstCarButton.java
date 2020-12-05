import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**go back to customerForm*/
class firstCarButton implements ActionListener { /**when its clicked show up the car detail of Van**/
    private final RentalView rentalView;

    public firstCarButton(RentalView rentalView) {
        this.rentalView = rentalView;
    }

    public void actionPerformed(ActionEvent event) {

        rentalView.carDetailsTA.setText("");
        rentalView.carDetailsTA.setText("Brand: Nissan\nPlate #: lxa756\nType: Van\nModel: 2009\nColor: white\njavaDoc.Rental Price: P500.00\n\n-Used for tourists, family \nuse, business purpose. \nThe Vans capacity can \nhold onto 8 persons \nexcluding the driver.");
        rentalView.carNextB.setActionCommand("Car1");
    }
}
