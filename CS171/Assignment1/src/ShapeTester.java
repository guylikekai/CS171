/*
THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES.
Kaiwen Zhou
*/

// This class represents a bunch of tests to perform on rectangle and circles to determine physical relationships
public class ShapeTester {

    //  A public method that takes in a circle and a rectangle and returns true if
    //  circle area is bigger than rectangle area, false otherwise
    public boolean isLarger (Circle circle, Rectangle rect) {
        if (circle.getArea() >= rect.area()) {
            return true;
        } else {
            return false;
        }
    }

    // A public method that takes in a circle and a rectangle and returns the perimeter/circumference that's largest
    public double longerPerim(Circle circle, Rectangle rect) {
        if (circle.getCircumference() > rect.perimeter()) {
            return circle.getCircumference();
        } else {
            return rect.perimeter();
        }
    }

    // A public method that takes in a rectangle and a circle and returns the perimeter/circumference that's largest
    // (overload)
    public double longerPerim(Rectangle rect, Circle circle) {
        if (circle.getCircumference() > rect.perimeter()) {
            return circle.getCircumference();
        } else {
            return rect.perimeter();
        }
    }

    // A public method that takes in a circle and a rectangle and returns the larger of the two areas
    public double largerArea(Circle circle, Rectangle rect) {
        if (circle.getArea() > rect.area()) {
            return circle.getArea();
        } else {
            return rect.area();
        }
    }

    // A public method that takes in a rectangle and a circle and returns the larger of the two areas (overload)
    public double largerArea(Rectangle rect, Circle circle) {
        if (circle.getArea() > rect.area()) {
            return circle.getArea();
        } else {
            return rect.area();
        }
    }

    // A public method that determines whether the center of one circle is within the area of another circle,
    // returns true if true, false otherwise
    public boolean containsCenter(Circle circle1, Circle circle2) {
        double distance = Math.sqrt((circle2.x - circle1.x)*(circle2.x - circle1.x) + (circle2.y - circle1.y) + (circle2.y - circle1.y));
        if (distance < circle1.getRadius()) {
            return true;
        } else {
            return false;
        }
    }

}
