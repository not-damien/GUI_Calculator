package NumbersAndMath;

import View.MainWindow;

import javax.swing.*;
/*
*implement gui
*use different panels for each calculator type ie hex calculator, bin calculator-use buttons to prevent invalid input
* for binary or hex it may be simpler to have the opperation be a selected button and have two text boxes for the given values
 *buttons need event listeners like calculator example from class
*use menu to go between calculator types OR add tabs
*add Big number support
*
*/

/**
 * @author Damien Cruz
 * @version Nov 7, 2021
 */
public class Main {
    /**
     * main method
     * @param args String[] from the command line
     */
    public static void main(String[] args) {
        setUpMainWindow();
    }
    public static void setUpMainWindow(){
        var mainWindow = new MainWindow();
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setVisible(true);
    }
}
