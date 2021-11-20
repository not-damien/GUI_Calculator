package View;

import NumbersAndMath.Hexadecimal;

import java.awt.*;

public class HexScreen extends AbstractCalculatorScreen{
HexScreen(){
    setTitle("Hexadecimal Calculator");



    buttonPanel.setLayout(new GridLayout(4,4));
    mainPanel.add(buttonPanel);





    for(int i = 10; i < 16;i++) {
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
