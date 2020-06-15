/*
	Author:  Chad Lister
	Date:  06/15/2020
	
	(Write/read data) Write a program to create a file named Exercise12_15.txt if it does not exist. Write 100 integers created randomly into the file using text I/O. Integers are separated by spaces in the file. Read the data back from the file and display the data in increasing order.
*/

import java.util.Arrays;
import java.io.PrintWriter;
import java.util.Scanner;

class Exercise_12_15 {
	
	//  Main
	public static void main(String[] args) throws Exception {
				
		// Declare file.
		java.io.File file = new java.io.File("Exercise12_15.txt");
		
		//  Check if already present.
		if (file.exists()) {
			System.out.printf("\nFile already exists.");
//			throw new IOexception();
			System.exit(0);
		}
		
		//  Create and then build array.
		int[] integerArray = new int[100];
		buildArray(integerArray);
		
		//  Try bloc for writing to file and closing.
		try (
		
			//  Create output file.
			java.io.PrintWriter output = new java.io.PrintWriter(file);) {
			
			//  For elements in the array.
			for (int i = 0; i < integerArray.length; i++) {
				
				//  Write element to the file.
				output.print(integerArray[i] + " ");
			}
		}
		
		//  Create a Scanner to read file.
		Scanner input = new Scanner(file);
		
		// Sort for printing low to high.
//		java.util.Arrays.sort(integerArray);
		
		int[] printArray = new int[integerArray.length];
		int count = 0;
		System.out.printf("\n\t***  File Read  ***\n");
		System.out.println();
		
		//  While not EOF.
		while (input.hasNext()) {
			
			int number = input.nextInt();
			
			//  Build print array so file stays the same.
			
			printArray[count] = number;
			
	//		System.out.print(number + " ");
			count++;
		}
		
		//  Sort for display.
		java.util.Arrays.sort(printArray);
		
		// For numbers in print array
		for (int n = 0; n < printArray.length; n++) {
			System.out.print(printArray[n] + " ");
		}
		
		System.out.println();
		System.out.println();
		System.out.println("Integer count:  " + count);
		
		//  Close file and resources.
		input.close();
	}
	
	public static int[] buildArray(int[] integerArray) {
		
		//  Build 100 random integer array.
		for (int i = 0; i < integerArray.length; i++) {
			integerArray[i] = (int) (Math.random() * 100);
		}
		return integerArray;
	}
}