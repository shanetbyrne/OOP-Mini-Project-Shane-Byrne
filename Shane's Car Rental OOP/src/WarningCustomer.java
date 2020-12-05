import javax.swing.*;
import java.awt.*;

public class WarningCustomer extends JFrame{

    private final Transaction aTrans = new Transaction(); //access my class javaDoc.Transaction as global declaration

    public WarningCustomer(){

        Container pane = getContentPane();
        JPanel warningPan = new JPanel(null);
        warningPan.setBackground(Color.WHITE);

        ImageIcon warningImage = new ImageIcon("../images/warning_icon.GIF");
        JLabel iconLab = new JLabel(warningImage);
        iconLab.setBounds(20, 35, 50, 50);
        warningPan.add(iconLab);

        JLabel textLab = new JLabel("");
        textLab.setText("please complete details");
        textLab.setFont(new Font("Serif", Font.BOLD, 15));
        textLab.setForeground(Color.RED);
        textLab.setBounds(95, 55, 200, 20);
        warningPan.add(textLab);
        pane.add(warningPan);
    }
}