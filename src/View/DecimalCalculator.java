package View;


import javax.swing.*;
import java.awt.*;

public class DecimalCalculator extends AbstractCalculatorScreen {
    public DecimalCalculator() {
        setTitle("Base 10");//name this window

        buttonPanel.setLayout(new GridLayout(4,4));//chose layout that looks best for buttons I need

        JButton decimalPoint = new JButton(".");
        buttonPanel.add(decimalPoint);//adding a decimal point button so I can enter decimal numbers


        decimalPoint.addActionListener(
                e -> {
                    String s = textDisplay.getText();
                    textDisplay.setText(s + ".");
                }//behavior for decimal point button
        );
        buttonPanel.add(clear);//adding clear button


        mainPanel.add(buttonPanel);//attaching completed button panel to mainPanel

        equals.addActionListener(
                e -> {//This class's compute action
                    double first = Double.parseDouble(textDisplay.getText());
                    double second = Double.parseDouble(textDisplay2.getText());
                    if(buttons[0].isSelected()){
                        resultArea.setText((first + second) + "");
                    }else if(buttons[1].isSelected()){
                        resultArea.setText((first - second )+ "");
                    }else if(buttons[2].isSelected()){
                        resultArea.setText((first / second ) + "");
                    }else if (buttons[3].isSelected()){
                        resultArea.setText((first * second) + "");
                    }
                }
        );

        mainPanel.add(resultArea);//placing result area

        setVisible(true);
                    }
                }