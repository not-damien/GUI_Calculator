package View;

import javax.swing.*;
import java.awt.*;

public class BigNumberCalculator extends MainWindow {
    public BigNumberCalculator() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.DARK_GRAY);
        this.add(mainPanel);
        setTitle("Big Number Calculator");
        //todo combo box for decimal or int maybe
        setVisible(true);
    }

}
