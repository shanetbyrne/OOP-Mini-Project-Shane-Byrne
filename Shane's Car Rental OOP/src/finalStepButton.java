import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

class finalStepButton implements ActionListener {
    private final RentalView rentalView;

    public finalStepButton(RentalView rentalView) {
        this.rentalView = rentalView;
    }

    public void actionPerformed(ActionEvent event) {
        CardLayout cL = (CardLayout) rentalView.pane.getLayout();

        switch (event.getActionCommand()) {
            case "Car1": { /*passing the pick-up details to car details class and final transactions.**/

                String carType = "Van", carModel = "2009";
                double carPrice = 500.00;

                rentalView.aCar.setCar(carType, carModel, carPrice);


                try { /*to save in file Transaction_Inventory**/
                    rentalView.aTrans.saveToFile();
                } catch (IOException ignored) {
                }


                rentalView.receiptA.setText(rentalView.aTrans.toStringReceipt());
                cL.show(rentalView.pane, "receipt");
                break;
            }
            case "Car2": { /*pass the details of Jeep to car details**/

                String carType = "Pick-up", carModel = "2013";
                double carPrice = 300.00;

                rentalView.aCar.setCar(carType, carModel, carPrice);

                try { /*to save in file Transaction_Inventory**/
                    rentalView.aTrans.saveToFile();
                } catch (IOException ignored) {
                }

                rentalView.receiptA.setText(rentalView.aTrans.toStringReceipt());
                cL.show(rentalView.pane, "receipt");
                break;
            }
            case "Car3": { /*pass Van details to car details**/

                String carType = "Taxi", carModel = "2002";
                double carPrice = 250.00;

                rentalView.aCar.setCar(carType, carModel, carPrice);

                try { /*to save in file Transaction_Inventory**/
                    rentalView.aTrans.saveToFile();
                } catch (IOException ignored) {
                }

                rentalView.receiptA.setText(rentalView.aTrans.toStringReceipt());
                cL.show(rentalView.pane, "receipt");
                break;
            }
            case "Car4": { /*pass mr.bean car details to car details**/

                String carType = "Bus", carModel = "2007";
                double carPrice = 700.00;

                rentalView.aCar.setCar(carType, carModel, carPrice);

                try { /*to save in file Transaction_Inventory**/
                    rentalView.aTrans.saveToFile();
                } catch (IOException ignored) {
                }

                rentalView.receiptA.setText(rentalView.aTrans.toStringReceipt());
                cL.show(rentalView.pane, "receipt");
                break;
            }
            default:  /*if customer haven't yet pick a car, show's the warning information**/
                if (rentalView.openWarningCar == null) {
                    rentalView.openWarningCar = new WarningCar();
                    ImageIcon warningCarImage = new ImageIcon("../images/warning_top_icon.GIF");
                    rentalView.openWarningCar.setIconImage(warningCarImage.getImage());
                    rentalView.openWarningCar.setTitle("WARNING INVALID!!");
                    rentalView.openWarningCar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    rentalView.openWarningCar.setSize(300, 150);
                    rentalView.openWarningCar.setVisible(true);
                    rentalView.openWarningCar.setResizable(false);
                } else {
                    rentalView.openWarningCar.setVisible(!rentalView.openWarningCar.isVisible());
                }
                break;
        }
    }
}
