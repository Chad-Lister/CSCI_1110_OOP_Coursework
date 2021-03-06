/*
	Author:  Chad Lister
	Date:  06/09/2020
	
	This program defines the GeometricObject class which is used by Triangle to use TestTriangle.
	
*/

public class GeometricObject {
	
	//  Attributes / Data Fields
	private String color;
	private boolean filled;
	private java.util.Date dateCreated;
	
	//  Constructors
	public GeometricObject() {
		dateCreated = new java.util.Date();
	}
	
	public GeometricObject(String color, boolean filled) {
		dateCreated = new java.util.Date();
		this.color = color;
		this.filled = filled;
	}
	
	//  Methods
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public boolean isFilled(boolean filled) {
		return filled;
	}
	
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	public java.util.Date getDateCreated() {
		return dateCreated;
	}
	
	public String toString() {
		return "created on " + dateCreated + "\ncolor:  " + color + "and filled:  " + filled;
	} 
}