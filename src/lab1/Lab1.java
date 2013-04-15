package lab1;

import java.io.*;
import javax.swing.JOptionPane;

/**
 * @author cgeiser
 */
public class Lab1 {
    
    public static void main(String[] args) throws IOException {
    
    boolean isValid = true;
    int record = 0;
    
    String dataFile = File.separatorChar + "Users" + File.separatorChar + "chrisgeiser" +
            File.separatorChar + "Desktop" + File.separatorChar + "temp" + File.separatorChar 
                        + "contacts.txt";
    
//    String dataFile = File.separatorChar + "temp" + File.separatorChar 
//                        + "contacts.txt";
    
    FileService fs = new FileService(dataFile);
    
    
    // Part 1 - display all records
    fs.outputFileContents();
    
    
    // Part 2 - disply one selected record
        do {
            try {
                record = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Enter the record # to find:", "Record Search", JOptionPane.PLAIN_MESSAGE));
                fs.outputSingleRecord(record);
                isValid = true;
            } catch (IndexOutOfBoundsException iobe) {
                isValid = false;
            }
        } while (record <=0 || isValid == false);
    
        
    // Part 3 - append a contact to the file and disply all records
    Contact newContact = new Contact("Buffy", "Harpo", "911 Whinging Way", "Cairo",
            "KY", "34848", "buffytherabbitslayer@gmail.com", "3125550000");
        
    fs.addRecord(newContact);
    fs.outputFileContents();
        
        
    }
}
    