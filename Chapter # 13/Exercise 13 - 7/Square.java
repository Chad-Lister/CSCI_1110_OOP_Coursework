/*
	Author:  Chad Lister
	Date: 06/17/2020
	
	This program defines a Square for coloable interface exercise.
*/

public class Square extends GeometricObject {
	private double height;
	private double width;
	
	public Square() {
		
	}
		
	public Square(double height, double width, String color, boolean filled){
		this.height = height;
		this.width = width;
		setColor(color);
		setFilled(filled);
		getDateCreated();
	}
		
	public double getArea() {
		return this.height * this.width;
	}
		
	public double getPerimeter() {
		return (this.height + this.width) * 2;
	}
		
	public String toString() {
		return "A Square with height = " + this.height + " and width = " + this.width;
	}

}