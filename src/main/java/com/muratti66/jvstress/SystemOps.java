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

import java.util.Random;
import java.util.logging.Logger;
import java.text.SimpleDateFormat;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.util.Calendar;
import static com.muratti66.jvstress.Main.viewLogger;
import static sun.awt.OSInfo.getOSType;
/**
 * This class does system operations
 */
public class SystemOps {
    public static Logger logger = Logger.
            getLogger("com.javacodegeeks.snippets.core");
    private static SimpleDateFormat dateForm = 
            new SimpleDateFormat("dd-MM-yyyy hh:mm:ss.SSS a");
    private final static String HTML_PATTERN = "<.*?><.*?>";
    private final static String thisClass  = String.class.getName();
    
    /**
     * Generate Random Number (Max Value required)
     * @param maxValue
     * @return Integer
     */
    public int genRandom(int maxValue) {
        if (maxValue == 1) {
            return 1;
        }
        if (maxValue == 0) {
            return 0;
        }
        Random rn = new Random();
        int range = maxValue - 1 + 1;
        int randomNum =  rn.nextInt(range) + 1;
        return randomNum;
    }
    /**
     * Text content html syntax checker
     * @param text Content is here
     * @return boolean
     */
    public boolean isHTML(String text) {
        String textChecking = text.replaceAll("\\n", "")
                .replaceAll("\\r", "").replaceAll(" ", "");
        if (textChecking.matches(HTML_PATTERN)) {
            return true;
        }
        return false;
    }
    /**
     * Standart logger
     * @param log   Log Content
     * @param isError   Operations has error ?
     */
    public static void writeLogger(String log, Boolean isError) {   
        String now = dateForm.format(Calendar.getInstance().getTime());
        if (isError.equals(true)) {
            viewLogger.add(now + "<font color=\"red\"> [Error] </font>" 
                    + log );
        } else {
            viewLogger.add(now + "<font color=\"green\"> [Notice] </font>" 
                    + log);
        }
    }
    /**
     * SMTP content logger
     * @param log   Log Content
     * @param threadNum     Witch thread ?
     * @param paralelNum    Witch paralel proccess ?
     * @param isFailed  Mail send processes has error ?
     */
    public static void writeSMTPLogger(String log, int threadNum, 
            int paralelNum, Boolean isFailed) {
        String now = dateForm.format(Calendar.getInstance().getTime());
        if (isFailed.equals(true)) {
            viewLogger.add(now  + "<font color=\"red\"> [Warning] </font>"
                + " Thread "  + threadNum + ", Process " + paralelNum + " : " 
                + log);
        } else {
            viewLogger.add(now +  "<font color=\"green\"> [Notice] </font>"  
                + " Thread " + threadNum + ", Process " + paralelNum + " : " 
                + log);
        }
    }
    /**
     * Clipboard to String operation
     * for field setter
     * @return 
     */
    public static String getClipBoard() {
        try {
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Clipboard clipboard = toolkit.getSystemClipboard();
            String result = (String) 
                    clipboard.getData(DataFlavor.stringFlavor);
            return result;
        } catch (Exception e) {
            writeLogger(e.toString(), true);
            return "";
        }
    }
    /**
     * String to Clipboard operation
     * @param selectedString 
     */
    public static void setClipBoard(String selectedString) {
        StringSelection selec= new StringSelection(selectedString);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selec, selec);
    }
    /**
     * Garbage Collection (manual)
     */
    public static void runGC() {
        System.gc();
        System.runFinalization();
    }
    /**
     * Get Os Name to string
     * @return String
     */
    public static String whatOS() {
        return getOSType().toString();
    }
}
