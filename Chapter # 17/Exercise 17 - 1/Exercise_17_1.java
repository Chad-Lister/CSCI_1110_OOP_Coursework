/*
  Author:  Chad Lister
  Date:  07/09/2020
  
  This program creates a text file "Exercise_17_01.txt" with 100 random integers seperated by a space.  If it already exists it appends the file.
*/

import java.io.*;

public class Exercise_17_1 {
  public static void main(String[] args) throws IOException {
    
    try (
      // Create an output stream to the file.  If exists append.
      FileWriter outputFile = new FileWriter("Exercise_17_01.txt", true)
      
      ) {
        
        // Use an instance of filewriter
        PrintWriter out = new PrintWriter(outputFile, true);
        // Output values to the file
        for (int i = 1; i <= 100; i++) {
          int o = (int)(Math.random() * 100);
          out.print(o + " ");
        }
      }
  }
}
