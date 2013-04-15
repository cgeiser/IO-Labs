package lab1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author cgeiser
 */
public class FileService {
    private String file;
    private Boolean append = false;
    private ArrayList records;
    private int fields = 8;
    
    public FileService (String file) {
        this.file = file;
        storeFileContents();
    }
    
    public void outputFileContents() {
        for (Object o : records) {
            System.out.println(o);
        }
    }
    
    public ArrayList getFileContents() {
        return records;
    }
    
    public Contact getSingleRecord(int record) throws IllegalArgumentException{
        return (Contact)records.get(record-1);
    }

    public void outputSingleRecord(int record) throws IndexOutOfBoundsException{
        System.out.println(records.get(record-1));
    }
    
    public String getFileName() {
        return file;
    }

    public void setFileName(String file) {
        this.file = file;
    }
    
    public void addRecord(Contact c) throws IOException {
        append = true;
        PrintWriter out = new PrintWriter(new BufferedWriter(
					new FileWriter(file, append)));
        out.println(c.getFirstName());
        out.println(c.getLastName());
        out.println(c.getAddress());
        out.println(c.getCity());
        out.println(c.getState());
        out.println(c.getZip());
        out.println(c.getEmail());
        out.println(c.getPhone());
        
        out.close();
        append = false;
        storeFileContents();
    }

    private void storeFileContents() {
        BufferedReader in = null;
        File data = new File(file);
        records = new ArrayList();
        
        try {
           int counter = 0;
           Contact c = new Contact();
           
	   in = new BufferedReader(new FileReader(data));
	   String line = in.readLine();
	   while(line != null){
               switch (counter) {
                   case 0: c.setFirstName(line);
                   case 1: c.setLastName(line);
                   case 2: c.setAddress(line);
                   case 3: c.setCity(line);
                   case 4: c.setState(line);
                   case 5: c.setZip(line);
                   case 6: c.setEmail(line);
                   case 7: c.setPhone(line);
               }
               counter++;
               if (counter == fields) {
                   counter = 0;
                   records.add(c);
                   c = new Contact();
               }
               
		  line = in.readLine();  // strips out any carriage return chars
	   }
	 
        } catch(IOException ioe) {
            System.out.println("Cannot read this file");
        } finally {
            try {
                in.close();
            } catch(Exception e) {
                
            }
        }
    }
    
    
}
