package View;


import java.awt.*;

/**
 * The type Decimal calculator.
 */
public class DecimalCalculator extends AbstractCalculatorScreen {
    /**
     * Instantiates a new Decimal calculator.
     */
    public DecimalCalculator() {
        setTitle("Base 10");//name this window

        buttonPanel.setLayout(new GridLayout(4,4));//chose layout that looks best for buttons I need

        buttonPanel.add(decimalPoint);//adding a decimal point button so I can enter decimal numbers



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
                    }else if(buttons[4].isSelected()){
                        resultArea.setText((first % second) + "");
                    }
                }
        );

        mainPanel.add(resultArea);//placing result area

        setVisible(true);
                    }
                }