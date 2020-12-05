import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class thirdCarButton implements ActionListener { //button to show Taxi details
    private final RentalView rentalView;

    public thirdCarButton(RentalView rentalView) {
        this.rentalView = rentalView;
    }

    public void actionPerformed(ActionEvent event) {

        rentalView.carDetailsTA.setText("");
        rentalView.carDetailsTA.setText("Brand: uso-uso\nPlate #: pny698\nType: Jeepney\nModel: 2002\nColor: Blue\nRental Price: P250.00\n\n-Filipino's famous transport \nation that can be used \nprivately.Tourists can \nexperience riding on \nthis type of car. is known for \nits daily use of commuting \nto places.");
        rentalView.carNextB.setActionCommand("Car3");
    }
}
