/*
	Author:  Chad Lister
	Date: 07/14/2020
	
	(Print the characters in a string reversely) Write a recursive method that displays a string reversely on the console using the following header:

		public static void reverseDisplay(String value)
*/

import java.util.Scanner;

public class Exercise_18_9 {
	
	//  Variable.
	static int end;
	
	//  Main.
	public static void main(String[] args) {
		
		//  Prompt user for a string.
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter a string to reverse:  ");
		String value = input.nextLine();
		
		//  Initialize last character pointer.
		end = value.length();
		
		System.out.print("The reverse of the string is:  ");
				
		// Reverse String.
		reverseDisplay(value);
	}
	
	public static void reverseDisplay(String value) {
		
		//  Check if last character reached.
		if (value.isEmpty()) {
			//  Exit.
			return;
		}
		
		//  Add last character to string and sset pointer back 1.
		String reverse = value.charAt(end - 1) + "";
		end--;

		//  Print last character.
		System.out.print(reverse);

		//  Recursive call.
		reverseDisplay(value.substring(0, end));

	}
}