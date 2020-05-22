/*
THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES.
Kaiwen Zhou
*/

// This class represents a circle shape
public class Circle {

    // Instance variables (data members) of class Circle
    protected double radius; // the radius of the circle
    protected double x; // the x coordinate of the circle's center
    protected double y; // the y coordinate fo the circle's center

    // The default constructor with no argument
    public Circle(){
        // Initializing the values of the instance variables
        radius = 1.0;
        x = 0.0;
        y = 0.0;
    }

    // Second constructor with given radius, but origin default
    public Circle(double r) {
        radius = r;
        x = 0.0;
        y = 0.0;
    }

    // Third constructor with all instance variables given
    public Circle(double r, double ex, double why) {
        radius = r;
        x = ex;
        y = why;
    }

    // A public getter method for retrieving the radius
    public double getRadius() {
        return radius;
    }


    // A public getter method for retrieving the center coordinates
    public double[] getCenter() {
        double[] c = {this.x, this.y};
        return c;
    }

    // A public getter method for computing and returning the area of the circle
    public double getArea() {
        return radius * radius * Math.PI;
    }

    // A public get method for computing and returning the circumference of the circle
    public double getCircumference() {
        return 2 * radius * Math.PI;
    }

    // A public method that compares the sizes of two circles and returns true if circle1 is bigger than circle2
    public boolean isBiggerThan(Circle circleB) {
        return this.getArea() > circleB.getArea();
    }

    // A public method that takes as input an x coordinate (double) and y coordinate (double) and returns
    // true if point given by coordinates is inside the given circle
    public boolean containsPoint(double xCoor, double yCoor) {
        //Setting non-origin centered circles to be origin centered
        double realX = xCoor - x;
        double realY = yCoor - y;

        //Using re-centered coordinates to calculate distance from center of circle
        double distFromCenter = Math.sqrt((realX * realX) + (realY * realY));

        return distFromCenter < radius;
    }

    // A public set method for setting the radius of the circle
    public void setRadius (double radius) {
        this.radius = radius;
    }

    // A public set method for setting the center of the circle
    public void setCenter (double ex, double why) {
        x = ex;
        y = why;
    }

    // A public method that overrides the toString method and prints the center coordinates and radius of circle
    @Override
    public String toString() {
        return "This circle is centered at point (" + x + "," + y + ") with radius " + radius; // TODO
    }
}
