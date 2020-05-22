/*
THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES.
Kaiwen Zhou
*/

// This class represents a rectangle shape
public class Rectangle {

    //Instance variables (data members) of the class rectangle
    private double L; // the length of the rectangle
    private double H; // the height of the rectangle
    private double x; // the x coordinate of the  bottom left corner of the rectangle
    private double y; // the y coordinate of the bottom left corner of the rectangle

    //default constructor
    public Rectangle () {
        L = 1.0;
        H = 1.0;
        x = 0.0;
        y = 0.0;
    }

    //alternate constructor given all variables
    public Rectangle (double Ell, double Eich, double Ex, double Why) {
        L = Ell;
        H = Eich;
        x = Ex;
        y = Why;
    }

    //public get method that retrieves length of rectangle object
    public double getLength() {
        return L;
    }

    //public get method that retrieves height of rectangle object
    public double getHeight() {
        return H;
    }

    //public set method that sets length of rectangle object
    public void setLength(double length) {
        L = length;
    }


    //public set method that sets height of rectangle object
    public void setHeight(double height) {
        H = height;
   }

    //public method that calculates and returns perimeter of rectangle object
    public double perimeter() {
        return 2*L + 2*H;
    }

    //public method that calculates and returns area of rectangle object
    public double area() {
        return L*H;
    }

}