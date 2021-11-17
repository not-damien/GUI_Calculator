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
        String[] radioSymbols = {"+","-","/","*"};
        JRadioButton[] buttons = new JRadioButton[4];


        Panel operationPanel = new Panel();
        ButtonGroup radioButtons = new ButtonGroup();

        for (int i = 0; i < radioSymbols.length;i++){
            buttons[i] = new JRadioButton(radioSymbols[i]);
            radioButtons.add(buttons[i]);
            operationPanel.add(buttons[i]);
        }
        mainPanel.add(operationPanel);




        setVisible(true);
    }
}
