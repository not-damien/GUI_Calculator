package View;

import javax.swing.*;
import java.awt.*;

public class BinaryCalculator extends AbstractCalculatorScreen {
    BinaryCalculator() {
        setTitle("Binary Calculator");



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
