/*

	Author:  Chad Lister
	Date:  06/01/2020

	This program creates two Rectangle objects—one with width 4 and height 40 and the other with width 3.5 and height 35.9. Display the width, height, area, and perimeter of each rectangle in this order.
*/

public class TestRectangle {
	
	//  Main method
	public static void main(String[] args) {
		
		//  Create first rectangle.
		Rectangle newRectangle= new Rectangle(4.0, 40.0);
		System.out.println("A rectangle with width of 4 and a height of 40 has an area of " + newRectangle.getArea() + " and a perimeter of " + newRectangle.getPerimeter() + ".");
		
		//  Create second rectangle.
		Rectangle newRectangle2 = new Rectangle(3.5, 35.9);
		System.out.println("A rectangle with width 3.5 and a height of 35.9 has an area of " + newRectangle2.getArea() + " and a perimeter of " + newRectangle2.getPerimeter() + ".");
	}
}