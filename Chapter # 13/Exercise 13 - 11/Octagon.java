/*
	Author:  Chad Lister
	Date:  06/18/2020
	
	This program defines the Octagon class which implements Cloneable and Comparable intefraces.
*/

public class Octagon extends GeometricObject implements Cloneable, Comparable<Octagon>{
	
	//  Attributes / Data Fields.
	private double side;
	
	//  Constructors.
	public Octagon() {
		
	}
	
	public Octagon(double side) {
		this.side = side;
	}
	
	//  Methods.
	public double getArea() {
		return (2 + 4 / (Math.sqrt(2)) * side * side);
	}
	
	//  Override clone method.
	@Override
	public Object clone() throws CloneNotSupportedException {
		return (Octagon)super.clone();
	}
	
	//  Override compareTo method.
	@Override
	public int compareTo(Octagon o) {
		
		if(getArea() > ((Octagon) o).getArea()) {
//		if(getArea() > o.getArea()) {
			return 1;
		}
		else if (getArea() < ((Octagon) o).getArea()) {
//		else if (getArea() < o.getArea()) {
			return -1;
		}
		else {
			return 0;
		}
	}
}