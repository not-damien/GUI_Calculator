package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DecimalCalculator extends MainWindow {
    public DecimalCalculator() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.DARK_GRAY);
        this.add(mainPanel);


        var textDisplay = new JTextField(20);
        mainPanel.add(textDisplay);


        JButton[] myButtons = createButtons();
        var buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4,4));
        for(int i =0;i < 10;i++ ){
            buttonPanel.add(myButtons[i]);
            int finalI = i;
            myButtons[i].addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String s = textDisplay.getText();
                            textDisplay.setText(s + finalI);
                        }
                    }
            );
        }


        String[] operationSymbols = {"+","-","/","*", "=","Clear"};
        JButton[] myOperations = new JButton[6];
        for(int i = 0; i < operationSymbols.length;i++){
            myOperations[i] = new JButton(operationSymbols[i]);
            buttonPanel.add(myOperations[i]);
        }

        mainPanel.add(buttonPanel);













        setVisible(true);
    }
    //todo fill and implement
}
