/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rmazorow
 */
import java.io.*;

public class Exercise17_07 {
    public static void main(String[] args) throws FileNotFoundException {
        Loan loan1 = new Loan();
        Loan loan2 = new Loan(1.8, 10, 10000);
        
        try (
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Exercise17_07.dat"));
        ) {
            output.writeObject(loan1);
            output.writeObject(loan2);
        } 
        catch (IOException ex) {
            System.out.println("File could not be opened");
        }
        
        //  Invoke outputData method.  There is no buffered object input stream.
        
        try {
            outputData();
        }
        catch (EOFException ex) {
            
            System.out.println("End of file.");
         //   close();
        }
        catch (IOException ex) {
            
        }
        catch (ClassNotFoundException ex) {
            System.out.println("Class not found.");
        }
    }
    
    public static void outputData() throws IOException, ClassNotFoundException {
        
        try (ObjectInputStream file = new ObjectInputStream(new FileInputStream("Exercise17_07.dat"));
        ) {
            
            //  While not EOF.
            while (true) {
                Loan e = (Loan) file.readObject();
                System.out.println("Loan amount for $  " + e.getLoanAmount());
            }
        }
    }
}
