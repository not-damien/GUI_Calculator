package View;

import NumbersAndMath.Hexadecimal;

import java.awt.*;

/**
 * The type Hex screen.
 */
public class HexScreen extends AbstractCalculatorScreen{
    /**
     * Instantiates a new Hex screen.
     */
    HexScreen(){
    setTitle("Hexadecimal Calculator");



    buttonPanel.setLayout(new GridLayout(4,4));//picking layout
    mainPanel.add(buttonPanel);





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
    mainPanel.add(clear);





    mainPanel.add(resultArea);

    equals.addActionListener(//this windows compute button implementation
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
                }else if(buttons[4].isSelected()){
                    resultArea.setText(new Hexadecimal(Hexadecimal.hexToLong(first) %
                                Hexadecimal.hexToLong(second)).toString());
                }
            }
    );


    this.setVisible(true);



}


}
