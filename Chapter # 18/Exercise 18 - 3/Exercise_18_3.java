/*
	Author:  Chad Lister
	Date: 07/14/2020
	
	(Compute greatest common divisor using recursion) The gcd(m, n) can also be defined recursively as follows:

	If m%n is 0, gcd(m, n) is n.
	Otherwise, gcd(m, n) is gcd(n, m%n).
	The percent symbol (%) in this case represents the modulus operator. The % operator returns the remainder of two numbers. For more explanation or examples, see the following links:

	Write a recursive method to find the GCD. Write a test program that prompts the user to enter two integers and displays their GCD.
	
*/

import java.util.Scanner;

public class Exercise_18_3 {
	
	//  Main.
	public static void main(String[] args) {
		
		//  Prompt user for two integers.
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter a non-negative integer:  ");
		int m = input.nextInt();
		System.out.print("Please enter a second non-negative integer:  ");
		int n = input.nextInt();
		
		//  Display result.
		System.out.print("The greatest common divisor for " + m + " and " + n + " is " + getDivisor(m, n) + ".");
		
	}
	
	public static int getDivisor(int m, int n) {
		
		//  If n isn't 0.
		if (n != 0) {
			
			//  Get remainder of n (m % n).
			return getDivisor(n, m % n);
		}
		else {	
			//  Return first number.
			return m;
		}
	}
}