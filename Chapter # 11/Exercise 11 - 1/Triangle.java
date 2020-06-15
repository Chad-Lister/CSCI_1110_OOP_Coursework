/*
	Author:  Chad Lister
	Date: 06/09/2020
	
	This defines the Triangle class which is a SubClass of GeometricObject as listed below.
	
	Design a class named Triangle that extends GeometricObject. The class contains:

	Three double data fields named side1, side2, and side3 with default values 1.0 to denote three sides of the triangle.
	A no-arg constructor that creates a default triangle.
	A constructor that creates a triangle with the specified side1, side2, and side3.
	The accessor methods for all three data fields.
	A method named getArea() that returns the area of this triangle.
	A method named getPerimeter() that returns the perimeter of this triangle.
	A method named toString() that returns a string description for the triangle.
*/

public class Triangle extends GeometricObject {
	
	//  Attributes / Data Fields
	private double side1 = 1;
	private double side2 = 1;
	private double side3 = 1;
	
	//  Constructors
	public Triangle(){
	}
	
	public Triangle(double newSide1, double newSide2, double newSide3, String color, boolean filled) {
		this.side1 = newSide1;
		this.side2 = newSide2;
		this.side3 = newSide3;
		setColor(color);
		setFilled(filled);
		getDateCreated();
	}
	
	//  Methods
	public double getSide1() {
		return side1;
	}
	
	public double getSide2() {
		return side2;
	}
	
	public double getSide3() {
		return side3;
	}
	
	public double getArea() {
		
		double s = (side1 + side2 + side3) / 2;
		double a = ((s) * (s - side1) * (s - side2) * (s - side3));
		return Math.sqrt(a);
	}
	
	public double getPerimeter() {
		return side1 + side2 + side3;
	}
	
	public String toString() {
		return "A triangle with side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
	}
}