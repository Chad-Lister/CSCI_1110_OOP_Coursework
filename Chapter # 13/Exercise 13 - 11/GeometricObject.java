/*
	Author:  Chad Lister
	Date:  06/17/2020
	
	This program defines the abstract GeomtericObject class usable by circles, rectangle, etc.  It contains protected constructors and abstract methods.
*/

public abstract class GeometricObject {
	
	//  Attributes / Data Fields.
	private String color;
	private boolean filled;
	private java.util.Date dateCreated;
	
	//  Constructors.
	protected GeometricObject() {
		dateCreated = new java.util.Date();
	}
	
	protected GeometricObject(String color, boolean filled) {
		dateCreated = new java.util.Date();
		this.color = color;
		this.filled = filled;
	}
	
	//  Methods.
	
	public String getColor() {
		return color;
	}
	
	public java.util.Date getDateCreated() {
		return dateCreated;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	public boolean isFilled() {
		return filled;
	}
	
	@Override
	public String toString() {
		return "Created on " + dateCreated + "\ncolor:  " + color + " and filled:  " + filled;
	}
	
	//  Abstract methods.
	public abstract double getArea();
	
}