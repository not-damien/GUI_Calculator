package View;

import NumbersAndMath.BigNumberMath;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * The type Big number calculator.
 */
// keep under 862
public class BigNumberCalculator extends AbstractCalculatorScreen {
    /**
     * Instantiates a new Big number calculator.
     */
    public BigNumberCalculator() {
        setTitle("Big Number Calculator");//name of calculator

        //everything is bigger here
        setSize(450,500);
        textDisplay.setRows(5);
        textDisplay.setColumns(37);
        textDisplay2.setRows(5);
        textDisplay2.setColumns(37);
        resultArea.setRows(5);
        resultArea.setColumns(37);

        JPanel extraFunc = new JPanel();
        extraFunc.setLayout(new GridLayout(3,1));
        JButton gcd = new JButton("GCD");
        JButton lcm = new JButton("LCM");
        JButton neg = new JButton("Negate");
        extraFunc.add(gcd);
        extraFunc.add(lcm);
        extraFunc.add(neg);
        mainPanel.add(extraFunc);


        //setting up numpad from super class
        buttonPanel.setLayout(new GridLayout(4,3));//layout for my buttons
        buttonPanel.add(decimalPoint);
        buttonPanel.add(clear);//positioning my clear button
        mainPanel.add(buttonPanel);//adding button panel to the calculator

        //give the user control over how precise division needs to be
        var precision = new JComboBox<Integer>();
        for(int i = 0; i <= 100; i+= 10){
            precision.addItem(i);
        }
        precision.setSelectedIndex(1);
        JLabel precisionLabel = new JLabel("Precision");//label for combobox
        precisionLabel.setForeground(Color.getHSBColor(255,0,255));
        mainPanel.add(precisionLabel);
        mainPanel.add(precision);






        equals.addActionListener(//this calculator's Compute Action
                e -> {//This class's compute action
                    BigDecimal first = new BigDecimal(textDisplay.getText());
                    BigDecimal second = new BigDecimal(textDisplay2.getText());
                    if(buttons[0].isSelected()){
                        resultArea.setText(first.add(second).toString());
                    }else if(buttons[1].isSelected()){
                        resultArea.setText(first.subtract(second).toString());
                    }else if(buttons[2].isSelected()){
                        resultArea.setText(first.divide(second, (int) precision.getSelectedItem(), RoundingMode.HALF_DOWN).toString());
                    }else if (buttons[3].isSelected()){
                        resultArea.setText(first.multiply(second).toString());
                    }else if(buttons[4].isSelected()){
                        if(first.scale() > 0 || second.scale() > 0) {
                            resultArea.setText("Enter Integer values only for Modulus function");
                        }else {
                            resultArea.setText(first.unscaledValue().mod(second.unscaledValue()).toString());
                        }
                    }
                }
        );
        gcd.addActionListener(//action listener for greatest common denominator
                e -> {
                    BigDecimal first = new BigDecimal(textDisplay.getText());
                    BigDecimal second = new BigDecimal(textDisplay2.getText());
                    resultArea.setText(BigNumberMath.GCD(first, second).toString());
                }
        );
        lcm.addActionListener(//action listener for Least common multiple
                e -> {
                    BigDecimal first = new BigDecimal(textDisplay.getText());
                    BigDecimal second = new BigDecimal(textDisplay2.getText());
                    resultArea.setText(BigNumberMath.LCM(first, second, (int) precision.getSelectedItem()).toString());
                }
        );
        neg.addActionListener(
                e -> {
                    if (HasWritingAbility) {
                        BigDecimal first = new BigDecimal(textDisplay.getText());
                        textDisplay.setText(first.negate().toString());
                    } else {
                        BigDecimal second = new BigDecimal(textDisplay2.getText());
                        textDisplay2.setText(second.negate().toString());
                    }
                });


        mainPanel.add(resultArea);//area to display the result

        setVisible(true);
    }


}
