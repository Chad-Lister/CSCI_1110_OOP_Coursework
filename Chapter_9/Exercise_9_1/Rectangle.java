/*
    Author:  Chad Lister
    Date:  06/01/2020

    This program defines a rectangle class with 2 data fields a default no-arg constructor, another constructor and two methods to get the area of the rectangle and and it's perimeter.
*/

public class Rectangle {
    
        //  Data Fields/Variables
        double width;
        double height;
        
        //  Default constructor.
        public Rectangle() {
            width = 1;
            height = 1;
        }
        
        public Rectangle(double newWidth, double newHeight) {
            width = newWidth;
            height = newHeight;
        }

        //  Methods / Getters
        public double getArea() {
            return width * height;
        }

        public double getPerimeter() {
            return (width * 2) + (height * 2);
        }
}
