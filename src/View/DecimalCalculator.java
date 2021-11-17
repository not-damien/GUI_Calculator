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
        textDisplay.setEditable(false);
        mainPanel.add(textDisplay);


        JButton[] myButtons = createButtons();
        var buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5,4));
        for(int i =0;i < 10;i++ ){
            buttonPanel.add(myButtons[i]);
            int finalI = i;
            myButtons[i].addActionListener(
                    e -> {
                        String s = textDisplay.getText();
                        if(s.contains("=")){
                            textDisplay.setText(finalI + "");
                        }else {
                            textDisplay.setText(s +finalI);
                        }
                    }
            );
        }

        String[] operationSymbols = { "+","-","/","*", "=","Clear"};
        JButton[] myOperations = new JButton[7];
        for(int i = 0; i < operationSymbols.length;i++){
            myOperations[i] = new JButton(operationSymbols[i]);
            buttonPanel.add(myOperations[i]);
        }
        JButton decimalPoint = new JButton(".");
        buttonPanel.add(decimalPoint);
        decimalPoint.addActionListener(
                e -> {
                    String s = textDisplay.getText();
                    textDisplay.setText(s + ".");
                }
        );
        for(int i = 0 ; i < 4 ;i++){
            int finalI = i;
            myOperations[i].addActionListener(
                    e -> {
                        String s = textDisplay.getText();
                        textDisplay.setText(s + " " + myOperations[finalI].getText() + " ");
                    }
            );
        }

        myOperations[4].addActionListener(
                e -> {
                    double val1,val2;
                    String s = textDisplay.getText();
                    textDisplay.setText(s);
                    String[] n = s.split(" ");
                    val1= Double.parseDouble(n[0]);
                    val2 = Double.parseDouble(n[2]);
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
        );

        myOperations[5].addActionListener(
                e -> textDisplay.setText("")
        );

        mainPanel.add(buttonPanel);









        setVisible(true);
                    }
                }