package lab2;

import java.io.File;
import javax.swing.JOptionPane;
import lab1.FileService;

/**
 * @author Chris Geiser <cgeiser@my.wctc.edu>
 */
public class Lab2 {

    public static void main(String[] args) {

        boolean isValid = true;
        int record = 0;

        String dataFile = File.separatorChar + "Users" + File.separatorChar + "chrisgeiser"
                + File.separatorChar + "Desktop" + File.separatorChar + "temp" + File.separatorChar
                + "contacts.txt";

//    String dataFile = File.separatorChar + "temp" + File.separatorChar 
//                        + "contacts.txt";

        FileService fs = new FileService(dataFile);
        do {
            try {
                record = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Enter the record # to find:\n(Enter 0 to exit)", "Record Search", JOptionPane.PLAIN_MESSAGE));
                fs.outputSingleRecord(record);
                isValid = true;
            } catch (IndexOutOfBoundsException iobe) {
                isValid = false;
                if (record != 0) {
                    JOptionPane.showMessageDialog(null, "That record # does not exist.", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                else {isValid = true;}
            }
        } while (record != 0);
    }
}
