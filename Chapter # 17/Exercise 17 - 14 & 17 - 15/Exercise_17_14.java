/*
  Author:  Chad Lister
  Date:  
    
  (Encrypt files) Encode the file by adding 5 to every byte in the file. Write a program that prompts the user to enter an input file name and an output file name and saves the encrypted version of the input file to the output file.

*/

import java.util.Scanner;
import java.io.*;

public class Exercise_17_14 {
  // Main method
  public static void main(String[] args) throws IOException { 
    
    // Declare input object.
    Scanner prompt = new Scanner(System.in);
    
    //  Prompt user for source file name.
    System.out.println("Please enter the source file to be encrypted:  ");
    String fileName = prompt.nextLine();
    File sourceFile = new File(fileName);

    // Check if source file exists.
    if (!sourceFile.exists()) {
       System.out.println("Source file " + sourceFile + " does not exist!");
       System.exit(0);
    }

    //  Prompt user for target file name.
    System.out.println("Please enter the target file for the encrypted data:  ");
    String outFile = prompt.nextLine();
    File targetFile = new File(outFile);

    // Check if target file exists
    if (targetFile.exists()) {
      System.out.println("Target file " + targetFile + " already exists!");
      System.exit(1);
    }

    try (
      // Create an input stream
      BufferedInputStream input = 
        new BufferedInputStream(new FileInputStream(sourceFile));
  
      // Create an output stream
      BufferedOutputStream output = 
        new BufferedOutputStream(new FileOutputStream(targetFile));
    ) {
      // Continuously read a byte from input and write it to output
      int encryptKey = 5;
      int read = 0;
      
      //  Not EOF.
      while ((read = input.read()) != -1) {
        
        //  Insert the value 5 after every byte.
        output.write((byte)read);
        output.write(encryptKey);
      }

      // Display encrypted message.
      System.out.println(sourceFile + " encrypted to " + targetFile + ".");
    }
  }
}
