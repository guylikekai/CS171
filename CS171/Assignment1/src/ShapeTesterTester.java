public class ShapeTesterTester {
    public static void main(String[] args) {

        //tests ShapeTester default constructor, isLarger, longerPerim#1, longerPerim#2, largerArea#1, largerArea#2
        Circle circle = new Circle(2, 5, 8);
        Rectangle rect = new Rectangle(10, 8, 6, 9);
        ShapeTester test = new ShapeTester();
        System.out.println(test.isLarger(circle, rect));
        System.out.println(test.longerPerim(circle, rect));
        System.out.println(test.longerPerim(rect, circle));
        System.out.println(test.largerArea(circle, rect));
        System.out.println(test.largerArea(rect, circle));

        Circle circle1 = new Circle();
        System.out.println(test.containsCenter(circle, circle1));
    }
}
