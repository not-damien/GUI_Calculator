package View;

import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

//todo keep under 862
public class BigNumberCalculator extends AbstractCalculatorScreen {
    int scale = 30;
    public BigNumberCalculator() {
        setTitle("Big Number Calculator");//name of calculator
        setSize(500,500);
        textDisplay.setRows(6);
        textDisplay.setColumns(40);
        textDisplay2.setRows(6);
        textDisplay2.setColumns(40);
        resultArea.setRows(6);
        resultArea.setColumns(40);


        //todo combo box for decimal or int maybe
        buttonPanel.setLayout(new GridLayout(4,3));//layout for my buttons
        buttonPanel.add(decimalPoint);
        buttonPanel.add(clear);//positioning my clear button
        mainPanel.add(buttonPanel);//adding button panel to the calculator
        equals.addActionListener(
                e -> {//This class's compute action
                    BigDecimal first = new BigDecimal(textDisplay.getText());
                    BigDecimal second = new BigDecimal(textDisplay2.getText());
                    if(buttons[0].isSelected()){
                        resultArea.setText(first.add(second).toString());
                    }else if(buttons[1].isSelected()){
                        resultArea.setText(first.subtract(second).toString());
                    }else if(buttons[2].isSelected()){
                        resultArea.setText(first.divide(second, scale, RoundingMode.HALF_DOWN).toString());
                    }else if (buttons[3].isSelected()){
                        resultArea.setText(first.multiply(second).toString());
                    }
                }
        );




        mainPanel.add(resultArea);//area to display the result

        setVisible(true);
    }

}
