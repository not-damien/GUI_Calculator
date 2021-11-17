package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * @author Damien Cruz
 * @version Nov 10, 2021
 */
public class MainWindow extends JFrame {
    public final int SIZE_HEIGHT = 300;
    public final int SIZE_WIDTH = 290;
    JMenuItem exit = new JMenuItem("exit");
    public MainWindow() {
        this.setTitle("Damien's Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(SIZE_WIDTH, SIZE_HEIGHT);
        setResizable(false);
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.gray);
        this.add(mainPanel);

        //creating and building the menu bar
        var menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        var calculatorMenu = new JMenu("Calculators");
        menuBar.add(calculatorMenu);
        var HexCalculator = new JMenuItem("HexCalculator");
        calculatorMenu.add(HexCalculator);
        var converter = new JMenuItem("Converter");
        calculatorMenu.add(converter);
        var DecimalCalculator = new JMenuItem("Base 10 calculator");
        calculatorMenu.add(DecimalCalculator);
        var bigNumberCalculatorCalculator = new JMenuItem("Big Number Calculator");
        calculatorMenu.add(bigNumberCalculatorCalculator);
        calculatorMenu.add(exit);

        var helpMenu = new JMenuItem("Help");
        menuBar.add(helpMenu);
        var aboutMenu = new JMenu("About");
        menuBar.add(aboutMenu);

        var description = new JTextArea(10,25);
        description.setEditable(false);
        description.setText("""
                Hello, Under the calculator menu there are a\s
                number of calculator windows to open Including\s
                 A Value Converter
                 A Hexadecimal Calculator\s
                 A four function decimal calculator
                 And a Big Number Calculator""");
        mainPanel.add(description);


        //Action listener to open hexScreen from menu
        HexCalculator.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new HexScreen();

                    }
                }
        );
        //Action Listener to open converter from window
        converter.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new ConvertScreen();
                    }
                }
        );
        DecimalCalculator.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new DecimalCalculator();
                    }
                }
        );
        bigNumberCalculatorCalculator.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new BigNumberCalculator();
                    }
                }
        );

        exit.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                }
        );


    }

    /**
     * creates 16 JButtons ordered 0-9 and A--F
     * @return An array of Jbuttons 0-9 & A-F
     */
    public static JButton[] createButtons(){
        JButton[] digits = new JButton[16];
        for(int i = 0; i < digits.length-6 ;i++ ){
            digits[i] = new JButton(i + "");
        }
        for(int i = 10; i < 16; i++){
            char c = (char) (i + 55);
            digits[i] = new JButton(c + "");
        }
        return digits;

    }

}