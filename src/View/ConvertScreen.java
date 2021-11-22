package View;

import NumbersAndMath.AbstractNumber;
import NumbersAndMath.Binary;
import NumbersAndMath.Hexadecimal;

import javax.swing.*;
import java.awt.*;

/**
 * The type Convert screen.
 */
public class ConvertScreen extends AbstractCalculatorScreen {
    /**
     * Instantiates a new Convert screen.
     */
    ConvertScreen(){
        setTitle("Converter");
        JPanel mainPanel = new JPanel();
        setSize(290,300);
        mainPanel.setBackground(Color.cyan);
        this.add(mainPanel);


        var dataType = new JComboBox<String>();//to figure out what kind of value they gave me
        dataType.addItem("Binary");
        dataType.addItem("Hexadecimal");
        dataType.addItem("Integer");
        mainPanel.add(dataType);
        var textDisplay = new JTextField(15);
        mainPanel.add(textDisplay);
        textDisplay.setEditable(false);

        var buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4,4));
        mainPanel.add(buttonPanel);
        JButton[] myDigits = createButtons();
        for(int i = 0; i < 10;i++) {
            buttonPanel.add(myDigits[i]);
            final int j = i;
            myDigits[i].addActionListener(
                    e -> {
                            String s = textDisplay.getText();
                            textDisplay.setText(s + j);
                    });
        }
        for(int i = 10; i < 16;i++) {//Adding A-F  to panel
            buttonPanel.add(myDigits[i]);
            int finalI = i;
            myDigits[i].addActionListener(
                    e -> {
                        if (HasWritingAbility) {
                            String s = textDisplay.getText();
                            textDisplay.setText(s + myDigits[finalI].getText());
                        } else {
                            String s = textDisplay2.getText();
                            textDisplay2.setText(s + myDigits[finalI].getText());
                        }
                    }
            );
        }


        var dataType2 = new JComboBox<String>();//to figure out what value they want
        dataType2.addItem("Binary");
        dataType2.addItem("Hexadecimal");
        dataType2.addItem("Integer");
        mainPanel.add(dataType2);
        var result = new JTextField(15);
        mainPanel.add(result);
        result.setEditable(false);
        JButton equals = new JButton("Compute");
        mainPanel.add(equals);
        mainPanel.add(clear);
        clear.addActionListener(
                e -> {
                    textDisplay.setText("");
                }
        );
        equals.addActionListener(//action listener to compute
                e -> {
                    String given = (String) dataType.getSelectedItem();
                    String target = (String) dataType2.getSelectedItem();
                    String value = textDisplay.getText();
                    switch (given + target) {
                        case "BinaryHexadecimal" -> result.setText(AbstractNumber.binToHex(value));//
                        case "BinaryInteger" -> result.setText(String.valueOf(new Binary(value).longValue()));
                        case "BinaryBinary", "HexadecimalHexadecimal", "IntegerInteger" -> result.setText(value);
                        case "HexadecimalBinary" -> result.setText(AbstractNumber.hexToBin(value));
                        case "HexadecimalInteger" -> result.setText(new Hexadecimal(value).longValue() + "");
                        case "IntegerBinary" -> result.setText(Integer.toBinaryString(Integer.parseInt(value)));
                        case "IntegerHexadecimal" -> result.setText(Integer.toHexString(Integer.parseInt(value)));
                    }
                    }
        );


        setVisible(true);
    }
}
