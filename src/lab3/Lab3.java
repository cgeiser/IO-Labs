package lab3;

import java.io.File;
import javax.swing.JOptionPane;
import lab1.*;

/**
 * @author Chris Geiser <cgeiser@my.wctc.edu>
 */
public class Lab3 {

    public static void main(String[] args) {

        int record = 0;
        Contact c;

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
                c = fs.getSingleRecord(record);
                System.out.println("Record #" + record + "'s city is " + c.getCity());
            } catch (IndexOutOfBoundsException iobe) {
                if (record != 0) {
                    JOptionPane.showMessageDialog(null, "That record # does not exist.", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Please enter a record number...", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } while (record != 0);
    }
}
