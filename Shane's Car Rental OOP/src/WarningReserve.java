import javax.swing.*;
import java.awt.*;

public class WarningReserve extends JFrame{

    public Transaction aTrans = new Transaction();

    public WarningReserve(){

        Container pane = getContentPane();
        JPanel warningPan = new JPanel(null);
        warningPan.setBackground(Color.WHITE);

        ImageIcon warningImage = new ImageIcon(" D:/Shane's Car Rental/images/warning_icon.GIF");
        JLabel iconLab = new JLabel(warningImage);
        iconLab.setBounds(20, 35, 50, 50);
        warningPan.add(iconLab);

        JLabel textLab = new JLabel("");
        textLab.setText("invalid");
        textLab.setFont(new Font("Serif", Font.BOLD, 15));
        textLab.setForeground(Color.RED);
        textLab.setBounds(95, 55, 200, 30);
        warningPan.add(textLab);
        pane.add(warningPan);
    }
}