package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class AbstractCalculatorScreen extends MainWindow {
    JPanel mainPanel = new JPanel();//to hold all components
    JTextArea textDisplay = new JTextArea(1,20);//used for enter first operand
    JTextArea textDisplay2 = new JTextArea(1,20);//used to enter second operand
    JButton equals = new JButton("Compute");//action listener must be implemented in inheriting class
    JRadioButton[] buttons = new JRadioButton[4];//+-/*
    JTextArea resultArea = new JTextArea(1,20);// where results should go
    JPanel buttonPanel = new JPanel();//for buttons, 0-9 already added
    boolean HasWritingAbility = true; //true means text1 has it, false means text 2 has it
    JButton[] myDigits = createButtons();//an array of Jbutton  0-9 and A-F
    JButton clear = new JButton("Clear");//must be added to button panel in preferred spot, already functional
    JButton decimalPoint = new JButton(".");//must be added to button in preferred spot, already has functionality
    AbstractCalculatorScreen() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        mainPanel.setBackground(Color.DARK_GRAY);//easy on the eyes unoffensive
        this.add(mainPanel);


        textDisplay.setEditable(false);//for preventing invalid input
        mainPanel.add(textDisplay);


        String[] radioSymbols = {"+","-","/","*"};//basic things all calculators must do
        Panel operationPanel = new Panel();
        ButtonGroup radioButtons = new ButtonGroup();

        for (int i = 0; i < radioSymbols.length;i++){//setting up radio buttons
            buttons[i] = new JRadioButton(radioSymbols[i]);
            radioButtons.add(buttons[i]);
            operationPanel.add(buttons[i]);
        }
        mainPanel.add(operationPanel);//adding radio buttons

        mainPanel.add(equals);//adding button to compute

        mainPanel.add(textDisplay2);//adding area to input second value
        textDisplay2.setEditable(false);//invalid input prevention


        for(int i = 0; i < 10;i++) {//adding 0-9 buttons and giving them the ability to write to both text Areas
            buttonPanel.add(myDigits[i]);
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


        clear.addActionListener(//clears selected text area
                e -> {
                    if (HasWritingAbility) {
                        textDisplay.setText("");
                    } else {
                        textDisplay2.setText("");
                    }
                }
        );
        decimalPoint.addActionListener(//can be added to calculators that need decimal button, clears selected screen
                e -> {
                    if (HasWritingAbility) {
                        String s = textDisplay.getText();
                        textDisplay.setText(s + ".");
                    } else {
                        String s = textDisplay2.getText();
                        textDisplay2.setText(s + ".");
                    }
                }//behavior for decimal point button
        );
        textDisplay.addFocusListener(//used to determine what screen buttons should write to
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
    }

}
