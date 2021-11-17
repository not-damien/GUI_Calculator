package View;

import javax.swing.*;
import java.awt.*;

public class BinaryCalculator extends MainWindow {
    BinaryCalculator() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.DARK_GRAY);
        this.add(mainPanel);
        setTitle("Binary Calculator");


        var textDisplay = new JTextField(20);
        mainPanel.add(textDisplay);

        //todo add buttons
        //todo radio buttons for "+,-,*,/"




        setVisible(true);
    }
}
