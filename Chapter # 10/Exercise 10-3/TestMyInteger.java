/*
	Author:  Chad Lister
	Date:  06/04/2020
	
	This program that tests all the methods in the MyInteger class.
*/

class TestMyInteger {
	
	//  Main method
	public static void main(String[] args) {
		
		//  Create object to test methods in MyInteger class.
		
		MyInteger integer = new MyInteger(8);

		
		
		// First instance test and display.		
		System.out.print("Value is " + integer.getValue());
		System.out.printf("\nIs it even " + integer.isEven());
		System.out.printf("\nIs it odd " + integer.isOdd());
		System.out.printf("\nIs it prime " + integer.isPrime());
				
		//  Create second instance test and display.
		MyInteger integer2 = new MyInteger(17);
		System.out.println();
		System.out.printf("\nValue is:  " + integer2.getValue());
		System.out.printf("\nIs it even " + integer2.isEven() + ".");
		System.out.printf("\nIs it odd " + integer2.isOdd() + ".");
		System.out.printf("\nIs it prime " + integer2.isPrime());
		
		//  Create third instance test and display.
		MyInteger integer3 = new MyInteger(8);
		System.out.println();
		System.out.printf("\nValue is " + integer3.getValue());
		System.out.printf("\nIs it even " + integer3.isEven());
		System.out.printf("\nIs it odd " + integer3.isOdd());
		System.out.printf("\nIs it prime " + integer3.isPrime());
		
		//  Dislay and test final methods.
		System.out.println();
		System.out.printf("\nFirst value is " + integer.getValue() + " second value is " + integer2.getValue() + " and third value is " + integer3.getValue() + ".");
		System.out.printf("\nIs the 2nd value equal to the 1st value "  + integer2.equals(integer) + ".  Is the 3rd value equal to the 1st value " + integer3.equals(integer) + ".");
		
		//  Create character array and test method.
		char [] c = {'5', '5', '8', '2', '1'};
		System.out.println();
		System.out.printf("\nIf given the character array  ");
		for (int i = 0; i < c.length; i++) {
			System.out.print(" " + c[i] + " ");
		}
		System.out.printf("\nOutput would be " + MyInteger.parseInt(c));
		
		//  Create a string and test method.
		System.out.println();
		String s = "411";
		System.out.printf("\nIf given the String " + "'" + s + "'" + ".");
		System.out.printf("\nOutput would be " + MyInteger.parseInt(s) + ".");
	}
}