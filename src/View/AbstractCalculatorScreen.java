package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * The type Abstract calculator screen.
 */
public class AbstractCalculatorScreen extends MainWindow {
    /**
     * The Main panel. to hold all components
     */
    JPanel mainPanel = new JPanel();
    /**
     * The Text display used for enter first operand
     */
    JTextArea textDisplay = new JTextArea(1,20);
    /**
     * The Text display 2 used to enter second operand
     */
    JTextArea textDisplay2 = new JTextArea(1,20);//
    /**
     * The Equals button . action listener must be implemented in inheriting class
     */
    JButton equals = new JButton("Compute");//action listener must be implemented in inheriting class
    /**
     * The Buttons.+-/*
     */
    JRadioButton[] buttons = new JRadioButton[5];
    /**
     * The Result area. where the results should go
     */
    JTextArea resultArea = new JTextArea(1,20);
    /**
     * The Button panel.for buttons, 0-9 already added
     */
    JPanel buttonPanel = new JPanel();
    /**
     * The Has writing ability. true means textDisplay1 has it, false means textDisplay2 has it
     */
    boolean HasWritingAbility = true;
    /**
     * The digits. an array of Jbutton  0-9 and A-F
     */
    JButton[] myDigits = createButtons();//an array of Jbutton  0-9 and A-F
    /**
     * The Clear button. must be added to button panel in preferred spot, already functional
     */
    JButton clear = new JButton("Clear");
    /**
     * The Decimal point. must be added to button in preferred spot, already has functionality
     */
    JButton decimalPoint = new JButton(".");

    /**
     * Instantiates a new Abstract calculator screen.
     */
    AbstractCalculatorScreen() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        mainPanel.setBackground(Color.DARK_GRAY);//easy on the eyes unoffensive
        this.add(mainPanel);


        resultArea.setToolTipText("Final result appears here.");
        textDisplay.setToolTipText("Enter X value here.");
        textDisplay.setEditable(false);//for preventing invalid input
        mainPanel.add(textDisplay);


        String[] radioSymbols = {"+","-","/","*","%"};//basic things all calculators must do
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
        textDisplay2.setToolTipText("Enter Y value here");
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
                        if(!s.contains(".")) {
                            textDisplay.setText(s + ".");
                        }
                    } else {
                        String s = textDisplay2.getText();
                        if(!s.contains(".")) {
                            textDisplay2.setText(s + ".");
                        }
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
