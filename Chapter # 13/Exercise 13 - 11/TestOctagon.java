/*
	Author:  Chad Lister
	Date: 06/18/2020
	
	This tests the Octagon class and Clone and Comparable interfaces.
*/

public class TestOctagon {
	
	//  Main
	public static void main(String[] args) {
		
		//  Create Object 1.
		Octagon octagon1 = new Octagon(2.5);
		
		// Try to clone.
		try {
			Octagon octagon2 = (Octagon)((Octagon)octagon1).clone();
		
			//  Success message.
			System.out.println("Octagon # 1 with an area of " + octagon1.getArea() + " was successfully cloned into :  ");
			System.out.printf("\n\tOctagon # 2 with an area of " + octagon2.getArea() + ".\n");
			System.out.println();
			
			//  Compare
			if (octagon1.compareTo(octagon2) == 0) {
				System.out.println("They are the same size.");
			}
			else if (octagon1.compareTo(octagon2) == 1) {
				System.out.println("Octagon 1 is larger than octagon 2.");
			}
			else if (octagon1.compareTo(octagon2) == -1) {
				System.out.println("Octagon 1 is smaller than octagon 2.");
			}
		}
		//  Otherwise close.
		catch (CloneNotSupportedException ex) {
			System.out.println("***  Object can't be cloned ***");
			System.exit(1);
		}
	}
}