/**
 * JVMailStress - Mail Server Stress Test Tool
 * The class illustrates how to write comments used 
 * to generate JavaDoc documentation
 *
 * @author Murat B.
 * @url https://github.com/muratti66/jvmailstress
 * @version 1.00, 28 May 2017
 */
package com.muratti66.jvstress;

import com.muratti66.jvstress.UI.MainGUI;
import java.util.ArrayList;
import static com.muratti66.jvstress.SystemOps.writeLogger;
/**
 * Main class is first run
 */
public class Main {
    public static ArrayList viewLogger = new ArrayList();
    /**
     * First Method
     * @param args not using
     */
    public static void main(String[] args) {
        try {
            MainGUI.start();
        } catch (Exception e) {
            writeLogger(e.toString(), true);
        }
    }
    /**
     * Clear Logs
     */
    public static void clearLog() {
        viewLogger = new ArrayList();
    }
}
