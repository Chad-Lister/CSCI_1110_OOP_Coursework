/*
	Author:  Chad Lister
	Date:  06/09/2020
	
	This program tests the GeometricObject Class and Triangle SubClass.  It prompts the user for 3 sides and uses the subclass Triangle of GeometricObject to return it's sides, date created, color, filled, area and perimeter.
*/

import java.util.Scanner;

public class TestTriangle {
	//  Main
	public static void main(String[] args) {
		//  Initialize Scanner.
		Scanner input = new Scanner(System.in);
		
		//  Prompt for triangle sides.
		System.out.print("Please enter the length of the first side of the triangle :  ");
		double side1 = input.nextDouble();
		System.out.print("Please enter the length of the second side of the triangle :  ");
		double side2 = input.nextDouble();
		System.out.print("Please enter the length of the third side of the triangle :  ");
		double side3 = input.nextDouble();
		System.out.print("what color would you like it to be?  ");
		String color = input.next();
		System.out.print("Would you like it to be filled (true or false) ?  ");
		boolean filled = input.nextBoolean();
		
		// Create instance of triangle.
		Triangle triangle = new Triangle(side1, side2, side3, color, filled);
		
		//  Display results.
		System.out.println();
		System.out.println(triangle.toString() + " was created on " + triangle.getDateCreated());
		System.out.println("It's color is " + triangle.getColor());
		System.out.println("Is it filled ?  " + triangle.isFilled(filled));
		System.out.println("It's area is " + triangle.getArea());
		System.out.println("It's perimeter is " + triangle.getPerimeter());
	}
}