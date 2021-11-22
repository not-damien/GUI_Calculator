package NumbersAndMath;

import View.MainWindow;

import javax.swing.*;

/**
 * The type Main.
 *
 * @author Damien Cruz
 * @version Nov 21, 2021
 */
public class Main {
    /**
     * main method
     *
     * @param args String[] from the command line
     */
    public static void main(String[] args) {
        setUpMainWindow();
    }

    /**
     * Set up main window.
     */
    public static void setUpMainWindow(){
        var mainWindow = new MainWindow();
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setVisible(true);
    }
}
