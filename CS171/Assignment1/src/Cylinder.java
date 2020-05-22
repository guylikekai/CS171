/*
THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES.
Kaiwen Zhou
*/

// This class represents a cylinder object and extends from the Circle class
public class Cylinder extends Circle {

    // Instance variables (data members) of the class Cylinder
    private double z; //z coordinate of the center of bottom circle of cylinder
    private double height; //height of cylinder in z direction

    // default constructor
    public Cylinder() {
        super();
        z = 0.0;
        height = 1.0;
    }

    // alternate constructor
    public Cylinder(double x, double y, double z, double radius, double height) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.radius = radius;
        this.height = height;
    }

    // A public get method that retrieves height of the cylinder object
    public double getHeight() {
        return height;
    }

    // A public set method that sets the height of cylinder object
    public void setHeight(double height) {
        this.height = height;
    }

    // A public method that calculates and returns the surface of cylinder object
    // (overrides getArea method from Circle class)
    @Override
    public double getArea() {
        return(2 * super.getArea() + 2 * Math.PI * radius * height);
    }

    // A public method that calculates and returns the volume of cylinder object
    public double getVolume() {
        return(super.getArea() * height);
    }
}
