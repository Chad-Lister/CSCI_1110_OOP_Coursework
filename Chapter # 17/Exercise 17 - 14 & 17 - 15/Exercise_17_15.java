/*
  Author:  Chad Lister
  Date:  
    
(Decrypt files) Suppose a file is encrypted using the scheme in Programming Exercise 17.14. Write a program to decode an encrypted file. Your program should prompt the user to enter an input file name for the encrypted file and an output file name for the unencrypted version of the input file.
*/

import java.util.Scanner;
import java.io.*;

public class Exercise_17_15 {
  // Main method
  public static void main(String[] args) throws IOException { 
    
    // Declare input object.
    Scanner prompt = new Scanner(System.in);
    
    //  Prompt user for source file name.
    System.out.println("Please enter the encrypted file to be unencrypted:  ");
    File sourceFile = new File(prompt.nextLine());

    // Check if source file exists.
    if (!sourceFile.exists()) {
       System.out.println("Encrypted file " + sourceFile + " does not exist!");
       System.exit(0);
    }

    //  Prompt user for target file name.
    System.out.println("Please enter the target file for the unencrypted data:  ");
    File targetFile = new File(prompt.nextLine());

    // Check if target file exists
    if (targetFile.exists()) {
      System.out.println("File " + targetFile + " already exists!");
      System.exit(1);
    }

    try (
      // Create an input stream
        DataInputStream input = 
          new DataInputStream(new FileInputStream(sourceFile));
  
      // Create an output stream
        DataOutputStream output = 
          new DataOutputStream(new FileOutputStream(targetFile));
    ) {
      // Continuously read a byte from input and write it to output
 //     int[] encryptKey = new int[in];
      
      int read = 0;
   //   int skip = 5;
      
      //  Not EOF.
      while ((read = input.read()) != -1) {
        
        output.write((byte)read);
//        in.read(byte);
        input.skipBytes(1);
 //       encryptKey.writeInt();
//        in.seek(1*4);
        //  Take out key.
  //      in.read(byte);
//        in.read(byte);
      }

      // Display encrypted message.
      System.out.println(sourceFile + " unencrypted to " + targetFile + ".");
    }
  }
}
