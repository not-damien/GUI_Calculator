package View;

import javax.swing.*;
import java.awt.*;

public class AbstractCalculatorScreen extends MainWindow {
    JPanel mainPanel = new JPanel();
    JTextField textDisplay = new JTextField(20);
    JTextField textDisplay2 = new JTextField(20);
    AbstractCalculatorScreen() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        mainPanel.setBackground(Color.DARK_GRAY);
        this.add(mainPanel);



        textDisplay.setEditable(false);
        mainPanel.add(textDisplay);
    }


}
