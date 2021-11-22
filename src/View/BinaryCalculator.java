package View;

import NumbersAndMath.Binary;

import javax.swing.*;

/**
 * The type Binary calculator.
 */
public class BinaryCalculator extends AbstractCalculatorScreen {
    /**
     * Instantiates a new Binary calculator.
     */
    BinaryCalculator() {
        setTitle("Binary Calculator");

        //set up buttons
        JPanel binaryNumPad = new JPanel();
        binaryNumPad.add(myDigits[0]);
        binaryNumPad.add(myDigits[1]);
        mainPanel.add(binaryNumPad);

        //placing results area
        mainPanel.add(resultArea);

        //implement this calculator's ActionListener for equals
        equals.addActionListener(
                e -> {

                    int first = (int) new Binary(textDisplay.getText()).longValue();
                    int second = (int) new Binary(textDisplay2.getText()).longValue();
                    //have to cast as ints to use Integer.toBinaryString(int) later



                    if(buttons[0].isSelected()){//add
                        resultArea.setText(Integer.toBinaryString((first + second)));
                    }else if(buttons[1].isSelected()){//subtract
                        resultArea.setText(Integer.toBinaryString((first - second)));
                    }else if(buttons[2].isSelected()){//divide
                        resultArea.setText(Integer.toBinaryString((first / second)));
                    }else if (buttons[3].isSelected()){//multiply
                        resultArea.setText(Integer.toBinaryString((first * second)));
                    }
                }
        );
        setVisible(true);
    }
}
