/*
	Author:  Chad Lister
	Date:  06/17/2020
	
	(The Colorable interface) Design an interface named Colorable with a void method named howToColor(). 

	Modify the Triangle class from Exercise 13-1 so that Triangle extends GeometricObject and implements Colorable. Implement howToColor to display the message "Color all three sides".

	Create the Colorable, Triangle, and GeometricObject classes. Write a test program that creates an array of five GeometricObjects. For each object in the array, display its area and invoke its howToColor method if it is colorable.
*/

import java.util.Scanner;

public class TestColorable {
	//  Main
	public static void main(String[] args) {
		//  Initialize Scanner.
		Scanner input = new Scanner(System.in);
		
		//  Create objects in array.
		GeometricObject[] objectArray = new GeometricObject[5];
		objectArray[0] = new Square(2, 4, "blue", false);
		objectArray[1] = new Square(3, 6, "red", true);
		objectArray[2] = new Triangle(4, 3, 7, "grey", false);
		objectArray[3] = new Square(4, 8, "green", false);
		objectArray[4] = new Triangle(20, 30, 50, "orange", true);
		
		//  Display results.
		for (int o = 1; o < objectArray.length + 1; o++) {
			
			System.out.println();
			System.out.println("For object # " + o);
			System.out.println(objectArray[o - 1].toString() + " was created on " + objectArray[o - 1].getDateCreated());
			System.out.println("It's color is " + objectArray[o - 1].getColor());
			System.out.println("Is it filled ?  " + objectArray[o - 1].isFilled());
			System.out.println("It's area is " + objectArray[o - 1].getArea());
			System.out.println("It's perimeter is " + objectArray[o - 1].getPerimeter());
			
			//  If colorable call interface method.
			if (objectArray[o - 1] instanceof Colorable) {
				((Colorable)objectArray[o -1]).howToColor();
				System.out.println();
			}
		}
	}
}