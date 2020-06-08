/*
	Author:  Chad Lister
	Date:  06/06/2020
	
	(The MyInteger class) Design a class named MyInteger. The class contains:

	An int data field named value that stores the int value represented by this object, a constructor that creates a MyInteger object for the specified int value, a getter method that returns the int value.
	The methods isEven(), isOdd(), and isPrime() that return true if the value in this object is even, odd, or prime, respectively.  The static methods isEven(int), isOdd(int), and isPrime(int) that return true if the specified value is even, odd, or prime, respectively.  The static methods isEven(MyInteger), isOdd(MyInteger), and isPrime(MyInteger) that return true if the specified value is even, odd, or prime, respectively.  The methods equals(int) and equals(MyInteger) that return true if the value in this object is equal to the specified value.
	A static method parseInt(char[]) that converts an array of numeric characters to an int value, a static method parseInt(String) that converts a string into an int value.
*/

public class MyInteger {
	
	//  Data Fields/Attributes
	private int value;
	
	//  Constructor
	
	public MyInteger(int newValue) {
		
		value = newValue;
	}
	
	//  Methods
	
	public int getValue() {
		return value;
	}
	
	public boolean isEven() {
		return value % 2 == 0;
	}
	
	public boolean isOdd() {
		return value % 2 != 0;
	}
	
	public boolean isPrime() {
		
		int remainder;
		
		for (int i = 2; i <= value / 2; i++) {
			
			remainder = value % i;
			
			if (remainder == 0)
			return false;
		}
		return true;
	}
	
	public static boolean isEven(int value) {
		return value % 2 == 0;
	}
	
	public static boolean isOdd(int value) {
		return value % 2 != 0;
	}
	
	public static boolean isPrime(int value) {
		
		int remainder;
		
		for (int i = 2; i <= value / 2; i++) {
			
			remainder = value % i;
		
			if (remainder == 0)
			return false;
		}
		return true;
	}
	
	public static boolean isEven(MyInteger integer) {
		return (integer.getValue() % 2 == 0);
	}
	
	public static boolean isOdd(MyInteger integer) {
		return (integer.getValue() % 2 != 0);
	}
	
	public static boolean isPrime(MyInteger integer) {
		
		int remainder;
		
		for (int i = 2; i <= integer.getValue() / 2; i++) {
			
			remainder = integer.getValue() % i;
			
			if (remainder == 0)
			return false;
		}
		return true;	
	}
	
	public boolean equals(int newValue) {
		return newValue == value;
	}
		
	public boolean equals(MyInteger integer) {
		return integer.getValue() == value;
	}
	
	//  Convert character array into integer.
	public static int parseInt(char [] array) {
		
		int value = 0;
		
		for (int c = 0; c < array.length; c++) {
			value = value * 10 + (array[c] - '0');
		}
		
		return value;		
	}
	
	
	//  Convert string into integer without using Integer class.
	public static int parseInt(String s) {
		
		int stringValue = 0;
		boolean isNegative = false;
		int n = 0;
		
		//  Check if negative
		if (s.charAt(0) == '-') {
			isNegative=true;
			n = 1;
		}
				
		for(int c = n; c < s.length(); c++) {
			
			if(isNegative == true) {
				
				//  Subtract from 0 beginning at char # 1.
				stringValue = stringValue * 10 - s.charAt(c) + '0';
			}
			else {
				
				//  Add to total beginning at char ## 0;
				stringValue = stringValue * 10 + s.charAt(c) - '0';
			}
		}
		
		return stringValue;
	}
}