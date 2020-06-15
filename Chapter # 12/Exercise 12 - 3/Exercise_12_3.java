/*
	Author:  Chad Lister
	Date:  06/15/2020
	
	(ArrayIndexOutOfBoundsException) Write a program that meets the following requirements:

	Creates an array with 100 randomly chosen integers.

	Prompts the user to enter the index of the array, then displays the corresponding element value. If the specified index is out of bounds, display the message Out of Bounds.

*/

import java.util.*;

public class Exercise_12_3 {	
	
	//  Main
	public static void main(String[] args) {
		
		//  Init Scanner and declare array.
		Scanner input = new Scanner(System.in);
		int [] integerArray = new int[100];
		
		// build array of random int.
		for (int e = 0; e < integerArray.length; e++) {
			integerArray[e] = (int) (Math.random() * 100);
		}
		
		// prompt for user
		System.out.println("Please enter an idex in the array:  ");
		int element = input.nextInt();
		
		//  Try Block.
		try {
			//  If found in array then display.
			System.out.println("Element at index # " + element + " is value " + integerArray[element] + ".");
		}
		catch (IndexOutOfBoundsException ex) {
			
			//  If exception thrown for out of bounds (not in array) , display error.
			System.out.printf("\t***  Out of Bounds ***\n");
		}
	}
}