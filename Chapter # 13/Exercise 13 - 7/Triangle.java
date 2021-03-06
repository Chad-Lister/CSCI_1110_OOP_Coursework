/*
	Author:  Chad Lister
	Date:  06/17/2020
	
	This program defines a triangle which extends the GeometericObject class and implements the Colorable interface.
*/

public class Triangle extends GeometricObject implements Colorable {
	
	//  Atributes / Data Fields.
	private double side1;
	private double side2;
	private double side3;
	
	//  Constructors.
	public Triangle(){
		
	}
	
	public Triangle(double side1, double side2, double side3, String color, boolean filled) {
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
		setColor(color);
		setFilled(filled);
		getDateCreated();
	}
	
	//  Methods.
	public double getSide1(double side1) {
		return side1;
	}
	
	public double getSide2(double side2) {
		return side2;
	}
	
	public double getSide3(double side3) {
		return side3;
	}
	
	public void setSide1(double side1) {
		this.side1 = side1;
	}
	
	public void setSide2(double side2) {
		this.side2 = side2;
	}
	
	public void setSide3(double side3) {
		this.side3 = side3;
	}
	
	public double getArea() {
		
		double s = (side1 + side2 + side3) / 2;
		double a = ((s) * (s - side1) * (s - side2) * (s - side3));
		System.out.println(side1 + " " + side2 + " " + side3 + " " + s + " " + a);
		return Math.sqrt(a);
	}
	
	public double getPerimeter() {
		return side1 + side2 + side3;
	}
	
	public String toString() {
		return "A triangle with side1 = " + side1 + ", side2 = " + side2 + " and side3 = " + side3;
	}
	
	@Override
	public void howToColor() {	
		System.out.print("Color all three sides.");
		return;
	}
}