/*
  Author:  Chad Lister
  Date:  07/09/2020
  
  This program writes a dat.file with 100 random integers seperated by a space and then reads a dat.file named "Exercise17_03.dat" (as per exercise 17 - 03).  It sums the integers that were entered with writeInt() and DataOutputStream.  Number of integers is unknown, so it uses BufferedInputReader.
*/

import java.io.*;

public class Exercise_17_03 {
  public static void main(String[] args) throws FileNotFoundException, IOException, EOFException {
    
    try (
    
    //  Buffered output with append.
    DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("Exercise17_03.dat", true))))
    
    {
      for (int i = 1; i < 100; i++) {
        int e = (int)(Math.random() * 100);
        output.writeInt(e);
        output.writeUTF(" ");
      }
      
    }
    
    //  Variables for display.
    int integerCount = 0;
    int sumOfIntegers = 0;    
    
    try { 
      
      try (
      // Create a buffered reader.
      DataInputStream reader = new DataInputStream(new BufferedInputStream(new FileInputStream("Exercise17_03.dat"))))
      
      {
        //  While not EOF.
        while (true) {
          integerCount++;
          sumOfIntegers = sumOfIntegers + (reader.readInt());
          reader.readUTF();
          
        }
        //  Close reader.
 //       reader.close();
        }
        catch (EOFException ex) {
          //  reader.close()
        }
      }
        
      catch (FileNotFoundException ex) {
          System.out.println("File not found.");
      }
        
        
      catch (IOException ex) {
          ex.printStackTrace();
      }
      
      System.out.println("All the integers were read.");
      System.out.println("The number of integers counted was " + integerCount + " with a sum of " + sumOfIntegers);
    }
}