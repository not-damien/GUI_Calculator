package View;

import NumbersAndMath.Hexadecimal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
public class HexScreen extends MainWindow{
    boolean HasWritingAbility; //true means test1 has it, false means text 2 has it
HexScreen(){
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    JPanel mainPanel = new JPanel();
    mainPanel.setBackground(Color.DARK_GRAY);
    this.add(mainPanel);
    setTitle("Hexadecimal Calculator");


    var textDisplay = new JTextField(20);
    mainPanel.add(textDisplay);
    textDisplay.setEditable(false);




    String[] radioSymbols = {"+","-","/","*"};
    JRadioButton[] buttons = new JRadioButton[4];


    Panel operationPanel = new Panel();
    ButtonGroup radioButtons = new ButtonGroup();

    for (int i = 0; i < radioSymbols.length;i++){
        buttons[i] = new JRadioButton(radioSymbols[i]);
        radioButtons.add(buttons[i]);
        operationPanel.add(buttons[i]);
    }
    mainPanel.add(operationPanel);
    JButton equals = new JButton("Compute");
    mainPanel.add(equals);


    var textDisplay2 = new JTextField(20);
    mainPanel.add(textDisplay2);
    textDisplay2.setEditable(false);


    //toggle typing between each text display
    textDisplay.addFocusListener(
            new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    HasWritingAbility = true;
                }

                @Override
                public void focusLost(FocusEvent e) {}//do nothing
            }
    );
    textDisplay2.addFocusListener(
            new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    HasWritingAbility = false;
                }

                @Override
                public void focusLost(FocusEvent e) {}//do nothing
            }
    );




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
                e -> {
                    if (HasWritingAbility) {
                        String s = textDisplay.getText();
                        textDisplay.setText(s + j);
                    } else {
                        String s = textDisplay2.getText();
                        textDisplay2.setText(s + j);
                    }
                });
    }

    for(int i = 10; i < 16;i++) {
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




    var resultArea = new JTextField(20);
    mainPanel.add(resultArea);

    equals.addActionListener(
            e -> {

                String first = textDisplay.getText();
                String second = textDisplay2.getText();
                if(buttons[0].isSelected()){
                    resultArea.setText(Hexadecimal.addHex(first,second));
                }else if(buttons[1].isSelected()){
                    resultArea.setText(Hexadecimal.minusHex(first,second));
                }else if(buttons[2].isSelected()){
                    resultArea.setText(Hexadecimal.divideHex(first,second));
                }else if (buttons[3].isSelected()){
                    resultArea.setText((Hexadecimal.multiplyHex(first,second)));
                }
            }
    );


    this.setVisible(true);



}


}
