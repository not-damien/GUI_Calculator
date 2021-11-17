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
                            if(s.contains("=")){
                                textDisplay.setText(finalI + "");
                            }else {
                                textDisplay.setText(s +finalI);
                            }
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
        for(int i = 0 ; i < 4 ;i++){
            int finalI = i;
            myOperations[i].addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String s = textDisplay.getText();
                            textDisplay.setText(s + " " + myOperations[finalI].getText() + " ");
                        }
                    }
            );
        }
        myOperations[4].addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        String s = textDisplay.getText();
                        textDisplay.setText(s);
                        String[] n = s.split(" ");
                        int val1 = Integer.parseInt(n[0]);
                        int val2 = Integer.parseInt(n[2]);
                        if (s.contains("+")) {
                            textDisplay.setText(s + "=" + (val1 + val2));
                        }
                        if (s.contains("-")) {
                            textDisplay.setText(s + "=" + (val1 - val2));
                        }
                        if (s.contains("/")) {
                            textDisplay.setText(s + "=" + (val1 / val2));
                        }
                        if (s.contains("*")) {
                            textDisplay.setText(s + "=" + (val1 * val2));
                        }
                        //todo change to include decimals
                    }
                }
        );

        myOperations[5].addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        textDisplay.setText("");
                    }
                }
        );

        mainPanel.add(buttonPanel);









        setVisible(true);
                    }
                }