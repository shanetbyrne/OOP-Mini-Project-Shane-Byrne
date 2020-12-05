import javax.swing.*;
import java.awt.*;

public class WarningCar extends JFrame{

    private final Transaction aTrans = new Transaction();

    public WarningCar(){

        Container pane = getContentPane();
        JPanel warningPan = new JPanel(null);
        warningPan.setBackground(Color.WHITE);

        ImageIcon warningImage = new ImageIcon("Shane's/images/warning_icon.GIF");
        JLabel iconLab = new JLabel(warningImage);
        iconLab.setBounds(20, 35, 50, 50);
        warningPan.add(iconLab);

        JLabel textLab = new JLabel("");
        textLab.setText("Click a javaDoc.Car");
        textLab.setFont(new Font("Serif", Font.BOLD, 15));
        textLab.setForeground(Color.RED);
        textLab.setBounds(95, 55, 200, 20);
        warningPan.add(textLab);
        pane.add(warningPan);
    }
}