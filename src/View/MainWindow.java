package View;

import javax.swing.*;
import java.awt.*;

/**
 * The type Main window.
 *
 * @author Damien Cruz
 * @version Nov 10, 2021
 */
public class MainWindow extends JFrame {
    /**
     * The Size height.
     */
    public final int SIZE_HEIGHT = 300;
    /**
     * The Size width.
     */
    public final int SIZE_WIDTH = 300;
    /**
     * The Exit menu.
     */
    final JMenuItem exit = new JMenuItem("exit");

    /**
     * Instantiates a new Main window.
     */
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
        var bigNumberCalculator = new JMenuItem("Big Number Calculator");
        calculatorMenu.add(bigNumberCalculator);
        var binaryCalculator = new JMenuItem("Binary Calculator");
        calculatorMenu.add(binaryCalculator);
        calculatorMenu.add(exit);


        var aboutMenu = new JMenuItem("About");
        menuBar.add(aboutMenu);
        aboutMenu.setToolTipText("Click Calculator menu to select a calculator");


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
        aboutMenu.addActionListener(
                e -> description.setText("""
                        This Program may be a little rough
                        select a calculator from the calculator menu
                        the first argument of a math
                        operation should go in the
                        first text box and the second should go in the second
                        text box, to switch text boxes click on
                        the one you would like to edit
                        when finish select an operation and click compute""")
        );

        //Action listener to open hexScreen from menu
        HexCalculator.addActionListener(
                e -> new HexScreen()
        );
        //Action Listener to open converter from window
        converter.addActionListener(
                e -> new ConvertScreen()
        );
        DecimalCalculator.addActionListener(
                e -> new DecimalCalculator()
        );
        bigNumberCalculator.addActionListener(
                e -> new BigNumberCalculator()
        );
        binaryCalculator.addActionListener(
                e -> new BinaryCalculator()
        );

        exit.addActionListener(
                e -> System.exit(0)
        );


    }

    /**
     * creates 16 JButtons ordered 0-9 and A--F
     *
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