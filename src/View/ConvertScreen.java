package View;

import NumbersAndMath.AbstractNumber;
import NumbersAndMath.Binary;
import NumbersAndMath.Hexadecimal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConvertScreen extends MainWindow{
    ConvertScreen(){
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Converter");
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.cyan);
        this.add(mainPanel);


        var dataType = new JComboBox<String>();
        dataType.addItem("Binary");
        dataType.addItem("Hexadecimal");
        dataType.addItem("Integer");
        mainPanel.add(dataType);
        var textDisplay = new JTextField(15);
        mainPanel.add(textDisplay);


        var buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4,4));
        mainPanel.add(buttonPanel);
        JButton[] myDigits = createButtons();
        for (JButton b:
                myDigits) {
            buttonPanel.add(b);
        }
        for(int i = 0; i < 10;i++) {
            final int j = i;
            myDigits[i].addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                String s = textDisplay.getText();
                                textDisplay.setText(s + j);
                        }
                    });
        }






        var dataType2 = new JComboBox<String>();
        dataType2.addItem("Binary");
        dataType2.addItem("Hexadecimal");
        dataType2.addItem("Integer");
        mainPanel.add(dataType2);
        var result = new JTextField(15);
        mainPanel.add(result);
        JButton equals = new JButton("Compute");
        mainPanel.add(equals);
        equals.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String given = (String) dataType.getSelectedItem();
                        String target = (String) dataType2.getSelectedItem();
                        String value = textDisplay.getText();
                        switch (given + target) {
                            case "BinaryHexadecimal" -> result.setText(AbstractNumber.binToHex(value));//
                            case "BinaryInteger" -> result.setText(String.valueOf(new Binary(value).longValue()));
                            case "BinaryBinary", "HexadecimalHexadecimal", "IntegerInteger" -> result.setText(value);
                            case "HexadecimalBinary" -> result.setText(AbstractNumber.hexToBin(value));
                            case "HexadecimalInteger" -> result.setText(String.valueOf(new Hexadecimal(value).longValue()));
                            case "IntegerBinary" -> result.setText(Integer.toBinaryString(Integer.parseInt(value)));
                            case "IntegerHexadecimal" -> result.setText(Integer.toHexString(Integer.parseInt(value)));
                        }


                        }
                    }

        );


        setVisible(true);
    }
}
